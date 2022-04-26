package com.uai.workshop.clientes;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombre;
    private String apellido;
    private String RUT;
    private List<Integer> telefonos;

    public Cliente(String nombre, String apellido, String RUT) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.RUT = RUT;
        telefonos = new ArrayList<Integer>();
    }

    public List<Integer> getTelefonos() {
        return telefonos;
    }

    public void agregarTelefono(int telefono){
        this.telefonos.add(telefono);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", RUT='" + RUT + '\'' +
                ", telefonos=" + telefonos +
                '}';
    }
}
