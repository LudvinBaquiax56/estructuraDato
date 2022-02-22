/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Estructuras.Nodo;
import Estructuras.Pila;
import WindowsListener.IrAlMenu;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author baquiax
 */
public class VentanaPila extends JFrame implements ventanaEstructura {

    private JFrame menu;
    private Pila pila;

    private JTextArea areaTexto;
    private JScrollPane scrollPanel;

    private JButton btnAgregar;
    private JButton btnEliminar;

    public VentanaPila(JFrame menu, Pila pila) {
        this.menu = menu;
        this.pila = pila;
        iniciarComponentes();
        imprimirCodigoGraphiz();
    }

    private void iniciarComponentes() {
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        super.setTitle("Pila");
        super.setLayout(null);
        super.setSize(310, 450);
        IrAlMenu irAlMenu = new IrAlMenu(menu, this);
        super.addWindowListener(irAlMenu);

        this.scrollPanel = new JScrollPane();
        this.scrollPanel.setBounds(10, 10, 290, 320);
        this.areaTexto = new JTextArea();
        this.areaTexto.setBounds(0, 0, 280, 300);
        this.scrollPanel.setViewportView(areaTexto);

        this.btnAgregar = new JButton();
        this.btnAgregar.setText("Push");
        this.btnAgregar.setBounds(90, 340, 130, 30);
        this.btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                push(e);
            }
        });

        this.btnEliminar = new JButton();
        this.btnEliminar.setText("Pop");
        this.btnEliminar.setBounds(90, 380, 130, 30);
        this.btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pop(e);
            }
        });

        super.add(this.scrollPanel);
        super.add(btnAgregar);
        super.add(btnEliminar);

        super.setResizable(false);
        super.setVisible(true);
        super.setLocationRelativeTo(null);
    }

    private void push(ActionEvent e) {
        Nodo aux = new Nodo(0, "AMARILLO");
        Agregar agregar = new Agregar("Push/Agregar", this, aux);
        pila.push(aux);
    }

    private void pop(ActionEvent e) {
        try {
            pila.pop();
            imprimirCodigoGraphiz();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Pila vacia", ERROR_MESSAGE);
        }
    }

    @Override
    public void imprimirCodigoGraphiz() {
        areaTexto.setText(pila.imprimirCodigoGraphviz());
    }

}
