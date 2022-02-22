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
public class Cola {

    private int tamanio;
    private Nodo primero;
    private Nodo ultimo;

    /**
     * Crea una cola
     */
    public Cola() {
        this.primero = null;
        this.ultimo = null;
        this.tamanio = 0;
    }

    /**
     * Retorna un el tamanio de la lista
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
     * Agrega un nuevo elemento a la cola
     *
     * @param elemento
     */
    public void encolar(Nodo elemento) {
        if (vacio()) {
            this.primero = elemento;
            this.ultimo = elemento;
        } else {
            Nodo aux = this.primero;

            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(elemento);
            this.ultimo = (elemento);
        }
        tamanio++;
    }

    /**
     * Elimina el primer nodo ingresado de todos los elementos
     *
     * @return
     * @throws java.lang.Exception
     */
    public Nodo desencolar() throws Exception {
        Nodo auxDesencolar = primero;
        if (vacio()) {
            throw new ExepcionEstructura("La cola esta Vacia");
        } else {
            primero = primero.getSiguiente();
            tamanio--;
        }

        return auxDesencolar;
    }

    /**
     * Imprime los datos de la cola
     *
     * @return
     */
    public String imprimirDatos() {
        String datos = "Cola \n";
        Nodo aux = this.primero;
        while (aux != null) {
            datos = datos + aux.imprmir() + "\n";
            aux = aux.getSiguiente();
        }
        return datos;
    }

    /**
     * Imprime el codigo Graphviz de la Cola
     *
     * @return
     */
    public String imprimirCodigoGraphviz() {
        String codigoGraphviz = "digraph G {\n0[label=\"INICIO\"]\n";
        if (!vacio()) {
            Nodo aux = this.primero;
            Nodo auxSiguiente;
            codigoGraphviz = codigoGraphviz + "0->" + aux.getValor() + "\n";
            while (aux != null) {
                codigoGraphviz = codigoGraphviz + aux.getValor()
                        + "[label=\"" + aux.getValor() + ", " + aux.getColor() + "\"]\n";
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
