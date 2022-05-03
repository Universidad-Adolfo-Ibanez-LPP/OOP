package com.uai.app;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println("COMENZANDO");
        String fileName = args[0];

        List<Persona> beans = null;
        try {
            File f = new File(fileName);
            FileReader ff = new FileReader(f, Charset.forName("UTF-8"));
            beans = new CsvToBeanBuilder(ff)
                    .withType(Persona.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            System.err.println("No existe el archivo");
        } catch (IOException e) {
            System.err.println("No se puede leer el archivo");
        }


        Collections.sort(beans);

        for (Persona p : beans){
            System.out.println(p);
        }

        CSVWriter writer = new CSVWriter(new FileWriter(fileName));
    }
}
