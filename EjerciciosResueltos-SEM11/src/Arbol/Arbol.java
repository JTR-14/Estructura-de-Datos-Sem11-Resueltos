/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbol;


public class Arbol {
    private NodoArbol raiz;
    
    public Arbol(){
        this.raiz = null;
    }
    
    public void insertar(int valor){
        if(raiz == null)
            raiz = new NodoArbol(valor);
        else
            raiz.insertar(valor);
    }
    
    public void preOrden(){
        preOrden(raiz);  
    }
    public void preOrden(NodoArbol nodo){ //centro, izquierda, derecha
        if(nodo == null)
            return;
        else{
            System.out.print(nodo.getValor() + " ");
            preOrden(nodo.getNodoIzquierda());
            preOrden(nodo.getNodoDerecha());
        }
    }
    
    public void inOrden(){
        inOrden(raiz);  
    }
    public void inOrden(NodoArbol nodo){  //izquieda, centro, derecha
        if(nodo == null)
            return;
        else{
            inOrden(nodo.getNodoIzquierda());
            System.out.print(nodo.getValor() + " ");
            inOrden(nodo.getNodoDerecha());
        }
    }
    
    public void postOrden(){
        postOrden(raiz);  
    }
    public void postOrden(NodoArbol nodo){ // izquierda, derecha, centro
        if(nodo == null)
            return;
        else{
            postOrden(nodo.getNodoIzquierda());
            postOrden(nodo.getNodoDerecha());
            System.out.print(nodo.getValor() + " ");
            
        }
    }
}
