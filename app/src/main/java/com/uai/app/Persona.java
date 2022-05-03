package com.uai.app;

import com.opencsv.bean.CsvBindByName;

public class Persona implements Comparable<Persona>{

    @CsvBindByName(column = "name")
    private String name;

    @CsvBindByName(column = "address")
    private String address;

    @CsvBindByName(column = "country")
    private String country;

    @CsvBindByName(column = "cost")
    private int cost;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int compareTo(Persona o) {
        return this.name.compareTo(o.getName())*-1;
    }
}
