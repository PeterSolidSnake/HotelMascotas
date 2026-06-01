package hotelmascotas;

import Vista.JFSistemaHotel;
import Controlador.ControladorSistemaH;
import javax.swing.SwingUtilities;

public class HotelMascotas {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFSistemaHotel ventana = new JFSistemaHotel();
            new ControladorSistemaH(ventana);
            ventana.setVisible(true);
        });
    }
}