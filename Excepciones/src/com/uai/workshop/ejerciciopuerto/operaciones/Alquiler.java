package com.uai.workshop.ejerciciopuerto.operaciones;

import com.uai.workshop.ejerciciopuerto.Cliente;
import com.uai.workshop.ejerciciopuerto.barcos.Barco;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

public class Alquiler {

    private Cliente cliente;
    private LocalDateTime fechaOrigen;
    private LocalDateTime fechaFin;
    private int pos;
    private Barco barco;

    public Alquiler(Cliente cliente, LocalDateTime fechaOrigen, LocalDateTime fechaFin, int pos, Barco barco) {
        this.cliente = cliente;
        this.fechaOrigen = fechaOrigen;
        this.fechaFin = fechaFin;
        this.pos = pos;
        this.barco = barco;
    }

    public double calcularAlquiler(){
        long days = Duration.between(fechaOrigen, fechaFin).toDays();
        return days*this.barco.modulo();
    }

}
