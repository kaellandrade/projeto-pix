package com.gui;

import com.banco.Conta;
import com.pessoa.Cliente;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.awt.GridBagConstraints;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TelaPix extends JFrame {
    private com.pessoa.Cliente cliente;
    private Collection<Cliente> clientes;
    private final Icon iconKey = new ImageIcon("../projeto-pix/imgs/key.png");

    // declarando os elementos
    JLabel labelHeader = new JLabel("Pix");
    JTextField labelChave = new JTextField("Crie uma chave em 'Gerenciar chaves'");
    JButton buttonTransferir = new JButton("Realizar transferência"), buttonExtrato = new JButton("Extrato"),
            buttonGenChaves = new JButton("Gerenciar chaves");

    private BHandlerTransferir bHandlerTransferir;
    // private BHandlerExtrato bHandlerExtrato;
    private BHandlerGenChaves bHandlerGenChaves;

    private Conta conta;

    // Declarando o JMenu, JMenuBar e JMenuItem;
    private JMenuBar barra;
    private JMenu menu;
    private JMenuItem login;

    // Variáveis para tratamento de eventos do menu
    private BHandlerLogin bHandlerLogin;

    public TelaPix(Cliente cliente, Collection clientes) {

        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Define o menu e seus componentes
        barra = new JMenuBar();
        menu = new JMenu("Opções");
        login = new JMenuItem("Tela de login");
        bHandlerLogin = new BHandlerLogin();

        this.cliente = cliente;
        this.clientes = clientes;

        String minhaChave = cliente.getConta().getChavePIX();

        bHandlerTransferir = new BHandlerTransferir();
        labelHeader.setIcon(iconKey);
        
        labelChave.setEditable(false);
        if (!minhaChave.isEmpty()) { // caso tenha uma chave
            labelChave.setText("Sua chave é: " + minhaChave);
        }

        // bHandlerExtrato = new BHandlerExtrato();
        bHandlerGenChaves = new BHandlerGenChaves();

        // Adição dos elementos
        addElemento(painel, labelHeader, 1, 0, GridBagConstraints.CENTER, 10, 150, 40, 150, GridBagConstraints.NONE, 10);
        addElemento(painel, labelChave, 1, 1, GridBagConstraints.CENTER, 10, 10, 40, 10, GridBagConstraints.NONE, 10);
        addElemento(painel, buttonTransferir, 1, 2, GridBagConstraints.CENTER, 10, 60, 20, 60, GridBagConstraints.HORIZONTAL, 10);
        addElemento(painel, buttonExtrato, 1, 3, GridBagConstraints.CENTER, 10, 60, 20, 60, GridBagConstraints.HORIZONTAL, 10);
        addElemento(painel, buttonGenChaves, 1, 4, GridBagConstraints.CENTER, 10, 60, 40, 60, GridBagConstraints.HORIZONTAL, 10);

        // adiciona menu ao JFrame
        menu.add(login);
        barra.add(menu);
        this.setJMenuBar(barra);

        // Adiciona ao painel e torna visível
        this.add(painel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        // tratamento de eventos
        buttonTransferir.addActionListener(bHandlerTransferir);
        login.addActionListener(bHandlerLogin);
        // buttonExtrato.addActionListener(bHandlerExtrato);
        buttonGenChaves.addActionListener(bHandlerGenChaves);
    }

    // Método que adiciona os elementos à interface
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

    private class BHandlerTransferir implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            new TransferenciaPix(cliente, clientes);
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

    private class BHandlerGenChaves implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            new GerenciarPix(cliente, clientes);
            dispose();
        }
    }
}