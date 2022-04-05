package com.uai.workshop;

import com.uai.selva.animalesdomesticos.Perro;


public class Main {

    public static void main(String[] args) {
	    Perro p1 = new Perro("Tommy");
        Perro p2 = new Perro();
        Perro p3 = new Perro("Pete", 4, "Bulldog", "blanco");

        p1.setCantPatas(3);
        p1.setColor("Negro");
        p1.setRaza("Chiguagua");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

       // p1.ladrar();
        //p2.ladrar();
       // p3.ladrar();
    }
}
