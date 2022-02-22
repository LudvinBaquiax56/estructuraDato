/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Estructuras.NodoDoble;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author baquiax
 */
public class AgregarDoble extends JFrame {

    JFrame ventana;
    NodoDoble nodo;

    JTextField txtValor;
    JButton btnAgregar;
    JLabel lblValor;

    public AgregarDoble(String title,
            JFrame ventana, NodoDoble nodo) {

        this.ventana = ventana;
        this.nodo = nodo;
        super.setTitle(title);
        this.ventana.setVisible(false);
        iniciarComponentes(title);
    }

    /**
     * Inicia los componentes del Frame
     *
     * @param title
     */
    private void iniciarComponentes(String title) {

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        txtValor = new JTextField();
        btnAgregar = new JButton();
        lblValor = new JLabel("Valor: ");

        super.setLayout(null);

        lblValor.setBounds(10, 10, 180, 30);
        txtValor.setBounds(10, 50, 180, 30);

        btnAgregar.setText(title);
        btnAgregar.setBounds(10, 90, 180, 30);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregar(e);
            }
        });

        super.setSize(200, 180);
        super.add(lblValor);
        super.add(txtValor);
        super.add(btnAgregar);

        super.setAlwaysOnTop(true);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }

    private void agregar(ActionEvent e) {
        if (!txtValor.getText().isEmpty()) {
            this.nodo.setValor(Integer.parseInt(txtValor.getText()));
            if (ventana instanceof ventanaEstructura) {
                ventanaEstructura aux = (ventanaEstructura) ventana;
                aux.imprimirCodigoGraphiz();
            }
            super.dispose();
            ventana.setVisible(true);
        }
    }
}
