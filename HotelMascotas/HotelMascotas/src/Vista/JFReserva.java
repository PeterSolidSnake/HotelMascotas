package Vista;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class JFReserva extends JFrame {

    public JComboBox<String> cmbBoxDueño;
    public JTextField txtNameMascota;
    public JTextField txtRaza;
    public JTextField txtEdadPerro;
    public JComboBox<String> cmbBoxNecesidades;
    public JTextField txtFechaIngreso;
    public JTextField txtDiasEstadia;

    public JButton btnGuardar;
    public JButton btnLimpiar;
    public JButton btnVolverCliente;

    public JTextArea AreaAnimal;

    public JFReserva() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Registro de Reserva");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        Font labelFont = new Font("SansSerif", Font.PLAIN, 13);
        Font fieldFont = new Font("SansSerif", Font.PLAIN, 12);
        Font btnFont   = new Font("SansSerif", Font.PLAIN, 12);
        Dimension fieldSize = new Dimension(170, 26);

        // ── Panel datos ─────────────────────────────────────────────────────
        JPanel panelDatos = new JPanel(new GridBagLayout());
        panelDatos.setBorder(new TitledBorder("Datos de la Mascota y la Reserva"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill   = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        int row = 0;

        gbc.gridx = 0; gbc.gridy = row; gbc.weightx = 0;
        panelDatos.add(lbl("Dueño del Perro:", labelFont), gbc);
        gbc.gridx = 1; gbc.weightx = 1;
        cmbBoxDueño = new JComboBox<>();
        cmbBoxDueño.setFont(fieldFont);
        cmbBoxDueño.setPreferredSize(fieldSize);
        panelDatos.add(cmbBoxDueño, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row; gbc.weightx = 0;
        panelDatos.add(lbl("Nombre de la Mascota:", labelFont), gbc);
        gbc.gridx = 1; gbc.weightx = 1;
        txtNameMascota = field(fieldFont, fieldSize);
        panelDatos.add(txtNameMascota, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row; gbc.weightx = 0;
        panelDatos.add(lbl("Raza del Perro:", labelFont), gbc);
        gbc.gridx = 1; gbc.weightx = 1;
        txtRaza = field(fieldFont, fieldSize);
        panelDatos.add(txtRaza, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row; gbc.weightx = 0;
        panelDatos.add(lbl("Edad del Perro:", labelFont), gbc);
        gbc.gridx = 1; gbc.weightx = 1;
        txtEdadPerro = field(fieldFont, fieldSize);
        panelDatos.add(txtEdadPerro, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row; gbc.weightx = 0;
        panelDatos.add(lbl("Necesidades Especiales:", labelFont), gbc);
        gbc.gridx = 1; gbc.weightx = 1;
        cmbBoxNecesidades = new JComboBox<>();
        cmbBoxNecesidades.setFont(fieldFont);
        cmbBoxNecesidades.setPreferredSize(fieldSize);
        panelDatos.add(cmbBoxNecesidades, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row; gbc.weightx = 0;
        panelDatos.add(lbl("Fecha de Ingreso:", labelFont), gbc);
        gbc.gridx = 1; gbc.weightx = 1;
        txtFechaIngreso = field(fieldFont, fieldSize);
        txtFechaIngreso.setToolTipText("Formato DD/MM/YYYY");
        panelDatos.add(txtFechaIngreso, gbc);

        row++;
        gbc.gridx = 1; gbc.gridy = row;
        JLabel hint = new JLabel("DD/MM/YYYY");
        hint.setFont(new Font("SansSerif", Font.ITALIC, 10));
        hint.setForeground(Color.GRAY);
        panelDatos.add(hint, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row; gbc.weightx = 0;
        panelDatos.add(lbl("Dias de Estadia:", labelFont), gbc);
        gbc.gridx = 1; gbc.weightx = 1;
        txtDiasEstadia = field(fieldFont, fieldSize);
        panelDatos.add(txtDiasEstadia, gbc);

        // ── Panel botones ───────────────────────────────────────────────────
        btnGuardar       = btn("Guardar",       btnFont);
        btnLimpiar       = btn("Limpiar",       btnFont);
        btnVolverCliente = btn("Volver Atras",  btnFont);

        JPanel panelBotones = new JPanel(new GridLayout(3, 1, 0, 8));
        panelBotones.setBorder(new TitledBorder("Acciones"));
        panelBotones.add(btnGuardar);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnVolverCliente);

        // ── Panel superior ──────────────────────────────────────────────────
        JPanel panelSuperior = new JPanel(new GridBagLayout());
        GridBagConstraints gbcS = new GridBagConstraints();
        gbcS.insets  = new Insets(10, 10, 6, 10);
        gbcS.fill    = GridBagConstraints.BOTH;
        gbcS.weighty = 1;

        gbcS.gridx = 0; gbcS.weightx = 0.65;
        panelSuperior.add(panelDatos, gbcS);
        gbcS.gridx = 1; gbcS.weightx = 0.35;
        panelSuperior.add(panelBotones, gbcS);

        // ── Panel resultado ─────────────────────────────────────────────────
        AreaAnimal = new JTextArea(5, 50);
        AreaAnimal.setEditable(false);
        AreaAnimal.setFont(new Font("Monospaced", Font.PLAIN, 12));
        AreaAnimal.setLineWrap(true);
        AreaAnimal.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(AreaAnimal);
        scroll.setBorder(new TitledBorder("Datos de la Reserva"));

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