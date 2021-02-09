package com.gui;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.event.*;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.pessoa.Cliente;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Extrato extends JFrame {
    
    private Cliente cliente;
    
    JLabel labelHeader = new JLabel("Extrato bancário");
    JTextArea textAreaExtrato = new JTextArea(20, 5);

    // Declarando o JMenu, JMenuBar e JMenuItem;
    private JMenuBar barra;
    private JMenu menu;
    private JMenuItem login;

    // Variáveis para tratamento de eventos do menu
    private BHandlerLogin bHandlerLogin;

    public Extrato(Cliente cli) {

        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Define o menu e seus componentes
        barra = new JMenuBar();
        menu = new JMenu("Opções");
        login = new JMenuItem("Tela de login");
        bHandlerLogin = new BHandlerLogin();

        this.cliente = cli;
        
        String extrato = cli.getConta().getExtrato().toString();

        textAreaExtrato.setEditable(false);
        textAreaExtrato.setText(extrato);

        addElemento(painel, labelHeader, 0, 1, GridBagConstraints.CENTER, 10, 100, 10, 100);
        addElemento(painel, textAreaExtrato, 1, 1, GridBagConstraints.CENTER, 10, 30, 10, 30);

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

    private void addElemento(JPanel p, JComponent c, int coluna, int linha, int alinhamento,
            int superior, int esquerda, int inferior, int direita) {
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = linha;
        gc.gridy = coluna;
        gc.gridwidth = 1;
        gc.gridheight = 1;
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
