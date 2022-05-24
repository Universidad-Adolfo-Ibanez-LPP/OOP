package com.uai.app.logic;

import com.uai.app.dominio.Noticia;
import com.uai.app.dominio.enums.Tittles;
import com.uai.app.exceptions.DataNotLoadedException;
import com.uai.app.ui.utils.*;
import org.apache.commons.text.CaseUtils;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/*
*
* Dado que solo necesitare una instancia de esta clase
* la convierto en SIngleton https://refactoring.guru/design-patterns/singleton
*
 */
public class DataManager {

    private HashSet<Noticia> data;

    private static DataManager instance;

    //todos los singletons
    // tienen constructores privados
    private  DataManager(){
    }

    public static DataManager getInstance(){
        if (instance == null){
            instance = new DataManager();
            SearchManager.getInstance();
        }
        return instance;
    }

    public HashSet<Noticia> getData() {
        return data;
    }

    public void setData(HashSet<Noticia> data) {
        this.data = data;
    }

    public String getDataAsString() throws DataNotLoadedException {
        //verifico que la data exista y sino devuelvo excepcion
        if (AppUtils.isNull(data)){
          throw new DataNotLoadedException();
        }
        //Creo un string para ir sumando ahi la data
        StringBuilder sb = new StringBuilder(data.size()*50);
        for (Noticia p : data){
               sb.append(p);
               sb.append("\n");
        }
        return sb.toString();
    }

    public void agregarNoticia(Noticia p){
        this.data.add(p);
    }

    public void removerNoticia(Noticia p){
        this.data.remove(p);
    }

    public void removerNoticias(Collection<Noticia> personas){
        this.data.removeAll(personas);
    }
}
