package com.gui;

import javax.swing.JOptionPane;

/**
 * PixGui é responsável pela interface gráfica do aplicativo;
 */
public class PixGui {

    public static void dialogo(String msg) {
        JOptionPane.showMessageDialog(null, msg, "ATENÇÃO", JOptionPane.PLAIN_MESSAGE);
    }
}
