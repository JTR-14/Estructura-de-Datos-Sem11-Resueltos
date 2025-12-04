/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbol;

import javax.swing.DefaultListModel;


public class Arbol {
    private NodoArbol raiz;
    
    public Arbol(){
        this.raiz = null;
    }
    
    /*public void insertar(int valor){
        if(raiz == null)
            raiz = new NodoArbol(valor);
        else
            raiz.insertar(valor);
    }*/
    
    
    public void insertar(int valor){
        this.raiz = insertar(this.raiz, valor);
    }

    private NodoArbol insertar(NodoArbol nodoActual, int valor) {
        
        if (nodoActual == null) {
            return new NodoArbol(valor);
        }
        
        if (valor < nodoActual.getValor()) {

            NodoArbol hijoIzquierda = insertar(nodoActual.getNodoIzquierda(), valor);
            nodoActual.setNodoIzquierda(hijoIzquierda);
            
        } else{
            NodoArbol hijoDerecha = insertar(nodoActual.getNodoDerecha(), valor);
            nodoActual.setNodoDerecha(hijoDerecha);
        }
        
        return nodoActual;
    }
    
    public void preOrden(DefaultListModel modelo){
        preOrden(raiz, modelo);  
    }
    private void preOrden(NodoArbol nodo, DefaultListModel modelo){ //centro, izquierda, derecha
        modelo.removeAllElements();
        if(nodo == null)
            return;
        else{
            modelo.addElement(nodo.getValor());
            preOrden(nodo.getNodoIzquierda(), modelo);
            preOrden(nodo.getNodoDerecha(),modelo);
        }
    }
    
    public void inOrden(DefaultListModel modelo){
        inOrden(raiz,modelo);  
    }
    private void inOrden(NodoArbol nodo, DefaultListModel modelo){  //izquieda, centro, derecha
        modelo.removeAllElements();
        if(nodo == null)
            return;
        else{
            inOrden(nodo.getNodoIzquierda(), modelo);
            modelo.addElement(nodo.getValor());
            inOrden(nodo.getNodoDerecha(), modelo);
        }
    }
    
    public void postOrden(DefaultListModel modelo){
        postOrden(raiz, modelo);  
    }
    private void postOrden(NodoArbol nodo, DefaultListModel modelo){ // izquierda, derecha, centro
        if(nodo == null)
            return;
        else{
            postOrden(nodo.getNodoIzquierda(), modelo);
            postOrden(nodo.getNodoDerecha(), modelo);
            modelo.addElement(nodo.getValor());
            
        }
    }
    
    public boolean buscar(int valor){
        return buscar(raiz,valor);
    }
    private boolean buscar(NodoArbol nodoActual, int valor){
        if(nodoActual == null)
            return false;
        if(nodoActual.getValor() == valor)
            return true;
        
        if(nodoActual.getValor()< valor){
            return buscar(nodoActual.getNodoIzquierda(),valor);
        }
        else{ 
            return buscar(nodoActual.getNodoDerecha(), valor);
        }
    }
    
    public void eliminar(int valor) {
        this.raiz = eliminarRecursivo(raiz, valor);
    }

    // --- MÉTODO PRIVADO RECURSIVO ---
    private NodoArbol eliminarRecursivo(NodoArbol nodoActual, int valor) {
        // Caso base: Si llegamos a null, el valor no existe en el árbol
        if (nodoActual == null) {
            return null;
        }

        // 1. PRIMERO BUSCAMOS EL NODO
        if (valor < nodoActual.getValor()) {
            nodoActual.setNodoIzquierda(eliminarRecursivo(nodoActual.getNodoIzquierda(), valor));
        } else if (valor > nodoActual.getValor()) {
            nodoActual.setNodoDerecha(eliminarRecursivo(nodoActual.getNodoDerecha(), valor));
        } else {
            // ¡LO ENCONTRAMOS! (valor == nodoActual.getValor())
            // Ahora aplicamos los 3 casos:

            // CASO 1 y 2: Sin hijos o con un solo hijo
            if (nodoActual.getNodoIzquierda() == null) {
                return nodoActual.getNodoDerecha(); // Devuelve el hijo derecho (o null si no tiene)
            } else if (nodoActual.getNodoDerecha() == null) {
                return nodoActual.getNodoIzquierda(); // Devuelve el hijo izquierdo
            }

            // CASO 3: Tiene DOS hijos
            // Buscamos el sucesor (el valor más pequeño del subárbol derecho)
            int valorMasPequeno = encontrarMinimo(nodoActual.getNodoDerecha());
            
            // Reemplazamos el valor del nodo actual por el del sucesor
            nodoActual.setValor(valorMasPequeno);
            
            // Ahora eliminamos el nodo antiguo del sucesor (que ya copiamos)
            nodoActual.setNodoDerecha(eliminarRecursivo(nodoActual.getNodoDerecha(), valorMasPequeno));
        }
        return nodoActual;
    }

    // Método auxiliar para encontrar el valor más pequeño (irse todo a la izquierda)
    private int encontrarMinimo(NodoArbol nodo) {
        int minimo = nodo.getValor();
        while (nodo.getNodoIzquierda() != null) {
            minimo = nodo.getNodoIzquierda().getValor();
            nodo = nodo.getNodoIzquierda();
        }
        return minimo;
    }
    public int getAltura() {
        return getAlturaRecursivo(this.raiz);
    }

    // --- PRIVADO ---
    private int getAlturaRecursivo(NodoArbol nodo) {
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
