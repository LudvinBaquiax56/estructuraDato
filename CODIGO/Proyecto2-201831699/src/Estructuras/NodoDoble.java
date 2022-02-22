/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author baquiax
 */
public class NodoDoble {

    private int valor;
    private String color;
    private NodoDoble siguiente;
    private NodoDoble anterior;

    /**
     * Crea un nodoDoble
     *
     * @param valor
     * @param color
     *
     */
    public NodoDoble(int valor, String color) {
        this.valor = valor;
        this.color = color;
        this.siguiente = null;
        this.anterior = null;
    }

    /**
     * @return the valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the siguiente
     */
    public NodoDoble getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * @return the anterior
     */
    public NodoDoble getAnterior() {
        return anterior;
    }

    /**
     * @param anterior the anterior to set
     */
    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }

    /**
     * Imprime los valores del nodo
     *
     * @return
     */
    public String imprimir() {
        return "Valor: " + valor + ", Color: " + color;
    }

}
