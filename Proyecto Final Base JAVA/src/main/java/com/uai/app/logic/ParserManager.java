package com.uai.app.logic;

import com.uai.app.dominio.Noticia;
import com.uai.app.logic.parsers.LaTerceraParser;
import com.uai.app.logic.parsers.TeleTreceParser;
import com.uai.app.logic.parsers.UAIAbstractParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
  * Esta clase maneja todos los parsers que posee mi codigo
  * Obtiene una respuesta de cada uno y los devuelve
 */
public class ParserManager {
    
    private List<UAIAbstractParser> parsers;
    
    public ParserManager(){
        this.parsers = new ArrayList<UAIAbstractParser>();
        parsers.add(new LaTerceraParser());
        parsers.add(new TeleTreceParser());
    }

    public HashSet<Noticia> getNoticias() {
        HashSet<Noticia> noticias = new HashSet<Noticia>();
        for (UAIAbstractParser parser : parsers) {
            try {
                noticias.addAll(parser.getNoticias());
            } catch (IOException e) {
               System.err.println("Error obteniendo noticias");
               e.printStackTrace();
            }
        }
        return noticias;
    }
}
