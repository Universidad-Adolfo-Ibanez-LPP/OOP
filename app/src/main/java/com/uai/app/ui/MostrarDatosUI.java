package com.uai.app.ui;

import com.uai.app.dominio.Persona;
import com.uai.app.exceptions.DataNotLoadedException;
import com.uai.app.logic.DataManager;
import com.uai.app.ui.utils.UAIJFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.HashSet;

public class MostrarDatosUI extends UAIJFrame  {

    private JPanel mainPanel;
    private JPanel mainTableConatiner;
    private JTextArea textArea1;

    public MostrarDatosUI(String title) {
        super(title);
        this.setMainPanel(mainPanel);

        String[] titles = {"name","address","country","cost"};
        //obtengo las personas en una matriz
        //recuerden que esta data es la que se leyo antes del archivo
        // hasta aca aun tiene formato de objeto
        HashSet<Persona> data = DataManager.getInstance().getData();
        //como lo voy a mostrar en una tabla construyo una matriz de strings
        // por lo que es un array de array
        //cada fila sera una array de strings que tendra en cada sub posicion
        // un dato de cada campo
        String[][] dataTabla = new String[data.size()][4];
        int cont = 0;
        for(Persona p : data) {
            dataTabla[cont] = p.getDataToCsv();
            cont++;
        }

        //una vez que cargue el array de strings
        // genero la tabla con esos valores
        TableModel tableModel = new DefaultTableModel(dataTabla, titles);
        //la meto en una tabla visual
        JTable table = new JTable(tableModel);

        //la agrego al contenedor de la tabla
        mainTableConatiner.setLayout(new BorderLayout());
        mainTableConatiner.add(new JScrollPane(table), BorderLayout.CENTER);
        mainTableConatiner.add(table.getTableHeader(), BorderLayout.NORTH);
        mainTableConatiner.setVisible(true);
        mainTableConatiner.setSize(400,400);
    }

}
