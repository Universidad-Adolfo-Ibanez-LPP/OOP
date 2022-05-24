package com.uai.app.logic.parsers;

import com.uai.app.dominio.Noticia;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashSet;

public abstract class UAIAbstractParser {

    protected String linkToParse;
    protected Document doc;
    protected SimpleDateFormat formatter;

    public UAIAbstractParser(String linkToParse) {
        this.linkToParse = linkToParse;
        formatter = new SimpleDateFormat("dd/MM/yyyy");
    }

    public HashSet<Noticia> getNoticias() throws IOException{
        //realizo la conexion
        Connection.Response response= Jsoup.connect(linkToParse)
                .ignoreContentType(true)
                .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                .referrer("http://www.google.com")
                .timeout(12000)
                .followRedirects(true)
                .execute();
        doc = response.parse();
        return parseNoticias();
    }

    public abstract HashSet<Noticia> parseNoticias() throws IOException;


}