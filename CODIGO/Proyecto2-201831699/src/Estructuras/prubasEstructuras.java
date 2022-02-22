/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author baquiax
 */
public class prubasEstructuras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //pruebaCola();
        //pruebaPila();
        //pruebaLista();
        //pruebaListaDoble();
        pruebaListaCircular();
    }

    public static void pruebaCola() {
        Cola colaPrueba = new Cola();
        colaPrueba.encolar(new Nodo(1, "VERDE"));
        colaPrueba.encolar(new Nodo(2, "VERDE"));
        colaPrueba.encolar(new Nodo(3, "VERDE"));
        colaPrueba.encolar(new Nodo(4, "VERDE"));

        try {
            Nodo muestra = colaPrueba.desencolar();
            System.out.println("-----------------------");
            System.out.println(muestra.imprmir());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
        System.out.println(colaPrueba.imprimirDatos());
        System.out.println(colaPrueba.tamanio());
        System.out.println("----------------------------------");
        System.out.println(colaPrueba.imprimirCodigoGraphviz());
    }

    public static void pruebaPila() {
        Pila pilaPrueba = new Pila();
        pilaPrueba.push(new Nodo(1, "AMARILLO"));
        pilaPrueba.push(new Nodo(2, "AMARILLO"));
        pilaPrueba.push(new Nodo(3, "AMARILLO"));
        pilaPrueba.push(new Nodo(4, "AMARILLO"));
        System.out.println(pilaPrueba.imprimir());
        System.out.println(pilaPrueba.imprimirCodigoGraphviz());
        System.out.println("----------------------------------");
        try {
            Nodo aux = pilaPrueba.pop();
            System.out.println(aux.imprmir());
        } catch (ExepcionEstructura ex) {
            Logger.getLogger(prubasEstructuras.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("");
        System.out.println(pilaPrueba.imprimir());
        System.out.println(pilaPrueba.imprimirCodigoGraphviz());
        System.out.println("----------------------------------");
    }

    public static void pruebaLista() {
        ListaSimple lista = new ListaSimple();
        lista.insertar(new Nodo(1, "ROJO"));
        lista.insertar(new Nodo(2, "AMARILLO"));
        lista.insertar(new Nodo(3, "AZUL"));
        lista.insertar(new Nodo(4, "VERDE"));
        lista.insertar(new Nodo(5, "VERDE"));
        lista.insertar(new Nodo(6, "VERDE"));
        lista.insertar(new Nodo(7, "VERDE"));
        System.out.println("-----------------------------");
        System.out.println(lista.imprimir());
        System.out.println(lista.imprimirCodigoGraphviz());
        try {
            Nodo aux;
            aux = lista.eliminarElementoEspecifico(1);
            System.out.println("tamanio: " + lista.tamanio());
            System.out.println(aux.imprmir());
            System.out.println("...........................");
            aux = lista.eliminarElementoEspecifico(4);
            System.out.println("tamanio: " + lista.tamanio());
            System.out.println(aux.imprmir());
            System.out.println("...........................");
            aux = lista.eliminarElementoEspecifico(5);
            System.out.println("tamanio: " + lista.tamanio());
            System.out.println(aux.imprmir());
            System.out.println("...........................");
            aux = lista.eliminarElementoEspecifico(2);
            System.out.println("tamanio: " + lista.tamanio());
            System.out.println(aux.imprmir());
            System.out.println("...........................");
            aux = lista.eliminarElementoEspecifico(1);
            System.out.println(lista.tamanio());
            System.out.println(aux.imprmir());
            System.out.println("...........................");
        } catch (ExepcionEstructura ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("-----------------------------");
        System.out.println(lista.imprimir());
        System.out.println(lista.imprimirCodigoGraphviz());
        lista.crearImagen();
    }

    public static void pruebaListaDoble() {
        ListaDoble listaDoble = new ListaDoble();
        listaDoble.insertar(new NodoDoble(1, "1"));
        listaDoble.insertar(new NodoDoble(2, "2"));
        listaDoble.insertar(new NodoDoble(3, "3"));
        listaDoble.insertar(new NodoDoble(4, "4"));
        listaDoble.insertar(new NodoDoble(5, "5"));
        System.out.println("----------------------------------------");
        System.out.println(listaDoble.imprimir());
        System.out.println(listaDoble.imprimirCodigoGraphviz());
        try {
            NodoDoble aux = listaDoble.eleminarElementoEspecifico(5);
            System.out.println(aux.imprimir());
        } catch (ExepcionEstructura ex) {
            Logger.getLogger(prubasEstructuras.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("----------------------------------------");
        System.out.println(listaDoble.imprimir());
        System.out.println(listaDoble.imprimirCodigoGraphviz());
    }

    private static void pruebaListaCircular() {
        ListaCircular lista = new ListaCircular();
        lista.insertar(new NodoDoble(0, "Rojo"));
        lista.insertar(new NodoDoble(1, "Rojo"));
        lista.insertar(new NodoDoble(2, "Rojo"));
        lista.insertar(new NodoDoble(3, "Rojo"));
        lista.insertar(new NodoDoble(4, "Rojo"));
        NodoDoble aux;
        try {
            aux = lista.eleminarElementoEspecifico(0);
            System.out.println(aux.imprimir());
        } catch (ExepcionEstructura ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(lista.imprimirCodigoGraphviz());
        System.out.println(lista.imprimir());
    }
}
