/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbol;

import javax.swing.DefaultListModel;


public class Arbol<T extends Comparable<T>> {
    private NodoArbol<T> raiz;
    
    public Arbol(){
        this.raiz = null;
    }

    public void insertar(T valor){
        raiz = insertar(raiz, valor);
    }

    private NodoArbol<T> insertar(NodoArbol<T> actual, T valor) {
        if(actual == null)
            actual = new NodoArbol<>(valor);
        else{
            int comparacion = valor.compareTo(actual.getValor());
            if(comparacion > 0)
                 actual.setHd(insertar(actual.getHd(), valor));
            else{
                if(comparacion<0)
                    actual.setHi(insertar(actual.getHi(),valor));
             }
        }
    return actual;
}
    
    public void preOrden(DefaultListModel modelo){
        modelo.removeAllElements();
        preOrden(raiz, modelo);  
    }
    private void preOrden(NodoArbol<T> nodo, DefaultListModel modelo){ 
            if(nodo != null){
            modelo.addElement(nodo.getValor());
            preOrden(nodo.getHi(), modelo);
            preOrden(nodo.getHd(),modelo);
        }
    }
    
    public void inOrden(DefaultListModel modelo){
        modelo.removeAllElements();
        inOrden(raiz,modelo);  
    }
    private void inOrden(NodoArbol<T> nodo, DefaultListModel modelo){ 
        if(nodo != null){
            inOrden(nodo.getHi(), modelo);
            modelo.addElement(nodo.getValor());
            inOrden(nodo.getHd(), modelo);
        }
    }
    
    public void postOrden(DefaultListModel modelo){
        modelo.removeAllElements();
        postOrden(raiz, modelo);  
    }
    private void postOrden(NodoArbol<T> nodo, DefaultListModel modelo){ 
        if(nodo != null ){
            postOrden(nodo.getHi(), modelo);
            postOrden(nodo.getHd(), modelo);
            modelo.addElement(nodo.getValor());
        }
    }
    public T buscarMax() {
    if (raiz == null) return null; 
    return buscarMax(raiz);
}

    private T buscarMax(NodoArbol<T> nodo) {

         if (nodo.getHd() == null) {
        return nodo.getValor();
        }
        return buscarMax(nodo.getHd());
    }
    
    public T buscarMin(){
        if (raiz == null) return null;
        return buscarMin(raiz);
    }
    private T buscarMin(NodoArbol<T> nodo){
        if(nodo.getHi() == null){
            return nodo.getValor();
        }
        return buscarMin(nodo.getHi());
    }
    public NodoArbol<T> buscar(T valor){
        return buscar(raiz,valor);
    }
    private NodoArbol<T> buscar(NodoArbol<T> nodoActual, T valor){
        if(nodoActual !=null){
            int comparador = valor.compareTo(nodoActual.getValor());
            if(comparador == 0)
                return nodoActual;
            
            else if(comparador < 0)
                return buscar(nodoActual.getHi(),valor);
            else
                return buscar(nodoActual.getHd(),valor);
        }
        else
            return null;
    }
    
    public void eliminar(T valor) {
        this.raiz = eliminar(raiz, valor);
    }

    private NodoArbol<T> eliminar(NodoArbol<T> nodoActual, T valor) {
        if(nodoActual != null){
            int comparador = valor.compareTo(nodoActual.getValor());
            if(comparador < 0 )
                nodoActual.setHi(eliminar(nodoActual.getHi(), valor));
            else{
                if(comparador > 0)
                 nodoActual.setHd(eliminar(nodoActual.getHd(), valor));
                else{
                    if(nodoActual.getHi() == null)
                        return nodoActual.getHd();
                    else{
                        if(nodoActual.getHd() == null)
                            return nodoActual.getHi();
                        else
                            nodoActual.setValor(this.buscarMin(nodoActual.getHd()));
                            
                    }

                }
            }
        }
        return null;
    }

        public NodoArbol<T> eliminarMin(){
            
        }
        

    public int getAltura() {
        return getAlturaRecursivo(raiz);
    }

    // --- PRIVADO ---
    private int getAlturaRecursivo(NodoArbol<T> nodo) {
        if (nodo == null) {
            return 0; // Si no hay nodo, la altura es 0
        }
        
        // Calculamos la altura de cada lado
        int alturaIzq = getAlturaRecursivo(nodo.getNodoIzquierda());
        int alturaDer = getAlturaRecursivo(nodo.getNodoDerecha());
        
        // Nos quedamos con la mayor y sumamos 1 (por el nodo actual)
        return 1 + Math.max(alturaIzq, alturaDer);
    }
    
    // --- PÚBLICO ---
    public int getCantidadNodos() {
        return getCantidadRecursivo(raiz);
    }

    private int getCantidadRecursivo(NodoArbol nodo) {
        if (nodo == null) {
            return 0;
        }
        
        int cantidadIzq = getCantidadRecursivo(nodo.getNodoIzquierda());
        int cantidadDer = getCantidadRecursivo(nodo.getNodoDerecha());
        
        return 1 + cantidadIzq + cantidadDer;
    }
    
    public int getMaximo(){
        if(raiz == null) return -1;
        NodoArbol actual = raiz;
        while(actual.getNodoDerecha() != null)
            actual = actual.getNodoDerecha();
        return actual.getValor();
    }
    public int getMinimo(){
        if(raiz == null) return -1;
        NodoArbol actual = raiz;
        while(actual.getNodoIzquierda() != null)
            actual = actual.getNodoIzquierda();
        return actual.getValor();
    }
    
}
