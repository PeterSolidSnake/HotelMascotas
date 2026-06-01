package Controlador;

import Vista.JFReserva;
import Modelo.Cliente;
import Modelo.Fecha;
import Modelo.Mascota;
import Modelo.Reserva;
import Modelo.Servicio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class ControladorReserva implements ActionListener {

    private JFReserva frmReserva;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Reserva> listaReservas;
    private ControladorSistemaH controladorPrincipal;

    public ControladorReserva(JFReserva frmReserva, ArrayList<Cliente> listaClientes, ControladorSistemaH controladorPrincipal) {
        this.frmReserva           = frmReserva;
        this.listaClientes        = listaClientes;
        this.listaReservas        = new ArrayList<>();
        this.controladorPrincipal = controladorPrincipal;

        frmReserva.btnGuardar.addActionListener(this);
        frmReserva.btnLimpiar.addActionListener(this);
        frmReserva.btnVolverCliente.addActionListener(this);

        cargarComboDueño();
        cargarComboNecesidades();
    }

    private void cargarComboDueño() {
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        for (Cliente c : listaClientes) {
            modelo.addElement(c.getNombre() + " - " + c.getCedula());
        }
        frmReserva.cmbBoxDueño.setModel(modelo);
    }

    private void cargarComboNecesidades() {
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        for (Servicio s : Servicio.values()) {
            modelo.addElement(s.name());
        }
        frmReserva.cmbBoxNecesidades.setModel(modelo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmReserva.btnGuardar) {
            guardarReserva();
        } else if (e.getSource() == frmReserva.btnLimpiar) {
            limpiarCampos();
        } else if (e.getSource() == frmReserva.btnVolverCliente) {
            frmReserva.dispose();
        }
    }

    private void guardarReserva() {
        String nombreMascota = frmReserva.txtNameMascota.getText().trim();
        String raza          = frmReserva.txtRaza.getText().trim();
        String edadPerro     = frmReserva.txtEdadPerro.getText().trim();
        String fechaTxt      = frmReserva.txtFechaIngreso.getText().trim();
        String diasTxt       = frmReserva.txtDiasEstadia.getText().trim();
        String necesidad     = (String) frmReserva.cmbBoxNecesidades.getSelectedItem();
        String dueñoSel      = (String) frmReserva.cmbBoxDueño.getSelectedItem();

        if (nombreMascota.isEmpty() || raza.isEmpty() || edadPerro.isEmpty()
                || fechaTxt.isEmpty() || diasTxt.isEmpty()) {
            frmReserva.AreaAnimal.setText("Por favor complete todos los campos.");
            return;
        }

        // Parsear fecha DD/MM/YYYY
        try {
            String[] partes = fechaTxt.split("/");
            if (partes.length != 3) throw new NumberFormatException();
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int año = Integer.parseInt(partes[2]);
            int dias = Integer.parseInt(diasTxt);

            Fecha fechaIngreso = new Fecha(dia, mes, año);
            Servicio servicio  = Servicio.valueOf(necesidad);
            Mascota mascota    = new Mascota(nombreMascota, raza, edadPerro, necesidad);
            Reserva reserva    = new Reserva(fechaIngreso, null, dias, servicio);
            reserva.calcularFechaSalida();
            reserva.agregarServicio(servicio);

            listaReservas.add(reserva);

            Fecha salida = reserva.getFechaSalida();
            String resultado =
                "Reserva registrada:\n" +
                "Mascota    : " + nombreMascota + "\n" +
                "Raza       : " + raza + "\n" +
                "Edad       : " + edadPerro + "\n" +
                "Dueno      : " + dueñoSel + "\n" +
                "Necesidad  : " + necesidad + "\n" +
                "Ingreso    : " + dia + "/" + mes + "/" + año + "\n" +
                "Dias       : " + dias + "\n" +
                "Salida     : " + salida.getDia() + "/" + salida.getMes() + "/" + salida.getAño();

            frmReserva.AreaAnimal.setText(resultado);
            controladorPrincipal.actualizarAreaResultados("Reserva para '" + nombreMascota + "' registrada exitosamente.");
            limpiarCampos();

        } catch (NumberFormatException ex) {
            frmReserva.AreaAnimal.setText("Fecha invalida. Use el formato DD/MM/YYYY y asegurese que los dias sean un numero.");
        } catch (IllegalArgumentException ex) {
            frmReserva.AreaAnimal.setText("Servicio no reconocido.");
        }
    }

    public String getReservasTexto() {
        if (listaReservas.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Reserva r : listaReservas) {
            Fecha fi = r.getFechaIngreso();
            Fecha fs = r.getFechaSalida();
            sb.append("Reserva #").append(i++).append("\n");
            sb.append("  Ingreso : ").append(fi.getDia()).append("/").append(fi.getMes()).append("/").append(fi.getAño()).append("\n");
            if (fs != null) {
                sb.append("  Salida  : ").append(fs.getDia()).append("/").append(fs.getMes()).append("/").append(fs.getAño()).append("\n");
            }
            sb.append("  Dias    : ").append(r.getDiasEstadia()).append("\n");
            sb.append("  Servicios: ").append(r.getServiciosAdd()).append("\n\n");
        }
        return sb.toString();
    }

    private void limpiarCampos() {
        frmReserva.txtNameMascota.setText("");
        frmReserva.txtRaza.setText("");
        frmReserva.txtEdadPerro.setText("");
        frmReserva.txtFechaIngreso.setText("");
        frmReserva.txtDiasEstadia.setText("");
    }
}