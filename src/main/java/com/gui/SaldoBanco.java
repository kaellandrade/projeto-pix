package com.gui;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.GridBagConstraints;

import com.bancocentral.PortalTransparencia;

import javax.swing.JPanel;
import javax.swing.event.AncestorListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

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

    // Declarando o JMenu, JMenuBar e JMenuItem;
    private JMenuBar barra;
    private JMenu menu;
    private JMenuItem login;

    // Variáveis para tratamento de eventos do menu
    private BHandlerLogin bHandlerLogin;

    public SaldoBanco() {
       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());

        // Define o menu e seus componentes
        barra = new JMenuBar();
        menu = new JMenu("Opções");
        login = new JMenuItem("Tela de login");
        bHandlerLogin = new BHandlerLogin();

        // Testando para o banco do brasil
        ArrayList<Float> total = new ArrayList<>();
        labelSaldoCC.setText(Float.toString(transparencia.calcularMontanteBrasil().get("corrente")));
        labelSaldoPP.setText(Float.toString(transparencia.calcularMontanteBrasil().get("poupanca")));
        labelSaldoCS.setText(Float.toString(transparencia.calcularMontanteBrasil().get("salario")));

        // Adição dos elementos
        addElemento(painel, labelH1, 0, 0, 1, 1, GridBagConstraints.CENTER, 10, 100, 30, 100);
        addElemento(painel, labelH2, 0, 1, 1, 1, GridBagConstraints.WEST, 10, 10, 3, 10);
        addElemento(painel, labelSaldoCC, 0, 3, 1, 1, GridBagConstraints.CENTER, 40, 10, 50, 10);
        addElemento(painel, labelSaldoPP, 0, 4, 1, 1, GridBagConstraints.CENTER, 40, 10, 50, 10);
        addElemento(painel, labelSaldoCS, 0, 5, 1, 1, GridBagConstraints.CENTER, 40, 10, 50, 10);
        addElemento(painel, labelSaldoGeral, 0, 6, 1, 1, GridBagConstraints.CENTER, 40, 10, 50, 10);
        addElemento(painel, selecaoBanco, 0, 2, 1, 1, GridBagConstraints.WEST, 3, 10, 10, 10);

        // adiciona menu ao JFrame
        menu.add(login);
        barra.add(menu);
        this.setJMenuBar(barra);

        // Tratamento de eventos
        login.addActionListener(bHandlerLogin);

        this.add(painel);
        this.pack();
        this.setLocationRelativeTo(null);
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

    // Tratamento de eventos do menu (login)
    private class BHandlerLogin implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            Abertura abertura = new Abertura();
            dispose();
        }
    }
    
}
