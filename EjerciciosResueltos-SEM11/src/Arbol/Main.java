/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbol;


public class Main {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        arbol.insertar( 43);
        arbol.insertar(10);
        arbol.insertar( 8);
        arbol.insertar( 54);
        arbol.insertar(15);
        arbol.insertar( 50);
        arbol.insertar( 53);
        System.out.print("INORDEN: ");
        arbol.inOrden();
        System.out.println("");
        System.out.print("POSTORDEN: ");
        arbol.postOrden();
        System.out.println("");
        System.out.print("PREORDEN: ");
        arbol.preOrden();
        System.out.println("");
    }
}