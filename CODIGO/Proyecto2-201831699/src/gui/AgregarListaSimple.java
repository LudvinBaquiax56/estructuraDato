/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Estructuras.Nodo;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author baquiax
 */
public class AgregarListaSimple extends JFrame {
    
    private JFrame ventana;
    private Nodo nodo;
    
    private JTextField txtValor;
    private JTextField txtColor;
    
    private JLabel lblValor;
    private JLabel lblColor;
    
    private JButton btnAgregar;
    
    public AgregarListaSimple(JFrame ventana, Nodo nodo) {
        
        this.ventana = ventana;
        this.nodo = nodo;
        super.setTitle("Agregar");
        this.ventana.setVisible(false);
        iniciarComponentes();

        //super.setVisible(true);
    }
    
    private void iniciarComponentes() {
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        
        txtValor = new JTextField();
        btnAgregar = new JButton();
        txtColor = new JTextField();
        lblValor = new JLabel("Valor: ");
        lblColor = new JLabel("Color: ");
        
        super.setLayout(null);
        
        lblValor.setBounds(10, 10, 180, 30);
        txtValor.setBounds(10, 50, 180, 30);
        
        lblColor.setBounds(10, 90, 180, 30);
        txtColor.setBounds(10, 130, 180, 30);
        
        btnAgregar.setText("Agregar");
        btnAgregar.setBounds(10, 180, 180, 30);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregar(e);
            }
        });
        
        super.setSize(200, 260);
        super.add(lblValor);
        super.add(txtValor);
        super.add(lblColor);
        super.add(txtColor);
        super.add(btnAgregar);
        
        super.setAlwaysOnTop(true);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }
    
    private void agregar(ActionEvent e) {
        if (!txtValor.getText().isEmpty() || !txtColor.getText().isEmpty()) {
            this.nodo.setValor(Integer.parseInt(txtValor.getText()));
            this.nodo.setColor(txtColor.getText());
            if (ventana instanceof ventanaEstructura) {
                ventanaEstructura aux = (ventanaEstructura) ventana;
                aux.imprimirCodigoGraphiz();
            }
            super.dispose();
            ventana.setVisible(true);
            
        }
    }
}
