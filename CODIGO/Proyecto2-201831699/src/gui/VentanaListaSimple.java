/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Estructuras.ListaSimple;
import Estructuras.Nodo;
import WindowsListener.IrAlMenu;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author baquiax
 */
public class VentanaListaSimple extends JFrame implements ventanaEstructura {

    private JFrame menu;
    private ListaSimple listaSimple;

    private JTextArea areaTexto;
    private JScrollPane scrollPanel;

    private JButton btnAgregar;
    private JButton btnEliminar;

    public VentanaListaSimple(JFrame menu, ListaSimple listaSimple) {
        this.menu = menu;
        this.listaSimple = listaSimple;
        iniciarComponentes();
        imprimirCodigoGraphiz();
    }

    private void iniciarComponentes() {
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        super.setTitle("Lista Simple");
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
        this.btnAgregar.setText("Agregar");
        this.btnAgregar.setBounds(90, 340, 130, 30);
        this.btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarElemento(e);
            }
        });

        this.btnEliminar = new JButton();
        this.btnEliminar.setText("Eliminar");
        this.btnEliminar.setBounds(90, 380, 130, 30);
        this.btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarElemento(e);
            }
        });

        super.add(this.scrollPanel);
        super.add(btnAgregar);
        super.add(btnEliminar);

        super.setResizable(false);
        super.setVisible(true);
        super.setLocationRelativeTo(null);
    }

    private void agregarElemento(ActionEvent e) {
        Nodo aux = new Nodo(0, "");
        AgregarListaSimple agregarListaSimple = new AgregarListaSimple(this, aux);
        listaSimple.insertar(aux);
    }

    private void eliminarElemento(ActionEvent e) {
        EliminarListaSimple eliminarListaSimple = new EliminarListaSimple(this, listaSimple);
    }

    @Override
    public void imprimirCodigoGraphiz() {
        this.areaTexto.setText(listaSimple.imprimirCodigoGraphviz());
    }
}
