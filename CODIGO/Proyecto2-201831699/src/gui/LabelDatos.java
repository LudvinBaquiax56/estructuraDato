/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author baquiax
 */
public class LabelDatos extends JLabel {

    private int valor;
    private String color;

    public LabelDatos(int valor, String color) {
        this.valor = valor;
        this.color = color;
        super.setSize(77, 77);
        super.setOpaque(true);
        super.setVerticalAlignment(SwingConstants.CENTER);
        super.setHorizontalAlignment(SwingConstants.CENTER);
        super.setFont(new Font("Serif", Font.PLAIN, 30));
        super.setText(String.valueOf(valor));
        establecerColor(color);
    }

    private void establecerColor(String color) {
        switch (color) {
            case "AZUL":
                super.setBackground(Color.blue);
                break;
            case "ROJO":
                super.setBackground(Color.red);
                break;
            case "AMARILLO":
                super.setBackground(Color.yellow);
                break;
            case "VERDE":
                super.setBackground(Color.green);
                break;
            default:
        }
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

}
