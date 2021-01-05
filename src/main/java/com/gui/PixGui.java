package com.gui;
import com.bancocentral.Pix;
import javax.swing.JOptionPane;

public class PixGui {
    public void mostraChave() {
        JOptionPane.showMessageDialog(null, "Sua chave é: " + Pix.gerarChavePix(), "Nova Chave", JOptionPane.PLAIN_MESSAGE);
    }
}
