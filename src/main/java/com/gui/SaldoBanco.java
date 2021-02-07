package com.gui;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.GridBagConstraints;

import javax.swing.JPanel;

import com.bancocentral.PortalTransparencia;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class SaldoBanco extends JFrame {
    PortalTransparencia transparencia = new PortalTransparencia();

    // declarando o JLabel
    JLabel labelH1 = new JLabel("Informações privilegiadas"),
    labelH2 = new JLabel("Saldo dos bancos"),
    labelSaldoCC = new JLabel("Saldo CC"),
    labelSaldoPP = new JLabel("Saldo PP"),
    labelSaldoCS = new JLabel("Saldo CS"),
    labelSaldoGeral = new JLabel("Saldo geral");

    // declarando o JComboBox
    String bancos[] = {"Banco do Brasil", "Bradesco", "Itaú", "Santander"};
    JComboBox selecaoBanco = new JComboBox(bancos);

    public SaldoBanco() {
        // Testando para o banco do brasil
        ArrayList<Float> total = new ArrayList<>();
        labelSaldoCC.setText(Float.toString(transparencia.calcularMontanteBrasil().get("corrente")));
        labelSaldoPP.setText(Float.toString(transparencia.calcularMontanteBrasil().get("poupanca")));
        labelSaldoCS.setText(Float.toString(transparencia.calcularMontanteBrasil().get("salario")));

        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());

        // adição dos JLabel
        addElemento(painel, labelH1, 0, 0, 1, 1, GridBagConstraints.CENTER, 10, 100, 30, 100);
        addElemento(painel, labelH2, 0, 1, 1, 1, GridBagConstraints.WEST, 10, 10, 3, 10);
        addElemento(painel, labelSaldoCC, 0, 3, 1, 1, GridBagConstraints.CENTER, 40, 10, 50, 10);
        addElemento(painel, labelSaldoPP, 0, 4, 1, 1, GridBagConstraints.CENTER, 40, 10, 50, 10);
        addElemento(painel, labelSaldoCS, 0, 5, 1, 1, GridBagConstraints.CENTER, 40, 10, 50, 10);
        addElemento(painel, labelSaldoGeral, 0, 6, 1, 1, GridBagConstraints.CENTER, 40, 10, 50, 10);

        // adição do JComboBox
        addElemento(painel, selecaoBanco, 0, 2, 1, 1, GridBagConstraints.WEST, 3, 10, 10, 10);

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
