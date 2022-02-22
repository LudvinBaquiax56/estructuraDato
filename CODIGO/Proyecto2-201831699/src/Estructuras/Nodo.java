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
public class Nodo {

    private int valor;
    private String color;
    private Nodo siguiente;

    /**
     * Crea un nodo
     *
     * @param valor
     * @param color
     */
    public Nodo(int valor, String color) {
        this.valor = valor;
        this.color = color;
        this.siguiente = null;
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
    public Nodo getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public String imprmir() {
        return "Valor: " + valor + ", Color: " + color;
    }

}
