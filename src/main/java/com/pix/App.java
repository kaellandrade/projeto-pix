package com.pix;

import javax.swing.JFrame;
import com.bancocentral.LerClientes;

import com.gui.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        // JOptionPane
        PixGui gui = new PixGui();
        gui.mostraChave();

        // JFrame (usando janelas)
        PixGui2 lababelFrame = new PixGui2();
        PixGui2 labelFrame = new  PixGui2();
        labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        labelFrame.setSize(300, 200);
        labelFrame.setVisible(true);
    }
}
