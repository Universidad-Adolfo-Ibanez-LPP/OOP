package com.uai.workshop;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner scanner;

    public static void main(String[] args) {
	// write your code here
        scanner = new Scanner(System.in);

        int x1, x2;
        double rta;

        try {
            System.out.println("Ingrese dos numeros");
            x1 = scanner.nextInt();
            x2 = scanner.nextInt();
            rta = x1/x2;
            System.out.println("Resultado: "+rta);
        } catch (Exception e) {
            System.err.println("Se produjo un error");
        }

    }
}
