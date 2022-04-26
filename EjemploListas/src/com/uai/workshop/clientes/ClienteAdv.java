package com.uai.workshop.clientes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ClienteAdv {

    private String nombre;
    private String apellido;
    private String RUT;
    private List<Telefono> telefonos;

    public ClienteAdv(String nombre, String apellido, String RUT) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.RUT = RUT;
        telefonos = new LinkedList<Telefono>();
    }

    public void agregarTelefono(int number, String provider){
        Telefono tel = new Telefono(number, provider);
        this.telefonos.add(tel);
    }

    public boolean hasProvider(String provider){
        for (Telefono tel : telefonos){
            if (tel.getProvider().equalsIgnoreCase(provider)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "ClienteAdv{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", RUT='" + RUT + '\'' +
                ", telefonos=" + telefonos +
                '}';
    }
}
