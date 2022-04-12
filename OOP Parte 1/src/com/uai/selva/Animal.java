package com.uai.selva;

public class Animal {

    String nombre = " ";

    //CONSTRUCTOR
    public Animal(String nombre){
        this.nombre = nombre;
    }

    protected void sayMyName(){
        System.out.println("Mi nombre es: "+nombre);
    }

    public String getNombre() {
        return nombre;
    }
}
