/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Estructuras.ExepcionEstructura;
import Estructuras.ListaCircular;
import Estructuras.ListaDoble;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JTextField;

/**
 *
 * @author baquiax
 */
public class EliminarListaCircular extends JFrame {

    ListaCircular lista;
    VentanaListaCircular ventana;

    JTextField txtValor;
    JButton btnAgregar;
    JLabel lblValor;

    public EliminarListaCircular(VentanaListaCircular ventana, ListaCircular lista) throws HeadlessException {
        super.setTitle("Eliminar");
        this.ventana = ventana;
        this.lista = lista;
        iniciarComponentes();
        this.ventana.setVisible(false);
    }

    /**
     * Inicia los componentes del Frame
     *
     * @param title
     */
    private void iniciarComponentes() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        txtValor = new JTextField();
        btnAgregar = new JButton();
        lblValor = new JLabel("Valor: ");

        super.setLayout(null);

        lblValor.setBounds(10, 10, 180, 30);
        txtValor.setBounds(10, 50, 180, 30);

        btnAgregar.setText("Eliminar");
        btnAgregar.setBounds(10, 90, 180, 30);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminar(e);
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

    private void eliminar(ActionEvent e) {
        if (!txtValor.getText().isEmpty()) {
            try {
                lista.eleminarElementoEspecifico(Integer.parseInt(txtValor.getText()));
                this.ventana.imprimirCodigoGraphiz();
            } catch (ExepcionEstructura ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", ERROR_MESSAGE);
            }
            super.dispose();
            this.ventana.setVisible(true);
        }
    }
}

