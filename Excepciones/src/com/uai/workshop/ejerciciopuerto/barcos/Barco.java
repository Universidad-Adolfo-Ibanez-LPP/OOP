package com.uai.workshop.ejerciciopuerto.barcos;

public abstract class Barco {

    protected String matricula;
    protected int slora;
    protected int año;

    private final int PESETAS = 1200;

    public abstract double modulo();

    protected int moduloBase(){
        return 10*slora*PESETAS;
    }
}
