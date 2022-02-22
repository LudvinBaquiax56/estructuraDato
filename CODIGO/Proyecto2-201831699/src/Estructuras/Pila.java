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
public class Pila {

    private int tamanio;
    private Nodo tope;
    private Nodo ultimo;

    /**
     * Crea una pila
     */
    public Pila() {
        this.tamanio = 0;
        this.tope = null;
        this.ultimo = null;
    }

    /**
     * Retorna el tamanio de la pila
     *
     * @return
     */
    public int tamanio() {
        return tamanio;
    }

    /**
     * Retorna verdadero si la pila esta vacia y falso si tiene un elemento
     *
     * @return
     */
    public boolean vacio() {
        return tamanio == 0;
    }

    /**
     * Inserta un Nodo, como elemento y sera el primero en
     *
     * @param elemento
     */
    public void push(Nodo elemento) {
        if (vacio()) {
            tope = elemento;
            ultimo = elemento;
        } else {
            elemento.setSiguiente(tope);
            tope = elemento;
        }
        tamanio++;
    }

    /**
     *
     * @return @throws ExepcionEstructura
     */
    public Nodo pop() throws ExepcionEstructura {
        Nodo auxRetornar = tope;
        if (vacio()) {
            throw new ExepcionEstructura("La pila esta vacia");
        } else {
            tope = tope.getSiguiente();

            tamanio--;
        }
        return auxRetornar;
    }

    public String imprimir() {
        String datos = "Pila\n";
        if (!vacio()) {
            Nodo aux = tope;
            while (aux != null) {
                datos = datos + aux.imprmir() + "\n";
                aux = aux.getSiguiente();
            }
        }
        return datos;
    }

    public String imprimirCodigoGraphviz() {
        String codigoGraphviz = "digraph G {\n0[label=\"TOPE\"]\n";
        if (!vacio()) {
            Nodo aux = tope;
            Nodo auxSiguiente;
            codigoGraphviz = codigoGraphviz + "0->" + aux.getValor() + "\n";
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
}
