/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbol;

public class NodoArbol<T> {
    
    private T valor;
    private NodoArbol<T> hi;
    private NodoArbol<T> hd;
    
    public NodoArbol(T valor) {
        this.valor = valor;
        this.hd = null;
        this.hi = null;        
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NodoArbol<T> getHi() {
        return hi;
    }

    public void setHi(NodoArbol<T> hi) {
        this.hi = hi;
    }

    public NodoArbol<T> getHd() {
        return hd;
    }

    public void setHd(NodoArbol<T> hd) {
        this.hd = hd;
    }
   
}
