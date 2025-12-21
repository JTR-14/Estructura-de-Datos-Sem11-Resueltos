/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio02_Resuelto;

import Arbol.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ListarEmpleados {
    
    Arbol<Empleado> lista = new Arbol<>();
    
    public void insertar(Empleado empleado){
        lista.insertar(empleado);
    }
    public void eliminar(Empleado empleado){
        lista.eliminar(empleado);
    }
    public NodoArbol<Empleado> consultar(Empleado empleado){
        return lista.buscar(empleado);
    }
    public void agregarFila(DefaultTableModel modelo, Empleado empleado){
        Object fila [] = {empleado.getCodigo(), empleado.getNombres(), empleado.getApellidos(), empleado.getSexo(), empleado.getSueldo()};
        modelo.addRow(fila);
    }
    public void limpiarTabla(DefaultTableModel modelo){
        modelo.setRowCount(0);
    }
     public void mostrarEnOrden(DefaultTableModel modelo){
         String titulos[] = {"CODIGO", "NOMBRES", "APELLIDOS","SEXO","SUELDO"};
         modelo.setColumnIdentifiers(titulos);
         limpiarTabla(modelo);
         ArrayList<Empleado> listaEmpleados = lista.enOrdenTabla();
         for(Empleado e: listaEmpleados){
             agregarFila(modelo,e);
         }
     }
     
     public void mostrarPreOrden(DefaultTableModel modelo){
         String titulos[] = {"CODIGO", "NOMBRES", "APELLIDOS","SEXO","SUELDO"};
         modelo.setColumnIdentifiers(titulos);
         limpiarTabla(modelo);
         ArrayList<Empleado> listaEmpleados = lista.preOrdenTabla();
         for(Empleado e: listaEmpleados){
             agregarFila(modelo,e);
         }
     }
     
     public void mostrarPostOrden(DefaultTableModel modelo){
         String titulos[] = {"CODIGO", "NOMBRES", "APELLIDOS","SEXO","SUELDO"};
         modelo.setColumnIdentifiers(titulos);
         limpiarTabla(modelo);
         ArrayList<Empleado> listaEmpleados = lista.postOrdenTabla();
         for(Empleado e: listaEmpleados){
             agregarFila(modelo,e);
         }
     }
}
