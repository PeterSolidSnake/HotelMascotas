/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Pc
 */
public class Administrador extends Personal{
    
    public Administrador(String nombre, String cedula,String edad) {
    super(nombre, cedula,edad); // Esto llama al constructor de Usuario
}
    public void gestionarReservas() {
        System.out.println("Administrador " + getNombre() + " gestionando reservas.");
    }
 
    public void asignarCuidador() {
        System.out.println("Administrador " + getNombre() + " asignando cuidador.");
    }
    
}
