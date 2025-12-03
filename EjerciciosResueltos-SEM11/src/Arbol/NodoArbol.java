/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbol;

public class NodoArbol {
    
    private int valor;
    private NodoArbol nodoIzquierda;
    private NodoArbol nodoDerecha;
    
    public NodoArbol(int valor) {
        this.valor = valor;
        this.nodoDerecha = null;
        this.nodoIzquierda = null;        
    }
    
    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public int getValor() {
        return valor;
    }
    
    public NodoArbol getNodoIzquierda() {
        return nodoIzquierda;
    }
    
    public NodoArbol getNodoDerecha() {
        return nodoDerecha;
    }
    
    
    /*public void insertar(int valor) {
        if (valor < this.valor) {
            if (this.nodoIzquierda == null) 
                nodoIzquierda = new NodoArbol(valor);
             else 
                nodoIzquierda.insertar(valor);
            
        } else {
            if (this.nodoDerecha == null) 
                nodoDerecha = new NodoArbol(valor);
             else 
                nodoDerecha.insertar(valor);  
        }
    }*/

    public void setNodoIzquierda(NodoArbol nodoIzquierda) {
        this.nodoIzquierda = nodoIzquierda;
    }

    public void setNodoDerecha(NodoArbol nodoDerecha) {
        this.nodoDerecha = nodoDerecha;
    }
}
