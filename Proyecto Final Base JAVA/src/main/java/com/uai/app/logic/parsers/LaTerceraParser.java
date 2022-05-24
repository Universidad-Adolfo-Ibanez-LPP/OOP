package com.uai.app.logic.parsers;

import com.uai.app.dominio.Noticia;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;

public class LaTerceraParser  extends UAIAbstractParser {

    public static final String LINK_NACIONAL = "https://www.latercera.com/canal/nacional/";
    public static final String HREF = "href";
    public static final String SRCSET = "srcset";
    public static final String FUENTE = "https://www.latercera.com/";
    public static final String TOP_MAINY = "top-mainy";
    public static final String CARD = "card";
    public static final String HEADLINE = "headline";

    public LaTerceraParser() {
        super(LINK_NACIONAL);
    }

    public HashSet<Noticia> parseNoticias() throws IOException {
        HashSet<Noticia> noticias = new HashSet<Noticia>();
        //saco todas las noticias de la grilla
        Elements contenedorNoticias = doc.getElementsByClass(TOP_MAINY);
        Elements links = contenedorNoticias.get(0).getElementsByClass(CARD);
        /*
        * Recorro todas las noticias y las agrego a mi set
         */
        for (Element card : links) {
            //creo la noticia
            Noticia noticia = new Noticia();
            //Saco el link desde la noticia
            noticia.setLink(getLink(card));
            //texto de la noticia
            noticia.setTexto(card.text());
            //saco la imagen
            noticia.setIcono("");
            noticia.setFecha(formatter.format(new Date()));
            //cargo su fuente
            noticia.setFuente(FUENTE);
            //cargo la noticia en el set
            noticias.add(noticia);
        }
        return noticias;
    }

    private String getLink(Element card) {
        Element headline = card.getElementsByClass(HEADLINE).get(0);
        return headline.getElementsByAttribute(HREF).get(0).attr(HREF);
    }
}
