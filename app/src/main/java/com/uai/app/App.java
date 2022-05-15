package com.uai.app;

import com.uai.app.dominio.Persona;
import com.uai.app.dominio.enums.Tittles;
import com.uai.app.exceptions.CSVNotFoundException;
import com.uai.app.files.FileManager;
import com.uai.app.logic.DataManager;
import com.uai.app.logic.SearchManager;
import com.uai.app.ui.utils.UIBuilder;

import java.io.*;
import java.util.HashSet;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) throws IOException {
        System.out.println("COMENZANDO");
        String fileName = args[0];

        try {
            //instancio el file manager
            FileManager f = new FileManager(fileName);
            //instancio y seteo la data
            DataManager.getInstance().setData(f.getData());

            HashSet<Persona> resultados = SearchManager.getInstance().findPersonByAttribute(Tittles.NAME, "Mary");

            DataManager.getInstance().removerPersonas(resultados);

            f.saveData();
        } catch (CSVNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Terminado");

    }
}
