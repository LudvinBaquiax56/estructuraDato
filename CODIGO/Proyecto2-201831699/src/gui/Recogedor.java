/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author baquiax
 */
public class Recogedor extends JLabel {

    private int fila;
    private int columna;

    public Recogedor() {
        this.fila = 0;
        this.columna = 0;
        super.setBounds(0, 0, 77, 77);
        super.setOpaque(true);
        super.setBackground(Color.black);
        
    }

    void reiniciar() {
        this.setFila(0);
        this.setColumna(0);
        super.setLocation(0, 0);
    }

    /**
     * @return the fila
     */
    public int getFila() {
        return fila;
    }

    /**
     * @param fila the fila to set
     */
    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     * @return the columna
     */
    public int getColumna() {
        return columna;
    }

    /**
     * @param columna the columna to set
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }

}
