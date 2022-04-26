package com.uai.app2;

import com.uai.app2.archivos.Archivo;
import com.uai.app2.libros.Libro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    public static void main(String[] args){
        Archivo myInternalArch = new Archivo(args[0]);
        List<Libro> libros = myInternalArch.leerDatos();



    }
}
