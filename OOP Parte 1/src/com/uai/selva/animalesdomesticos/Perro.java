package com.uai.selva.animalesdomesticos;

import com.uai.selva.Animal;

public class Perro extends Animal {

    //Atributos
    int cantPatas;
    String raza;
    String color;

    public Perro(String nombre){
        super(nombre);
    }

    public Perro(){
        super("Boby");
    }

    public Perro(String nombre, int cantPatas, String raza, String color) {
        super(nombre);
        this.cantPatas = cantPatas;
        this.raza = raza;
        this.color = color;
    }

    //comportamiento
    public void ladrar(){
        sayMyName();
        System.out.println("gau gau");
    }

    public int getCantPatas() {
        return cantPatas;
    }

    public String getRaza() {
        return raza;
    }

    public String getColor() {
        return color;
    }

    public void setCantPatas(int cantPatas) {
        this.cantPatas = cantPatas;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Perro nombre:"+this.getNombre();
    }
}
