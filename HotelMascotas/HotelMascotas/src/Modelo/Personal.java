/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Pc
 */
public class Personal extends Usuario{
    
    public Personal(String nombre, String cedula,String edad) {
    super(nombre, cedula,edad); // Esto llama al constructor de Usuario
}
    public void mostrarPerfil() {
        System.out.println("Nombre: " + getNombre() + " Cedula: " + getCedula());
    }
    
}
