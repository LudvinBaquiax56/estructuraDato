/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Estructuras.ListaDoble;
import Estructuras.NodoDoble;
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
public class VentanaListaDoble extends JFrame implements ventanaEstructura {

    private JFrame menu;
    private ListaDoble listaDoble;

    private JTextArea areaTexto;
    private JScrollPane scrollPanel;

    private JButton btnAgregar;
    private JButton btnEliminar;

    public VentanaListaDoble(JFrame menu, ListaDoble listaDoble) {
        this.menu = menu;
        this.listaDoble = listaDoble;
        iniciarComponentes();
        imprimirCodigoGraphiz();
    }

    private void iniciarComponentes() {
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        super.setTitle("Lista Doble");
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
        NodoDoble aux = new NodoDoble(0, "AZUL");
        AgregarDoble agregarDoble = new AgregarDoble("Agregar", this, aux);
        listaDoble.insertar(aux);
    }

    private void eliminarElemento(ActionEvent e) {
        EliminarListaDoble ventana = new EliminarListaDoble(this, listaDoble);
    }

    @Override
    public void imprimirCodigoGraphiz() {
        areaTexto.setText(listaDoble.imprimirCodigoGraphviz());
    }

}
