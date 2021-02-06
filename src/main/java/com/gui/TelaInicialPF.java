////////// MUDAR O PREENCHIMENTO DOS BOTÕES

package com.gui;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaInicialPF extends JFrame {

    // declarando os JLabel
    JLabel labelHeader = new JLabel("Menu Pessoa Física"), labelSaldo = new JLabel("Saldo");

    // declarando os JButtons
    JButton buttonTI = new JButton("<html><center>Realizar transferência<br />interna</center></html>"),
        buttonExtrato = new JButton("<html><center>Consultar o<br />extrato da conta</center></html>"),
        buttonPix = new JButton("<html><center>Realizar transferência<br />via Pix</center></html>");

    public TelaInicialPF() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());

        // título da tela
        addElemento(painel, labelHeader, 0, 0, 1, 1, GridBagConstraints.CENTER, 10, 100, 70, 100);

        // campo de exibição do saldo
        addElemento(painel, labelSaldo, 0, 1, 1, 1, GridBagConstraints.CENTER, 10, 10, 10, 10);

        // botões de operações
        addElemento(painel, buttonTI, 0, 2, 1, 1, GridBagConstraints.CENTER, 30, 10, 10, 10);
        addElemento(painel, buttonPix, 0, 3, 1, 1, GridBagConstraints.CENTER, 10, 10, 10, 10);
        addElemento(painel, buttonExtrato, 0, 4, 1, 1, GridBagConstraints.CENTER, 10, 10, 70, 10);

        this.add(painel);
        this.pack();
        this.setVisible(true);
    }

    private void addElemento(JPanel p, JComponent c, int linha, int coluna, int largura, 
        int altura, int alinhamento, int superior, int esquerda, int inferior, int direita) {
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = linha;
        gc.gridy = coluna;
        gc.gridwidth = largura;
        gc.gridheight = altura;
        gc.weightx = 100.0;
        gc.weighty = 100.0;
        gc.insets = new Insets(superior, esquerda, inferior, direita);
        gc.anchor = alinhamento;
        gc.fill = GridBagConstraints.NONE;
        p.add(c, gc);
    }
}