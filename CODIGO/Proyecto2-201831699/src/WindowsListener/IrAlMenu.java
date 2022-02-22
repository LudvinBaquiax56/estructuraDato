/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WindowsListener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

/**
 *
 * @author baquiax
 */
public class IrAlMenu implements WindowListener {

    JFrame menu;
    JFrame ventana;

    public IrAlMenu(JFrame menu, JFrame ventana) {
        this.menu = menu;
        this.ventana = ventana;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        menu.setVisible(false);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        ventana.setVisible(false);
        ventana.dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        menu.setVisible(true);
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}
