package com.uai.workshop.mediostransporte;

public class Bici extends MedioTransporte {

    public Bici(int numeroSerie) {
        super(numeroSerie);
    }

    @Override
    public void showInfo() {
        super.showInfo("Bici");
    }

    @Override
    public void andar() {
        System.out.println("Ando en bici");
    }
}
