package com.uai.app.dominio;

import com.opencsv.bean.CsvBindByName;

import java.util.Objects;

public class Noticia {

    @CsvBindByName(column = "texto")
    private String texto;
    @CsvBindByName(column = "link")
    private String link;
    @CsvBindByName(column = "icono")
    private String icono = "";
    @CsvBindByName(column = "fecha")
    private String fecha;
    @CsvBindByName(column = "fuente")
    private String fuente;

    public String getTexto() {
        return texto;
    }

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Noticia)) return false;
        Noticia noticia = (Noticia) o;
        return getTexto().equals(noticia.getTexto()) && getLink().equals(noticia.getLink()) && getIcono().equals(noticia.getIcono()) && getFecha().equals(noticia.getFecha()) && getFuente().equals(noticia.getFuente());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTexto(), getLink(), getIcono(), getFecha(), getFuente());
    }

    public String[] getDataToCsv(){
        // el string.valueOf me convierte el int a string
        return new String[]{ getTexto().trim(), getLink().trim(), getIcono().trim(), getFecha().trim(), getFuente().trim()};
    }
}
