package Vista;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class JFSistemaHotel extends JFrame {

    public JTextField txtNombreCliente;
    public JTextField txtCedulaCliente;
    public JTextField txtEdadCliente;
    public JTextField txtTlfCliente;

    public JButton btnGuardarCliente;
    public JButton btnRegistrarMascota;
    public JButton btnReservasActivas;
    public JButton btnPersonalDisponible;
    public JButton btnMostrarReservas;
    public JButton btnFinalizarProgram;

    public JTextArea AreaResultsCliente;

    public JFSistemaHotel() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Hotel de Mascotas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        Font labelFont = new Font("SansSerif", Font.PLAIN, 13);
        Font fieldFont = new Font("SansSerif", Font.PLAIN, 12);
        Font btnFont   = new Font("SansSerif", Font.PLAIN, 12);
        Dimension fieldSize = new Dimension(180, 26);

        // ── Panel Registro de Cliente ───────────────────────────────────────
        JPanel panelCliente = new JPanel(new GridBagLayout());
        panelCliente.setBorder(new TitledBorder("Registro de Cliente"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 10, 6, 10);
        gbc.fill   = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        int row = 0;

        gbc.gridx = 0; gbc.gridy = row; gbc.weightx = 0;
        panelCliente.add(lbl("Nombre:", labelFont), gbc);
        gbc.gridx = 1; gbc.weightx = 1;
        txtNombreCliente = field(fieldFont, fieldSize);
        panelCliente.add(txtNombreCliente, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row; gbc.weightx = 0;
        panelCliente.add(lbl("Cedula:", labelFont), gbc);
        gbc.gridx = 1; gbc.weightx = 1;
        txtCedulaCliente = field(fieldFont, fieldSize);
        panelCliente.add(txtCedulaCliente, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row; gbc.weightx = 0;
        panelCliente.add(lbl("Edad:", labelFont), gbc);
        gbc.gridx = 1; gbc.weightx = 1;
        txtEdadCliente = field(fieldFont, fieldSize);
        panelCliente.add(txtEdadCliente, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row; gbc.weightx = 0;
        panelCliente.add(lbl("Telefono:", labelFont), gbc);
        gbc.gridx = 1; gbc.weightx = 1;
        txtTlfCliente = field(fieldFont, fieldSize);
        panelCliente.add(txtTlfCliente, gbc);

        // ── Panel Botones ───────────────────────────────────────────────────
        btnGuardarCliente     = btn("Guardar Cliente",    btnFont);
        btnRegistrarMascota   = btn("Registrar Mascota",  btnFont);
        btnReservasActivas    = btn("Reservas Activas",   btnFont);
        btnPersonalDisponible = btn("Mostrar Personal",   btnFont);
        btnMostrarReservas    = btn("Mostrar Reservas",   btnFont);
        btnFinalizarProgram   = btn("Finalizar",          btnFont);

        JPanel panelBotones = new JPanel(new GridLayout(3, 2, 8, 8));
        panelBotones.setBorder(new TitledBorder("Acciones"));
        panelBotones.add(btnGuardarCliente);
        panelBotones.add(btnMostrarReservas);
        panelBotones.add(btnRegistrarMascota);
        panelBotones.add(btnPersonalDisponible);
        panelBotones.add(btnReservasActivas);
        panelBotones.add(btnFinalizarProgram);

        // ── Panel superior ──────────────────────────────────────────────────
        JPanel panelSuperior = new JPanel(new GridBagLayout());
        GridBagConstraints gbcS = new GridBagConstraints();
        gbcS.insets  = new Insets(10, 10, 6, 10);
        gbcS.fill    = GridBagConstraints.BOTH;
        gbcS.weighty = 1;

        gbcS.gridx = 0; gbcS.weightx = 0.45;
        panelSuperior.add(panelCliente, gbcS);
        gbcS.gridx = 1; gbcS.weightx = 0.55;
        panelSuperior.add(panelBotones, gbcS);

        // ── Panel Resultados ────────────────────────────────────────────────
        AreaResultsCliente = new JTextArea(6, 55);
        AreaResultsCliente.setEditable(false);
        AreaResultsCliente.setFont(new Font("Monospaced", Font.PLAIN, 12));
        AreaResultsCliente.setLineWrap(true);
        AreaResultsCliente.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(AreaResultsCliente);
        scroll.setBorder(new TitledBorder("Resultados"));

        JPanel panelInf = new JPanel(new BorderLayout());
        panelInf.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        panelInf.add(scroll, BorderLayout.CENTER);

        // ── Layout principal ────────────────────────────────────────────────
        JPanel main = new JPanel(new BorderLayout(0, 4));
        main.add(panelSuperior, BorderLayout.CENTER);
        main.add(panelInf,      BorderLayout.SOUTH);

        setContentPane(main);
        pack();
        setLocationRelativeTo(null);
    }

    private JLabel lbl(String text, Font f) {
        JLabel l = new JLabel(text);
        l.setFont(f);
        return l;
    }

    private JTextField field(Font f, Dimension d) {
        JTextField tf = new JTextField();
        tf.setFont(f);
        tf.setPreferredSize(d);
        return tf;
    }

    private JButton btn(String text, Font f) {
        JButton b = new JButton(text);
        b.setFont(f);
        b.setFocusPainted(false);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return b;
    }
}