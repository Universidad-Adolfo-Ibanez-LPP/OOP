package com.uai.workshop.clientes;

public class Telefono {

    private int number;
    private String provider;

    public Telefono(int number, String provider) {
        this.number = number;
        this.provider = provider;
    }

    public int getNumber() {
        return number;
    }

    public String getProvider() {
        return provider;
    }

    @Override
    public String toString() {
        return "Telefono{" +
                "number=" + number +
                ", provider='" + provider + '\'' +
                '}';
    }
}
