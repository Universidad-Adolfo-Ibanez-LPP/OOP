package com.uai.workshop;

import com.uai.workshop.ejerciciopuerto.Puerto;
import com.uai.workshop.ejerciciopuerto.exceptions.SameDayRentException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner scanner;

    public static void main(String[] args) {
	// write your code here
        Puerto puerto = new Puerto();

        String fechaOrigen = "12 04 2022";
        String fechaDest = "13 04 2022";

        try {
            puerto.generarAlquiler(fechaOrigen, fechaDest);
        } catch (SameDayRentException e) {
            e.printStackTrace();
        }

    }
}
