/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author baquiax
 */
public class ListaSimple {

    private int tamanio;
    private Nodo primero;
    private Nodo ultimo;

    /**
     * Crea una lista
     */
    public ListaSimple() {
        this.tamanio = 0;
        this.primero = null;
        this.ultimo = null;
    }

    /**
     * Retorna el tamanio de la lista
     *
     * @return
     */
    public int tamanio() {
        return tamanio;
    }

    /**
     *
     * @return
     */
    public boolean vacio() {
        return tamanio == 0;
    }

    /**
     * Inserta un elemento, recibiendo un Nodo
     *
     * @param elemento
     */
    public void insertar(Nodo elemento) {
        if (vacio()) {
            primero = elemento;
            ultimo = elemento;
        } else {
            Nodo aux = primero;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(elemento);
            ultimo = elemento;
        }
        tamanio++;
    }

    /**
     * Elimina un elemento en base a un valor
     *
     * @param valorEliminar
     * @return
     * @throws ExepcionEstructura
     */
    public Nodo eliminarElementoEspecifico(int valorEliminar) throws ExepcionEstructura {
        if (vacio()) {
            throw new ExepcionEstructura("Error la lista esta vacia");
        } else {
            if (tamanio == 1 && primero.getValor() == valorEliminar) {
                Nodo aux = primero;
                primero = null;
                ultimo = null;
                tamanio--;
                return aux;
            } else if (primero.getValor() == valorEliminar) {
                Nodo aux = primero;
                primero = primero.getSiguiente();
                tamanio--;
                return aux;
            } else {
                Nodo auxAnterior = primero;
                Nodo aux = primero.getSiguiente();
                while (aux != null && aux.getValor() != valorEliminar) {
                    auxAnterior = aux;
                    aux = aux.getSiguiente();
                }
                if (aux != null) {
                    auxAnterior.setSiguiente(aux.getSiguiente());
                    if (aux == ultimo) {
                        ultimo = auxAnterior;
                    }
                    tamanio--;
                    return aux;
                } else {
                    throw new ExepcionEstructura("Error elemento buscado, no existente");
                }
            }
        }
    }

    /**
     * Imprime los datos de la lista
     *
     * @return
     */
    public String imprimir() {
        String datos = "Lista \n";
        if (!vacio()) {
            Nodo aux = primero;
            while (aux != null) {
                datos = datos + aux.imprmir() + "\n";
                aux = aux.getSiguiente();
            }
        }
        return datos;
    }

    /**
     * Imprime los datos de la lista, en formato Graphviz
     *
     * @return
     */
    public String imprimirCodigoGraphviz() {
        String codigoGraphviz = "digraph G {\n";
        if (!vacio()) {
            Nodo aux = primero;
            Nodo auxSiguiente;
            while (aux != null) {
                codigoGraphviz = codigoGraphviz + aux.getValor() + "[label=\""
                        + aux.getValor() + ", " + aux.getColor() + "\"]\n";
                if (aux.getSiguiente() != null) {
                    auxSiguiente = aux.getSiguiente();
                    codigoGraphviz = codigoGraphviz + aux.getValor() + "->"
                            + auxSiguiente.getValor() + "\n";
                }
                aux = aux.getSiguiente();
            }
        }
        codigoGraphviz = codigoGraphviz + "}";
        return codigoGraphviz;
    }

    public void crearImagen() {
        String[] comandos = new String[5];
        comandos[0] = "/usr/bin/dot";
        comandos[1] = "-Tjpg";
        comandos[2] = "listaSimple.dot";
        comandos[3] = "-o";
        comandos[4] = "imagenListaSimple.jpg";

        try (java.io.FileOutputStream archivo = new java.io.FileOutputStream("listaSimple.dot")) {

            archivo.write((imprimirCodigoGraphviz()).getBytes());

            Runtime.getRuntime().exec(comandos);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ListaSimple.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ListaSimple.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
