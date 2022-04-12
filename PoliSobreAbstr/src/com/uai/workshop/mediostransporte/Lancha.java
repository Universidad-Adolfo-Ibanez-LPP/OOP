package com.uai.workshop.mediostransporte;


public class Lancha extends MedioTransporte {

    public Lancha(int numeroSerie) {
        super(numeroSerie);
    }

    @Override
    public void andar() {
        System.out.println("Ando en lancha");
    }

}
