package com.uai.workshop.ejerciciopuerto.barcos;

public class YateLujo extends Barco{

    private int potenciaCV;
    private int cantCamarotes;

    @Override
    public double modulo() {
        return moduloBase() + potenciaCV + cantCamarotes;
    }
}
