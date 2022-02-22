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
public class ListaCircular {
    
    private int tamanio;
    private NodoDoble primero;
    private NodoDoble ultimo;

    /**
     * Crea una lista circular doblementes enlazada
     */
    public ListaCircular() {
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
    
    public void insertar(NodoDoble elemento) {
        if (vacio()) {
            primero = elemento;
            ultimo = elemento;
            primero.setSiguiente(elemento);
            ultimo.setAnterior(primero);
        } else {
            if (tamanio == 1) {
                primero.setSiguiente(elemento);
                primero.setAnterior(elemento);
                
                elemento.setAnterior(primero);
                elemento.setSiguiente(primero);
            } else {
                NodoDoble aux = primero;
                while (aux.getSiguiente() != primero) {
                    aux = aux.getSiguiente();
                }
                aux.setSiguiente(elemento);
                elemento.setAnterior(aux);
                
                elemento.setSiguiente(primero);
                primero.setAnterior(elemento);
            }
        }
        tamanio++;
    }

    /**
     * Retorna un nodo
     *
     * @param valorElemeto
     * @return
     * @throws ExepcionEstructura
     */
    public NodoDoble eleminarElementoEspecifico(int valorElemeto) throws ExepcionEstructura {
        if (vacio()) {
            throw new ExepcionEstructura("Error la lista esta vacia");
        } else {
            if (tamanio == 1 && primero.getValor() == valorElemeto) {
                NodoDoble aux = primero;
                primero = null;
                ultimo = null;
                tamanio--;
                return aux;
            } else if (primero.getValor() == valorElemeto) {
                NodoDoble aux = primero;
                primero = primero.getSiguiente();
                primero.setAnterior(aux.getAnterior());
                aux.getAnterior().setSiguiente(primero);
                tamanio--;
                return aux;
            } else {
                NodoDoble anterior = primero;
                NodoDoble actual = primero.getSiguiente();
                while (actual.getSiguiente() != primero && actual.getValor() != valorElemeto) {
                    anterior = actual;
                    actual = actual.getSiguiente();
                }
                if (actual.getValor() == valorElemeto) {
                    anterior.setSiguiente(actual.getSiguiente());
                    
                    actual.getSiguiente().setAnterior(anterior);
                    
                    tamanio--;
                    return actual;
                } else {
                    throw new ExepcionEstructura("Error el valor no existe");
                }
            }
        }
    }
    
    public String imprimir() {
        String datos = "";
        if (!vacio()) {
            NodoDoble aux = primero;
            do {
                datos = datos + aux.imprimir() + "\n";
                aux = aux.getSiguiente();
            } while (aux != primero);
            
        }
        return datos;
    }
    
    public String imprimirCodigoGraphviz() {
        String codigoGraphviz = "digraph G {\nlayout=circo;\n";
        if (!vacio()) {
            NodoDoble aux = primero;
            do {
                codigoGraphviz = codigoGraphviz + aux.getValor() + "[label=\""
                        + aux.getValor() + ", " + aux.getColor() + "\"]\n";
                
                codigoGraphviz = codigoGraphviz + aux.getValor() + "->"
                        + aux.getSiguiente().getValor() + "[color=red];\n";
                codigoGraphviz = codigoGraphviz + aux.getValor() + "->"
                        + aux.getAnterior().getValor() + "[color=blue];\n";
                aux = aux.getSiguiente();
                
            } while (aux != primero);
            
        }
        codigoGraphviz = codigoGraphviz + "}";
        return codigoGraphviz;
    }
}
