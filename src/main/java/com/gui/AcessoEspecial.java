package com.gui;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.event.*;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class AcessoEspecial extends JFrame {

    // declarando os JLabel
    JLabel labelHeader = new JLabel("Menu do Acesso Especial");

    // declarando os JButtons
    JButton buttonBanco = new JButton("Saldo dos bancos"),
        buttonAgencia = new JButton("Saldo das agências"),
        buttonCliente = new JButton("Saldo dos clientes");

    private BHandlerBanco bHandlerBanco;

    // Declarando o JMenu, JMenuBar e JMenuItem;
    private JMenuBar barra;
    private JMenu menu;
    private JMenuItem login;

    // Variáveis para tratamento de eventos do menu
    private BHandlerLogin bHandlerLogin;

    public AcessoEspecial() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());

        // Define o menu e seus componentes
        barra = new JMenuBar();
        menu = new JMenu("Opções");
        login = new JMenuItem("Tela de login");
        bHandlerLogin = new BHandlerLogin();

        BHandlerBanco bHandlerBanco = new BHandlerBanco();

        // adição dos elementos
        addElemento(painel, labelHeader, 1, 0, GridBagConstraints.CENTER, 10, 100, 10, 100, GridBagConstraints.NONE, 50);
        addElemento(painel, buttonBanco, 1, 1, GridBagConstraints.CENTER, 30, 80, 10, 80, GridBagConstraints.HORIZONTAL, 10);
        addElemento(painel, buttonAgencia, 1, 2, GridBagConstraints.CENTER, 10, 80, 10, 80, GridBagConstraints.HORIZONTAL, 10);
        addElemento(painel, buttonCliente, 1, 3, GridBagConstraints.CENTER, 10, 80, 40, 80, GridBagConstraints.HORIZONTAL, 10);

        // adiciona menu ao JFrame
        menu.add(login);
        barra.add(menu);
        this.setJMenuBar(barra);
        
        // Tratamento de eventos
        login.addActionListener(bHandlerLogin);
        buttonBanco.addActionListener(bHandlerBanco);

        this.add(painel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    // Método que adiciona os elementos
    private void addElemento(JPanel p, JComponent c, int coluna, int linha, int alinhamento, 
        int superior, int esquerda, int inferior, int direita, int preenchimento, int ipady) {
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = coluna;
        gc.gridy = linha;
        gc.gridwidth = 1;
        gc.gridheight = 1;
        gc.ipady = ipady;
        gc.insets = new Insets(superior, esquerda, inferior, direita);
        gc.anchor = alinhamento;
        gc.fill = preenchimento;
        p.add(c, gc);
    }

    private class BHandlerBanco implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            SaldoBanco saldoBanco = new SaldoBanco();
            dispose();
        }
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