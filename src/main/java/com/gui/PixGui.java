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
    public void mostraChave() {
        JOptionPane.showMessageDialog(null, "Sua chave é: " + Pix.gerarChavePix(), "Nova Chave",
                JOptionPane.PLAIN_MESSAGE);
    }
}
