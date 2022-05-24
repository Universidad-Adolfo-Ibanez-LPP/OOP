package com.uai.app.logic.parsers;

import com.uai.app.dominio.Noticia;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

public class TeleTreceParser extends UAIAbstractParser {

    public static final String T_13_CL_NACIONAL = "https://www.t13.cl/nacional";
    public static final String GRILLA_ARTICLE = "home-category-grilla__article";
    public static final String HREF = "href";
    public static final String UI_CARD_PICTURE = "ui-card__picture";
    public static final String DATA_SRCSET = "data-srcset";
    public static final String FUENTE = "https://www.t13.cl/";

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public TeleTreceParser() {
        super(T_13_CL_NACIONAL);
    }

    public HashSet<Noticia> parseNoticias() throws IOException {
        HashSet<Noticia> noticias = new HashSet<Noticia>();
        //saco todas las noticias de la grilla
        Elements links = doc.getElementsByClass(GRILLA_ARTICLE);
        /*
        * Recorro todas las noticias y las agrego a mi set
         */
        for (Element headline : links) {
            //creo la noticia
            Noticia noticia = new Noticia();
            //Saco el link desde la noticia
            noticia.setLink(headline.attr(HREF));
            //texto de la noticia
            noticia.setTexto(headline.text());
            //ahora saco la url de la imagen
            noticia.setIcono(getImagen(headline));
            //seteo fecha
            noticia.setFecha(formatter.format(new Date()));
            //cargo su fuente
            noticia.setFuente(FUENTE);
            //cargo la noticia en el set
            noticias.add(noticia);
        }
        return noticias;
    }

    private String getImagen(Element headline) {
        Elements elementInsideNews = headline.getElementsByClass(UI_CARD_PICTURE);
        //solo necesito saber si hay una noticia con foto
        if (elementInsideNews.size() > 0){
            Element noticiaConFoto = elementInsideNews.get(0);
            Element elementPicture = noticiaConFoto.getElementsByAttribute(DATA_SRCSET).get(0);
            String node = elementPicture.absUrl(DATA_SRCSET);
            //Obtengo la ultima foto
            String[] imagesArray = node.split(" ");
            //imagen de la noticia
            if (imagesArray.length > 0){
                //seteo la ultima imagen
                return imagesArray[imagesArray.length-1];
            }
        }
        return "";
    }
}
