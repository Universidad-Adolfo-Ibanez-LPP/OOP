package com.uai.app;

import com.uai.app.dominio.Noticia;
import com.uai.app.exceptions.CSVNotFoundException;
import com.uai.app.files.FileManager;
import com.uai.app.logic.DataManager;
import com.uai.app.logic.parsers.LaTerceraParser;

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
            //Obtengo las noticias del disco
            HashSet<Noticia> noticiasDisco = f.getData();

            // UIBuilder.buildMainUI(MainMenuUI.class);

            //trato de obtener las noticias desde la red
            LaTerceraParser parser = new LaTerceraParser();
            HashSet<Noticia> noticiasRed = parser.getNoticias();

            //las mezclo a ambas
            noticiasDisco.addAll(noticiasRed);

            //instancio y seteo la data mezcladas
            DataManager.getInstance().setData(noticiasDisco);

            //finalizo guardando la data
            f.saveData();
        } catch (CSVNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
