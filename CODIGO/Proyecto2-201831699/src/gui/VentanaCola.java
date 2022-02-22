/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Estructuras.Cola;
import Estructuras.Nodo;
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
public class VentanaCola extends JFrame implements ventanaEstructura {

    private JFrame menu;
    private Cola cola;

    private JTextArea areaTexto;
    private JScrollPane scrollPanel;

    private JButton btnAgregar;
    private JButton btnEliminar;

    public VentanaCola(JFrame menu, Cola cola) {
        this.menu = menu;
        this.cola = cola;
        iniciarComponentes();
        imprimirCodigoGraphiz();
    }

    private void iniciarComponentes() {
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        super.setTitle("Cola");
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
        this.btnAgregar.setText("Encolar");
        this.btnAgregar.setBounds(90, 340, 130, 30);
        this.btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encolar(e);
            }
        });

        this.btnEliminar = new JButton();
        this.btnEliminar.setText("Desencolar");
        this.btnEliminar.setBounds(90, 380, 130, 30);
        this.btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desencolar(e);
            }
        });

        super.add(this.scrollPanel);
        super.add(btnAgregar);
        super.add(btnEliminar);

        super.setResizable(false);
        super.setVisible(true);
        super.setLocationRelativeTo(null);
    }

    private void encolar(ActionEvent e) {
        Nodo aux = new Nodo(0, "VERDE");
        Agregar agregar = new Agregar("Encolar/Agregar", this, aux);
        cola.encolar(aux);
    }

    private void desencolar(ActionEvent e) {
        try {
            cola.desencolar();
            imprimirCodigoGraphiz();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Cola vacia", ERROR_MESSAGE);
        }
    }

    @Override
    public void imprimirCodigoGraphiz() {
        areaTexto.setText(cola.imprimirCodigoGraphviz());
    }

}
