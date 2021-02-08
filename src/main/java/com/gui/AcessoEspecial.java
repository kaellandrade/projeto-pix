package com.gui;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.event.*;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AcessoEspecial extends JFrame {

    // declarando os JLabel
    JLabel labelHeader = new JLabel("Menu do Acesso Especial");

    // declarando os JButtons
    JButton buttonBanco = new JButton("Saldo dos bancos"),
        buttonAgencia = new JButton("Saldo das agências"),
        buttonCliente = new JButton("Saldo dos clientes");

    private BHandlerBanco bHandlerBanco;

    public AcessoEspecial() {
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());

        BHandlerBanco bHandlerBanco = new BHandlerBanco();

        // adição dos elementos
        addElemento(painel, labelHeader, 0, 0, 1, 1, GridBagConstraints.CENTER, 10, 100, 70, 100);
        addElemento(painel, buttonBanco, 0, 2, 1, 1, GridBagConstraints.CENTER, 30, 10, 10, 10);
        addElemento(painel, buttonAgencia, 0, 3, 1, 1, GridBagConstraints.CENTER, 10, 10, 10, 10);
        addElemento(painel, buttonCliente, 0, 4, 1, 1, GridBagConstraints.CENTER, 10, 10, 70, 10);

        this.add(painel);
        this.pack();
        this.setVisible(true);

        buttonBanco.addActionListener(bHandlerBanco);
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

    private class BHandlerBanco implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            SaldoBanco saldoBanco = new SaldoBanco();
            dispose();
        }
    }
}