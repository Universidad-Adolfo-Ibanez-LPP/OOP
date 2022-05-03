package com.uai.workshop;

import com.uai.workshop.clientes.Cliente;
import com.uai.workshop.clientes.ClienteAdv;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Cliente c1 = new Cliente("Miguel", "Vargas", "25440188-2");
        c1.agregarTelefono(965789862);
        c1.agregarTelefono(965789863);

        System.out.println(c1);

        ClienteAdv c2 = new ClienteAdv("Miguel", "Vargas", "25440188-2");
        c2.agregarTelefono(965789862, "ClARO");
        c2.agregarTelefono(96578983, "Movistar");

        System.out.println(c2);
        System.out.println();
        System.out.println("Tiene el provider: "+c2.hasProvider("claro"));
    }
}
