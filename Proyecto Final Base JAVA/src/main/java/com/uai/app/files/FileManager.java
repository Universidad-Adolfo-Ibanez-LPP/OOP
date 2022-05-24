package com.uai.app.files;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.uai.app.dominio.Noticia;
import com.uai.app.logic.DataManager;

import com.uai.app.exceptions.CSVNotFoundException;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.List;

import static com.opencsv.ICSVWriter.*;

public class FileManager {

    private File theFile;

    private String[] titles = {"texto","link","icono","fecha", "fuente"};
    /*
    Reviso si existe el archivo que me van a hacer ocupar
    y sino tiro una excepcion para arriba
     */
    public FileManager(String fileName) throws CSVNotFoundException {
        this.theFile = new File(fileName);
        if (!theFile.exists()){
            throw new CSVNotFoundException();
        }
    }

    public HashSet<Noticia> getData() {
        List<Noticia> beans = null;
        try {
            FileReader ff = new FileReader(theFile, Charset.forName("UTF-8"));
            beans = new CsvToBeanBuilder(ff)
                    .withType(Noticia.class)
                    .withSeparator('|')
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            System.err.println("No existe el archivo");
        } catch (IOException e) {
            System.err.println("No se puede leer el archivo");
        }
      //  Collections.sort(beans);
        HashSet<Noticia> noticiasFinales = new HashSet();
        noticiasFinales.addAll(beans);
        return noticiasFinales;
    }

    public void saveData(){
        try {
            FileWriter t = new FileWriter(theFile.getName());
            CSVWriter writer = new CSVWriter(t, '|', DEFAULT_QUOTE_CHARACTER, DEFAULT_ESCAPE_CHARACTER, DEFAULT_LINE_END);
            // Aca convierto al csv que necesito
            writer.writeNext(titles, false);
            HashSet<Noticia> data = DataManager.getInstance().getData();

            for(Noticia p : data){
                //significa que lo quiero mantener
                writer.writeNext(p.getDataToCsv(),false);
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
