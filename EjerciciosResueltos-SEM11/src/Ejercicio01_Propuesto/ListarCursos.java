/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio01_Propuesto;

import Arbol.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class ListarCursos {
    private Arbol<Curso> lista = new Arbol<>();
    
    public void insertarCurso(Curso curso){
        lista.insertar(curso);
    }
    public void eliminarCurso(Curso curso){
        lista.eliminar(curso);
    }
    
    public NodoArbol<Curso> buscarCurso(Curso curso){
        return lista.buscar(curso);
    }
    
    public void agregarFila(DefaultTableModel modelo, Curso curso){
        Object fila[] = {curso.getCodigo(), curso.getNombre(), curso.getCiclo(), curso.getCreditos(),curso.getCarrera()};
        modelo.addRow(fila);
    }
    public void limpiarTabla(DefaultTableModel modelo){
        modelo.setRowCount(0);
    }
    public void enOrden(DefaultTableModel modelo){
        String titulos[] = {"CODIGO","NOMBRE","CICLO","CREDITOS","CARRERA"};
        modelo.setColumnIdentifiers(titulos);
        limpiarTabla(modelo);
        ArrayList<Curso> enOrden = lista.enOrdenTabla();
        for(Curso c:enOrden)
            agregarFila(modelo,c);
    }
    public void preOrden(DefaultTableModel modelo){
        String titulos[] = {"CODIGO","NOMBRE","CICLO","CREDITOS","CARRERA"};
        modelo.setColumnIdentifiers(titulos);
        limpiarTabla(modelo);
        ArrayList<Curso> enOrden = lista.preOrdenTabla();
        for(Curso c:enOrden)
            agregarFila(modelo,c);
    }
    public void postOrden(DefaultTableModel modelo){
        String titulos[] = {"CODIGO","NOMBRE","CICLO","CREDITOS","CARRERA"};
        modelo.setColumnIdentifiers(titulos);
        limpiarTabla(modelo);
        ArrayList<Curso> enOrden = lista.postOrdenTabla();
        for(Curso c:enOrden)
            agregarFila(modelo,c);
    }
    
}
