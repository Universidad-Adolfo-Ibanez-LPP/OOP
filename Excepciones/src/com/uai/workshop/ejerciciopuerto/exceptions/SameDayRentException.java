package com.uai.workshop.ejerciciopuerto.exceptions;

public class SameDayRentException extends Exception {

    public SameDayRentException() {
        super("No se puede generar alquileres por el mismo dia");
    }
}
