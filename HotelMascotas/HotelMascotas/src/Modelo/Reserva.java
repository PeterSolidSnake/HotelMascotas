/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Reserva {
    
    private Fecha fechaIngreso;
    private Fecha fechaSalida;
    private int diasEstadia;
    private List<Servicio> serviciosADD;

    public Reserva() {
    }

    public Reserva(Fecha fechaIngreso, Fecha fechaSalida, int diasEstadia, Servicio serviciosAdd) {
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.diasEstadia = diasEstadia;
        this.serviciosADD = new ArrayList<>();
    }

    public Fecha getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Fecha fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Fecha getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Fecha fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getDiasEstadia() {
        return diasEstadia;
    }

    public void setDiasEstadia(int diasEstadia) {
        this.diasEstadia = diasEstadia;
    }

    public List<Servicio> getServiciosAdd() {
        return serviciosADD;
        } 
    
    // Calcula la fecha de salida sumando diasEstadia a fechaIngreso
    public void calcularFechaSalida() {
        if (fechaIngreso != null) {
            int diaTotal = fechaIngreso.getDia() + diasEstadia;
            int mes = fechaIngreso.getMes();
            int año = fechaIngreso.getAño();
            // Ajuste simple de días (asume 30 días por mes)
            while (diaTotal > 30) {
                diaTotal -= 30;
                mes++;
                if (mes > 12) {
                    mes = 1;
                    año++;
                }
            }
            this.fechaSalida = new Fecha(diaTotal, mes, año);
        }
    }
 
    // Agrega un servicio adicional a la reserva
    public void agregarServicio(Servicio servicio) {
        serviciosADD.add(servicio);
        System.out.println("Servicio agregado: " + servicio);
    }
 
    public void mostrarReserva() {
        System.out.println("Ingreso: " + fechaIngreso.getDia() + "/" + fechaIngreso.getMes() + "/" + fechaIngreso.getAño());
        System.out.println("Dias de estadia: " + diasEstadia);
        if (fechaSalida != null) {
            System.out.println("Salida: " + fechaSalida.getDia() + "/" + fechaSalida.getMes() + "/" + fechaSalida.getAño());
        }
        System.out.println("Servicios: " + serviciosADD);
    }
    }
    
    

 
