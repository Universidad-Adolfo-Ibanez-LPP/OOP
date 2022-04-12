package com.uai.workshop.mediostransporte;

public class Auto extends MedioTransporte implements IAnfibio{


    public Auto(int numeroSerie) {
        super(numeroSerie);
    }

    @Override
    public void andar() {
        System.out.println("Ando en auto");
    }

    @Override
    public void nadar() {
        System.out.println("Estoy nadando");
    }
}
