/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Estructuras.*;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author baquiax
 */
public class VentanaInicio extends JFrame {

    private ListaCircular listaCircular;
    private ListaSimple listaSimple;
    private ListaDoble listaDoble;
    private Cola cola;
    private Pila pila;

    private JPanel panelBotones;
    private JPanel panelLabels;

    private LabelDatos[][] matrizDatos;
    private Recogedor recogedor;

    private JButton btnCargarDatos;
    private JButton btnReiniciar;
    private JButton btnListaCircular;
    private JButton btnListaSimple;
    private JButton btnListaDoble;
    private JButton btnPila;
    private JButton btnCola;

    public VentanaInicio() throws HeadlessException {
        iniciarComponentes();
        this.listaCircular = new ListaCircular();
        this.listaSimple = new ListaSimple();
        this.listaDoble = new ListaDoble();
        this.cola = new Cola();
        this.pila = new Pila();
        this.matrizDatos = new LabelDatos[5][7];
    }

    private void iniciarComponentes() {
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setTitle("Recogedor de bloques");
        super.setLayout(null);
        super.setSize(560, 535);

        panelBotones = new JPanel();
        panelBotones.setBackground(Color.cyan);
        panelBotones.setBounds(10, 10, 540, 90);
        panelBotones.setLayout(null);

        panelLabels = new JPanel();
        panelLabels.setBackground(Color.LIGHT_GRAY);
        panelLabels.setBounds(10, 110, 539, 385);
        panelLabels.setLayout(null);

        //Botones
        this.btnCargarDatos = crearBotonDeControl(3, 10, "Cargar Datos");
        this.btnCargarDatos.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarDatos(e);
            }
        });

        this.btnReiniciar = crearBotonDeControl(3, 50, "Reiniciar");
        this.btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reniciar(e);
            }
        });

        this.btnListaCircular = crearBotonDeControl(138, 30, "Lista Circular");
        this.btnListaCircular.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verListaCircular(e);
            }
        });

        this.btnListaSimple = crearBotonDeControl(273, 10, "Lista Simple");
        this.btnListaSimple.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verListaSimple(e);
            }
        });

        this.btnPila = crearBotonDeControl(273, 50, "Pila");
        this.btnPila.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verPila(e);
            }
        });
        this.btnListaDoble = crearBotonDeControl(407, 10, "Lista Doble");
        this.btnListaDoble.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verListaDoble(e);
            }
        });

        this.btnCola = crearBotonDeControl(407, 50, "Cola");
        this.btnCola.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verCola(e);
            }
        });

        this.panelBotones.add(btnCargarDatos);
        this.panelBotones.add(btnReiniciar);
        this.panelBotones.add(btnListaCircular);
        this.panelBotones.add(btnListaSimple);
        this.panelBotones.add(btnPila);
        this.panelBotones.add(btnListaDoble);
        this.panelBotones.add(btnCola);

        recogedor = new Recogedor();
        recogedor.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                moverRecogedor(evt);
            }
        });

        panelLabels.add(recogedor);

        this.btnCargarDatos.setFocusable(false);
        this.btnCola.setFocusable(false);
        this.btnListaCircular.setFocusable(false);
        this.btnListaDoble.setFocusable(false);
        this.btnListaSimple.setFocusable(false);
        this.btnPila.setFocusable(false);
        this.btnReiniciar.setFocusable(false);

        recogedor.setFocusable(true);

        super.add(panelLabels);
        super.add(panelBotones);

        super.setResizable(false);
        super.setVisible(true);
        super.setLocationRelativeTo(null);
    }

    private void moverRecogedor(KeyEvent evt) {
        switch (evt.getExtendedKeyCode()) {
            case KeyEvent.VK_RIGHT:
                if (recogedor.getX() < 462) {
                    recogedor.setLocation(recogedor.getX() + 77, recogedor.getY());
                    recogedor.setColumna(recogedor.getColumna() + 1);
                }
                break;
            case KeyEvent.VK_LEFT:
                if (recogedor.getX() >= 77) {
                    recogedor.setLocation(recogedor.getX() - 77, recogedor.getY());
                    recogedor.setColumna(recogedor.getColumna() - 1);
                }
                break;
            case KeyEvent.VK_UP:
                if (recogedor.getY() >= 77) {
                    recogedor.setLocation(recogedor.getX(), recogedor.getY() - 77);
                    recogedor.setFila(recogedor.getFila() - 1);
                }
                break;
            case KeyEvent.VK_DOWN:
                if (recogedor.getY() < 308) {
                    recogedor.setLocation(recogedor.getX(), recogedor.getY() + 77);
                    recogedor.setFila(recogedor.getFila() + 1);
                }
                break;
            default:
        }

        if (matrizDatos[recogedor.getFila()][recogedor.getColumna()] != null) {
            switch (matrizDatos[recogedor.getFila()][recogedor.getColumna()].getColor()) {
                case "AZUL":
                    listaDoble.insertar(new NodoDoble(matrizDatos[recogedor.getFila()][recogedor.getColumna()].getValor(), matrizDatos[recogedor.getFila()][recogedor.getColumna()].getColor()));
                    break;
                case "ROJO":
                    listaCircular.insertar(new NodoDoble(matrizDatos[recogedor.getFila()][recogedor.getColumna()].getValor(), matrizDatos[recogedor.getFila()][recogedor.getColumna()].getColor()));
                    break;
                case "AMARILLO":
                    pila.push(new Nodo(matrizDatos[recogedor.getFila()][recogedor.getColumna()].getValor(), matrizDatos[recogedor.getFila()][recogedor.getColumna()].getColor()));
                    break;
                case "VERDE":
                    cola.encolar(new Nodo(matrizDatos[recogedor.getFila()][recogedor.getColumna()].getValor(), matrizDatos[recogedor.getFila()][recogedor.getColumna()].getColor()));
                    break;
                default:
            }
            panelLabels.remove(matrizDatos[recogedor.getFila()][recogedor.getColumna()]);
            matrizDatos[recogedor.getFila()][recogedor.getColumna()] = null;
        }
    }

    /**
     * Cargar Datos con file chooser
     *
     * @param e
     */
    private void cargarDatos(ActionEvent evt) {

        JFileChooser fileChooser = new JFileChooser();

        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.ipc1", "ipc1");
        fileChooser.setFileFilter(filtro);

        int seleccion = fileChooser.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            String ruta = fileChooser.getSelectedFile().getAbsolutePath();
            try (FileReader entrada = new FileReader(ruta)) {
                BufferedReader miBuffer = new BufferedReader(entrada);
                String linea = "";
                String datos = "";
                while (linea != null) {

                    linea = miBuffer.readLine();
                    if (linea != null) {
                        datos = datos + linea + "\n";
                    }
                }
                String[] aux = datos.split("\n");

                for (int i = 1; i < aux.length; i++) {
                    //System.out.println(aux[i]);
                    String[] congiguracionAux = aux[i].split(",");
                    matrizDatos[Integer.parseInt(congiguracionAux[0])][Integer.parseInt(congiguracionAux[1])]
                            = new LabelDatos(Integer.parseInt(congiguracionAux[2]), congiguracionAux[3]);
                    matrizDatos[Integer.parseInt(congiguracionAux[0])][Integer.parseInt(congiguracionAux[1])].setLocation(Integer.parseInt(congiguracionAux[1]) * 77, Integer.parseInt(congiguracionAux[0]) * 77);
                    listaSimple.insertar(new Nodo(Integer.parseInt(congiguracionAux[2]), congiguracionAux[3]));
                    panelLabels.add(matrizDatos[Integer.parseInt(congiguracionAux[0])][Integer.parseInt(congiguracionAux[1])]);
                }
                panelLabels.repaint();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VentanaInicio.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(VentanaInicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (seleccion == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún fichero", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else if (rootPaneCheckingEnabled) {
            JOptionPane.showMessageDialog(this, "Error en la busqueda del archivo", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Reiniciar el tablero y listas
     *
     * @param e
     */
    private void reniciar(ActionEvent e) {
        recogedor.reiniciar();
        recogedor.setFocusable(false);
        this.listaCircular = new ListaCircular();
        this.listaSimple = new ListaSimple();
        this.listaDoble = new ListaDoble();
        this.cola = new Cola();
        this.pila = new Pila();
        matrizDatos = new LabelDatos[5][7];
        panelLabels.removeAll();
        panelLabels.add(recogedor);
        panelLabels.revalidate();

        recogedor.setFocusable(true);
        this.repaint();

        this.setVisible(false);
        this.setVisible(true);
    }

    /**
     * Abre una ventana para ver los datos y acciones de la lista circular
     *
     * @param e
     */
    private void verListaCircular(ActionEvent e) {
        VentanaListaCircular ventanaListaCircular = new VentanaListaCircular(this, listaCircular);
    }

    /**
     * Abre una ventana para ver los datos y acciones de la lista simple
     *
     * @param e
     */
    private void verListaSimple(ActionEvent e) {
        VentanaListaSimple ventanaListaSimple = new VentanaListaSimple(this, listaSimple);
    }

    /**
     * Abre una ventana para ver los datos y acciones de la Pila
     *
     * @param e
     */
    private void verPila(ActionEvent e) {
        VentanaPila ventanaPila = new VentanaPila(this, pila);
    }

    /**
     * Abre una ventana para ver los datos y acciones de una Lista Doble
     *
     * @param e
     */
    private void verListaDoble(ActionEvent e) {
        VentanaListaDoble ventanaListaDoble = new VentanaListaDoble(this, listaDoble);
    }

    /**
     * Abre una venta para ver los datos y acciones de una Cola
     *
     * @param e
     */
    private void verCola(ActionEvent e) {
        VentanaCola ventanaCola = new VentanaCola(this, cola);
    }

    private JButton crearBotonDeControl(int x, int y, String texto) {
        JButton aux = new JButton(texto);
        aux.setBounds(x, y, 130, 30);
        return aux;
    }
}
