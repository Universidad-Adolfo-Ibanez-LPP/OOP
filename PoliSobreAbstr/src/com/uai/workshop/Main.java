package com.uai.workshop;

import com.uai.workshop.mediostransporte.*;

public class Main {

    public static int getRandomInt(){
        Double d = Math.random()*1000;
        return d.intValue();
    }

    public static void main(String[] args) {
	// write your code here
        MedioTransporte[] mediostransporte = new MedioTransporte[3];

        mediostransporte[0] = new Auto(getRandomInt());
        mediostransporte[1] = new Lancha(getRandomInt());
        mediostransporte[2] = new Bici(getRandomInt());

        for (int i = 0; i < mediostransporte.length ; i++){
            mediostransporte[i].showInfo();
            mediostransporte[i].andar();
            if (mediostransporte[i] instanceof IAnfibio){
                IAnfibio nadador = (IAnfibio) mediostransporte[i];
                nadador.nadar();
            }
        }

        SoundManager sd = SoundManager.getInstance();

        System.out.println("Total de medios de transporte creados "+MedioTransporte.getCantMedioTransporte());


    }
}
