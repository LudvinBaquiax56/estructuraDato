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
public class ListaDoble {

    private int tamanio;
    private NodoDoble primero;
    private NodoDoble ultimo;

    /**
     * Crea una lista doblemente enlazada
     */
    public ListaDoble() {
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
     * Retorna verdadero si la lista esta vacia y falso si tiene almenos un
     * elemento
     *
     * @return
     */
    public boolean vacio() {
        return tamanio == 0;
    }

    /**
     * Inserta un elemento a la lista
     *
     * @param elemento
     */
    public void insertar(NodoDoble elemento) {
        if (vacio()) {
            primero = elemento;
            ultimo = elemento;
        } else {
            NodoDoble aux = primero;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(elemento);
            elemento.setAnterior(aux);
            ultimo = elemento;
        }
        tamanio++;
    }

    /**
     * Elemina un valor en especifico
     *
     * @param valorEliminar
     * @return
     * @throws Estructuras.ExepcionEstructura
     */
    public NodoDoble eleminarElementoEspecifico(int valorEliminar) throws ExepcionEstructura {
        if (vacio()) {
            throw new ExepcionEstructura("Error la lista esta vacia");
        } else {
            if (tamanio == 1 && primero.getValor() == valorEliminar) {
                NodoDoble aux = primero;
                primero = null;
                ultimo = null;
                tamanio--;
                return aux;
            } else if (primero.getValor() == valorEliminar) {
                NodoDoble aux = primero;
                primero = primero.getSiguiente();
                primero.setAnterior(null);
                tamanio--;
                return aux;
            } else {
                NodoDoble anterior = primero;
                NodoDoble actual = primero.getSiguiente();
                while (actual != null && actual.getValor() != valorEliminar) {
                    anterior = actual;
                    actual = actual.getSiguiente();
                }
                if (actual != null) {
                    anterior.setSiguiente(actual.getSiguiente());
                    if (actual.getSiguiente() != null) {
                        actual.getSiguiente().setAnterior(anterior);
                    }
                    tamanio--;
                    return actual;
                } else {
                    throw new ExepcionEstructura("Error el valor no existe");
                }
            }
        }
    }

    /**
     * Retorna un string con los datos de los elementos de la lista
     *
     * @return
     */
    public String imprimir() {
        String datos = "Lista Doble\n";
        NodoDoble aux = primero;
        while (aux != null) {
            datos = datos + aux.imprimir() + "\n";
            aux = aux.getSiguiente();
        }
        return datos;
    }

    public String imprimirCodigoGraphviz() {
        String codigoGraphviz = "digraph G {\n";
        if (!vacio()) {
            NodoDoble aux = primero;
            NodoDoble anterior;
            NodoDoble siguiente;
            while (aux != null) {
                codigoGraphviz = codigoGraphviz + aux.getValor() + "[label=\""
                        + aux.getValor() + ", " + aux.getColor() + "\"]\n";
                if (aux.getSiguiente() != null) {
                    siguiente = aux.getSiguiente();
                    codigoGraphviz = codigoGraphviz + aux.getValor() + "->"
                            + siguiente.getValor() + "\n";
                }
                if (aux.getAnterior() != null) {
                    anterior = aux.getAnterior();
                    codigoGraphviz = codigoGraphviz + aux.getValor() + "->"
                            + anterior.getValor() + "\n";
                }
                aux = aux.getSiguiente();
            }
        }
        codigoGraphviz = codigoGraphviz + "}";
        return codigoGraphviz;
    }
}
