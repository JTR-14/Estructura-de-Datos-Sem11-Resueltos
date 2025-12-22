/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbol;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class Arbol<T extends Comparable<T>> {

    private NodoArbol<T> raiz;

    public Arbol() {
        this.raiz = null;
    }

    public void insertar(T valor) {
        raiz = insertar(raiz, valor);
    }

    private NodoArbol<T> insertar(NodoArbol<T> actual, T valor) {
        if (actual == null) {
            actual = new NodoArbol<>(valor);
        } else {
            int comparacion = valor.compareTo(actual.getValor());
            if (comparacion > 0) {
                actual.setHd(insertar(actual.getHd(), valor));
            } else {
                if (comparacion < 0) {
                    actual.setHi(insertar(actual.getHi(), valor));
                }
            }
        }
        return actual;
    }

    public void preOrden(DefaultListModel modelo) {
        modelo.removeAllElements();
        preOrden(raiz, modelo);
    }

    private void preOrden(NodoArbol<T> nodo, DefaultListModel modelo) {
        if (nodo != null) {
            modelo.addElement(nodo.getValor());
            preOrden(nodo.getHi(), modelo);
            preOrden(nodo.getHd(), modelo);
        }
    }

    public void inOrden(DefaultListModel modelo) {
        modelo.removeAllElements();
        inOrden(raiz, modelo);
    }

    private void inOrden(NodoArbol<T> nodo, DefaultListModel modelo) {
        if (nodo != null) {
            inOrden(nodo.getHi(), modelo);
            modelo.addElement(nodo.getValor());
            inOrden(nodo.getHd(), modelo);
        }
    }

    public void postOrden(DefaultListModel modelo) {
        modelo.removeAllElements();
        postOrden(raiz, modelo);
    }

    private void postOrden(NodoArbol<T> nodo, DefaultListModel modelo) {
        if (nodo != null) {
            postOrden(nodo.getHi(), modelo);
            postOrden(nodo.getHd(), modelo);
            modelo.addElement(nodo.getValor());
        }
    }

    public T buscarMax() {
        if (raiz == null) {
            return null;
        }
        return buscarMax(raiz);
    }

    private T buscarMax(NodoArbol<T> nodo) {

        if (nodo.getHd() == null) {
            return nodo.getValor();
        }
        return buscarMax(nodo.getHd());
    }

    public T buscarMin() {
        if (raiz == null) {
            return null;
        }
        return buscarMin(raiz);
    }

    private T buscarMin(NodoArbol<T> nodo) {
        if (nodo.getHi() == null) {
            return nodo.getValor();
        }
        return buscarMin(nodo.getHi());
    }

    public NodoArbol<T> buscar(T valor) {
        return buscar(raiz, valor);
    }

    private NodoArbol<T> buscar(NodoArbol<T> nodoActual, T valor) {
        if (nodoActual != null) {
            int comparador = valor.compareTo(nodoActual.getValor());
            if (comparador == 0) {
                return nodoActual;
            } else if (comparador < 0) {
                return buscar(nodoActual.getHi(), valor);
            } else {
                return buscar(nodoActual.getHd(), valor);
            }
        } else {
            return null;
        }
    }

    public void eliminarMin() {
        raiz = eliminarMin(raiz);
    }

    private NodoArbol<T> eliminarMin(NodoArbol<T> nodo) {
        if (nodo.getHi() == null) {
            nodo = nodo.getHd();
        } else {
            nodo.setHi(eliminarMin(nodo.getHi()));
        }
        return nodo;
    }

    public void eliminarMax() {
        raiz = eliminarMax(raiz);
    }

    private NodoArbol<T> eliminarMax(NodoArbol<T> nodo) {
        if (nodo.getHd() == null) {
            nodo = nodo.getHi();
        } else {
            nodo.setHd(eliminarMax(nodo.getHd()));
        }
        return nodo;
    }

    public void eliminar(T valor) {
        this.raiz = eliminar(raiz, valor);
    }

    private NodoArbol<T> eliminar(NodoArbol<T> nodoActual, T valor) {
        if (nodoActual != null) {
            int comparador = valor.compareTo(nodoActual.getValor());
            if (comparador < 0) {
                nodoActual.setHi(eliminar(nodoActual.getHi(), valor));
            } else {
                if (comparador > 0) {
                    nodoActual.setHd(eliminar(nodoActual.getHd(), valor));
                } else {
                    if (nodoActual.getHi() == null) {
                        return nodoActual.getHd();
                    } else {
                        if (nodoActual.getHd() == null) {
                            return nodoActual.getHi();
                        } else {
                            nodoActual.setValor(this.buscarMin(nodoActual.getHd()));
                            nodoActual.setHd(eliminarMin(nodoActual.getHd()));
                        }
                    }

                }
            }
        }
        return null;
    }

    public int altura() {
        return altura(raiz);
    }

    private int altura(NodoArbol<T> nodo) {
        int alturaIzq, alturaDer;
        if (nodo == null) {
            return -1;
        } else {
            alturaIzq = 1+ altura(nodo.getHi());
            alturaDer = 1 + altura(nodo.getHd());
            
            if(alturaIzq > alturaDer)
                return alturaIzq;
            else 
                return alturaDer;
        }
    }

    public int cantidadNodos() {
        return cantidadNodos(raiz);
    }

    private int cantidadNodos(NodoArbol nodo) {
        if (nodo == null) {
            return 0;
        }
        int cantidadIzq = cantidadNodos(nodo.getHi());
        int cantidadDer = cantidadNodos(nodo.getHd());

        return 1 + cantidadIzq + cantidadDer;
    }
    public ArrayList<T> enOrdenTabla(){
        ArrayList<T> lista = new ArrayList<>();
        enOrdenTabla(raiz, lista);
        return lista;
    }
    private void enOrdenTabla(NodoArbol<T> nodo, ArrayList<T> lista){
        if(nodo != null){
            enOrdenTabla(nodo.getHi(),lista);
            lista.add(nodo.getValor());
            enOrdenTabla(nodo.getHd(), lista);
        }
    }
    public ArrayList<T> preOrdenTabla(){
        ArrayList<T> lista = new ArrayList<>();
        preOrdenTabla(raiz, lista);
        return lista;
    }
    private void preOrdenTabla(NodoArbol<T> nodo, ArrayList<T> lista){
        if(nodo != null){            
            lista.add(nodo.getValor());
            preOrdenTabla(nodo.getHi(),lista);
            preOrdenTabla(nodo.getHd(), lista);
        }
    }
    public ArrayList<T> postOrdenTabla(){
        ArrayList<T> lista = new ArrayList<>();
        postOrdenTabla(raiz, lista);
        return lista;
    }
    private void postOrdenTabla(NodoArbol<T> nodo, ArrayList<T> lista){
        if(nodo != null){
            postOrdenTabla(nodo.getHi(),lista);
            postOrdenTabla(nodo.getHd(), lista);            
            lista.add(nodo.getValor());   
        }
    }
    public int sumarValores() {
        return sumarValores(raiz);
    }

    private int sumarValores(NodoArbol<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        int valorActual = (Integer) nodo.getValor();
        return valorActual + sumarValores(nodo.getHi()) + sumarValores(nodo.getHd());
    }

    public int contarHojas() {
        return contarHojas(raiz);
    }

    private int contarHojas(NodoArbol<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        if (nodo.getHi() == null && nodo.getHd() == null) {
            return 1;
        }
        return contarHojas(nodo.getHi()) + contarHojas(nodo.getHd());
    }

    public int obtenerProfundidad(T valorBuscado) {
        return obtenerProfundidad(raiz, valorBuscado, 0);
    }

    private int obtenerProfundidad(NodoArbol<T> nodo, T valor, int nivelActual) {
        if (nodo == null) {
            return -1;
        }
        int comparacion = valor.compareTo(nodo.getValor());
        if (comparacion == 0) {
            return nivelActual;
        } else if (comparacion < 0) {
            return obtenerProfundidad(nodo.getHi(), valor, nivelActual + 1);
        } else {
            return obtenerProfundidad(nodo.getHd(), valor, nivelActual + 1);
        }
    }
   public String resultado(){
       return "El mayor es: " + buscarMax() + "\n" +
                    "El menor es: " + buscarMin() + "\n" +
                    "Número de Nodos: " + cantidadNodos() + "\n" +
                    "Altura del Árbol: " + altura();
   }
}
