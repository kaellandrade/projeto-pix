package com.gui;

import com.bancocentral.Pix;
import javax.swing.JOptionPane;

/**
 * PixGui é responsável pela interface gráfica do aplicativo;
 */
public class PixGui {

    /**
     * Mostra chave gerada em uma caixa de diálogo;
     */
    public static void dialogo(String msg) {
        JOptionPane.showMessageDialog(null, msg, "ATEÇÃO", JOptionPane.PLAIN_MESSAGE);
    }
}
