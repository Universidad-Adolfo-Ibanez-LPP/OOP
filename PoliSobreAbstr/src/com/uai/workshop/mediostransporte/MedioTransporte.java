package com.uai.workshop.mediostransporte;

public abstract class MedioTransporte  {

    private int numeroSerie;

    static int CANT_MEDIO_TRANSPORTE;

    public MedioTransporte(int numeroSerie) {
        this.numeroSerie = numeroSerie;
        MedioTransporte.CANT_MEDIO_TRANSPORTE++;
    }

    public static int getCantMedioTransporte(){
        return MedioTransporte.CANT_MEDIO_TRANSPORTE;
    }

    public abstract void andar();

    public void showInfo(){
        System.out.println(this.numeroSerie);
    }

    public void showInfo(String tipo){
        System.out.println(tipo+": "+this.numeroSerie);
    }
}
