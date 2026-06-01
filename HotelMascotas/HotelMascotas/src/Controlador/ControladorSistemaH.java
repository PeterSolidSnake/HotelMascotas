package Controlador;

import Vista.JFSistemaHotel;
import Vista.JFReserva;
import Modelo.Cliente;
import Modelo.Cuidador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ControladorSistemaH implements ActionListener {

    private JFSistemaHotel frmSistemaHotel;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Cuidador> listaCuidadores;
    private ControladorReserva controladorReserva;

    public ControladorSistemaH(JFSistemaHotel frmSistemaHotel) {
        this.frmSistemaHotel = frmSistemaHotel;
        this.listaClientes   = new ArrayList<>();
        this.listaCuidadores = new ArrayList<>();

        // Cuidadores de ejemplo
        listaCuidadores.add(new Cuidador(3, "Disponible", "Perros grandes", "Carlos Ruiz",   "CC001", "30"));
        listaCuidadores.add(new Cuidador(5, "Disponible", "Perros pequenos", "Maria Lopez",  "CC002", "28"));
        listaCuidadores.add(new Cuidador(1, "No disponible", "Gatos",        "Pedro Gomez",  "CC003", "25"));

        frmSistemaHotel.btnGuardarCliente.addActionListener(this);
        frmSistemaHotel.btnRegistrarMascota.addActionListener(this);
        frmSistemaHotel.btnReservasActivas.addActionListener(this);
        frmSistemaHotel.btnPersonalDisponible.addActionListener(this);
        frmSistemaHotel.btnMostrarReservas.addActionListener(this);
        frmSistemaHotel.btnFinalizarProgram.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmSistemaHotel.btnGuardarCliente) {
            guardarCliente();
        } else if (e.getSource() == frmSistemaHotel.btnRegistrarMascota) {
            abrirReserva();
        } else if (e.getSource() == frmSistemaHotel.btnReservasActivas) {
            mostrarReservasActivas();
        } else if (e.getSource() == frmSistemaHotel.btnPersonalDisponible) {
            mostrarPersonalDisponible();
        } else if (e.getSource() == frmSistemaHotel.btnMostrarReservas) {
            mostrarTodasReservas();
        } else if (e.getSource() == frmSistemaHotel.btnFinalizarProgram) {
            System.exit(0);
        }
    }

    private void guardarCliente() {
        String nombre = frmSistemaHotel.txtNombreCliente.getText().trim();
        String cedula = frmSistemaHotel.txtCedulaCliente.getText().trim();
        String edad   = frmSistemaHotel.txtEdadCliente.getText().trim();
        String tlf    = frmSistemaHotel.txtTlfCliente.getText().trim();

        if (nombre.isEmpty() || cedula.isEmpty() || edad.isEmpty() || tlf.isEmpty()) {
            frmSistemaHotel.AreaResultsCliente.setText("Por favor complete todos los campos del cliente.");
            return;
        }

        // Verificar cedula duplicada
        for (Cliente c : listaClientes) {
            if (c.getCedula().equals(cedula)) {
                frmSistemaHotel.AreaResultsCliente.setText("Ya existe un cliente registrado con esa cedula.");
                return;
            }
        }

        Cliente nuevo = new Cliente(nombre, cedula, edad);
        listaClientes.add(nuevo);

        frmSistemaHotel.AreaResultsCliente.setText(
            "Cliente registrado exitosamente:\n" +
            "Nombre : " + nombre + "\n" +
            "Cedula : " + cedula + "\n" +
            "Edad   : " + edad   + "\n" +
            "Telefono: " + tlf
        );
        limpiarCamposCliente();
    }

    private void abrirReserva() {
        if (listaClientes.isEmpty()) {
            frmSistemaHotel.AreaResultsCliente.setText("Debe registrar al menos un cliente antes de hacer una reserva.");
            return;
        }
        JFReserva frmReserva = new JFReserva();
        frmReserva.setVisible(true);
        controladorReserva = new ControladorReserva(frmReserva, listaClientes, this);
    }

    private void mostrarReservasActivas() {
        if (controladorReserva == null || controladorReserva.getReservasTexto().isEmpty()) {
            frmSistemaHotel.AreaResultsCliente.setText("No hay reservas activas registradas.");
            return;
        }
        frmSistemaHotel.AreaResultsCliente.setText(
            "=== Reservas Activas ===\n" + controladorReserva.getReservasTexto()
        );
    }

    private void mostrarTodasReservas() {
        mostrarReservasActivas();
    }

    private void mostrarPersonalDisponible() {
        StringBuilder sb = new StringBuilder("=== Personal Disponible ===\n");
        boolean hayDisponible = false;
        for (Cuidador c : listaCuidadores) {
            if (c.getDisponibilidad().equalsIgnoreCase("Disponible")) {
                sb.append("Nombre       : ").append(c.getNombre()).append("\n");
                sb.append("Especialidad : ").append(c.getEspecialidad()).append("\n");
                sb.append("Experiencia  : ").append(c.getAñosExp()).append(" años\n");
                sb.append("---------------------------\n");
                hayDisponible = true;
            }
        }
        if (!hayDisponible) sb.append("No hay personal disponible en este momento.");
        frmSistemaHotel.AreaResultsCliente.setText(sb.toString());
    }

    public void actualizarAreaResultados(String texto) {
        frmSistemaHotel.AreaResultsCliente.setText(texto);
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    private void limpiarCamposCliente() {
        frmSistemaHotel.txtNombreCliente.setText("");
        frmSistemaHotel.txtCedulaCliente.setText("");
        frmSistemaHotel.txtEdadCliente.setText("");
        frmSistemaHotel.txtTlfCliente.setText("");
    }
}