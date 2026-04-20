public class Main
{
    public static void main(String[] args) {
        
        
        // ===================== CREACION DE FECHAS =====================
        
        Fecha fecha1 = new Fecha(10, 5, 2025);
        Fecha fecha2 = new Fecha(15, 6, 2025);
        Fecha fecha3 = new Fecha(20, 7, 2025);
        
        
        // ===================== CREACION DE CLIENTES =====================
        
        Cliente cliente1 = new Cliente("Juan", "Garcia", 123456, 1, "3001234567");
        Cliente cliente2 = new Cliente("Maria", "Lopez", 654321, 2, "3109876543");
        
        
        // ===================== CREACION DE CUIDADORES =====================
        
        Cuidador cuidador1 = new Cuidador("Carlos", "Martinez", 111222, 1, "Perros y Gatos");
        Cuidador cuidador2 = new Cuidador("Ana", "Rodriguez", 333444, 2, "Aves y Reptiles");
        
        
        // ===================== CREACION DE MASCOTAS =====================

        Mascota mascota1 = new Mascota("Firulais", "Labrador", 3, false);
        Mascota mascota2 = new Mascota("Michi", "Persa", 2, true);
        Mascota mascota3 = new Mascota("Piolín", "Canario", 1, false);
        
        
        // ===================== CREACION DE RESERVAS =====================
        
        Reserva reserva1 = new Reserva(fecha1, 5, true, true, false, cuidador1);
        Reserva reserva2 = new Reserva(fecha2, 3, false, false, true, cuidador2);
        Reserva reserva3 = new Reserva(fecha3, 7, true, false, true, cuidador1);
        
        
        // ===================== CREACION DE GESTION ASIGNACION =====================
        
        GestionAsignacion asignacion1 = new GestionAsignacion(cuidador1, mascota1, true);
        GestionAsignacion asignacion2 = new GestionAsignacion(cuidador2, mascota2, false);
        
        
        // ===================== CREACION DE VISUALIZADOR =====================
        
        Visualizador myVisualizador = new Visualizador(reserva1, reserva2, reserva3);
        
        
        // ===================== PRUEBAS =====================
        
        System.out.println("========================================");
        System.out.println("           HOTEL PARA MASCOTAS          ");
        System.out.println("========================================");
        
        
        //PRUEBA 1: Mostrar clientes
        
        System.out.println("\n--- CLIENTES REGISTRADOS ---");
        System.out.println(cliente1.toString());
        System.out.println(cliente2.toString());
        
        
        //PRUEBA 2: Mostrar cuidadores
        
        System.out.println("\n--- CUIDADORES REGISTRADOS ---");
        System.out.println(cuidador1.toString());
        System.out.println(cuidador2.toString());
        
        
        //PRUEBA 3: Mostrar mascotas
        
        System.out.println("\n--- MASCOTAS REGISTRADAS ---");
        System.out.println(mascota1.toString());
        System.out.println(mascota2.toString());
        System.out.println(mascota3.toString());
        
        
        //PRUEBA 4: Mostrar servicios de cada reserva
        
        System.out.println("\n--- SERVICIOS DE RESERVAS ---");
        System.out.println(reserva1.mostrarServicios());
        System.out.println("---");
        System.out.println(reserva2.mostrarServicios());
        System.out.println("---");
        System.out.println(reserva3.mostrarServicios());
        
        
        //PRUEBA 5: Asignacion de cuidadores
        
        System.out.println("\n--- ASIGNACION DE CUIDADORES ---");
        System.out.println(asignacion1.asignarCuidador());
        System.out.println(asignacion2.asignarCuidador());
        
        
        //PRUEBA 6: Listar reservas activas
        
        System.out.println("\n--- RESERVAS ACTIVAS ---");
        System.out.println(myVisualizador.listarReservas());
        
        
        System.out.println("\n========================================");
        System.out.println("           FIN DEL SISTEMA              ");
        System.out.println("========================================");
        
    }
}