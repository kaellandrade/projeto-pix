package com.gui;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.event.*;
import java.util.Collection;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

import com.pessoa.*;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.backend.LerClientesSerializados;
import com.bancocentral.Pix;

public class GerenciarPix extends JFrame {
    
    private Cliente cliente;
    private Collection<Cliente> clientes;

    JLabel labelHeader = new JLabel("Gerenciador do Pix"), labelHeader2 = new JLabel("Selecione o tipo de chave"),
        labelHeader3 = new JLabel("Criar chave aleatória");

    JTextArea textAreatodasChaves = new JTextArea(1, 20), textAreaChaveAleatoria = new JTextArea(5, 20);

    JButton buttonGerarChave = new JButton("Gerar chave");

    private final JComboBox<String> jComboBoxChaves;
    private static final String[] tiposChaves = {"Selecione uma chave", "CPF", "CNPJ", "E-mail", "Telefone",
    "Chave Pix" };

    // Declarando o JMenu, JMenuBar e JMenuItem;
    private JMenuBar barra;
    private JMenu menu;
    private JMenuItem login;

    // Variáveis para tratamento de eventos do menu
    private BHandlerLogin bHandlerLogin;

    private JComboBoxHandler jComboBoxHandler;
    private JButtonGerarChave jButtonGerarChave;

    private String chaveCPF, chaveCNPJ, chaveEmail, chaveTelefone, chaveAleatoria;

    public GerenciarPix(Cliente cli, Collection cli2) {

        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textAreatodasChaves.setEditable(false);
        textAreaChaveAleatoria.setEditable(false);

        jComboBoxChaves = new JComboBox<String>(tiposChaves);
        jButtonGerarChave = new JButtonGerarChave();

        // Define o menu e seus componentes
        barra = new JMenuBar();
        menu = new JMenu("Opções");
        login = new JMenuItem("Tela de login");
        bHandlerLogin = new BHandlerLogin();

        this.cliente = cli;
        this.clientes = cli2;
        
        // Pega as informações de pessoa física
        if (cli instanceof ClientePessoaFisica) {

            ClientePessoaFisica clientePessoaFisica;
            clientePessoaFisica = (ClientePessoaFisica)cli;

            chaveCPF = clientePessoaFisica.getCpf();
            chaveEmail = clientePessoaFisica.getEmail();
            chaveTelefone = clientePessoaFisica.getTelefone();
        }

        // Pega as informações de pessoa jurídica
        if (cli instanceof ClientePessoaJuridica) {

            ClientePessoaJuridica clientePessoaJuridica;
            clientePessoaJuridica = (ClientePessoaJuridica)cli;

            chaveCNPJ = clientePessoaJuridica.getCnpj();
            chaveEmail = clientePessoaJuridica.getEmail();
            chaveTelefone = clientePessoaJuridica.getTelefone();
        }

        addElemento(painel, labelHeader, 1, 0, GridBagConstraints.CENTER, 10, 100, 40, 100);
        addElemento(painel, labelHeader2, 1, 1, GridBagConstraints.CENTER, 10, 30, 5, 30);
        addElemento(painel, jComboBoxChaves, 1, 2, GridBagConstraints.CENTER, 5, 10, 10, 10);
        addElemento(painel, textAreatodasChaves, 1, 3, GridBagConstraints.CENTER, 5, 10, 10, 10);
        addElemento(painel, labelHeader3, 1, 4, GridBagConstraints.CENTER, 10, 10, 10, 10);
        addElemento(painel, textAreaChaveAleatoria, 1, 5, GridBagConstraints.CENTER, 10, 10, 10, 10);
        addElemento(painel, buttonGerarChave, 1, 6, GridBagConstraints.CENTER, 10, 10, 10, 10);
        // adiciona menu ao JFrame
        menu.add(login);
        barra.add(menu);
        this.setJMenuBar(barra);

        // Tratamento de eventos
        login.addActionListener(bHandlerLogin);
        
        buttonGerarChave.addActionListener(jButtonGerarChave);

        jComboBoxHandler = new JComboBoxHandler();
        jComboBoxChaves.addActionListener(jComboBoxHandler);

        this.add(painel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    private void addElemento(JPanel p, JComponent c, int coluna, int linha, int alinhamento,
        int superior, int esquerda, int inferior, int direita) {
            GridBagConstraints gc = new GridBagConstraints();
            gc.gridx = coluna;
            gc.gridy = linha;
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

    private class JComboBoxHandler implements ActionListener {

        @Override
        public  void actionPerformed(ActionEvent evento) {

            if (jComboBoxChaves.getSelectedIndex() == 1) {
                textAreatodasChaves.setText(chaveCPF);
            }
        }
    }

    private class JButtonGerarChave implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            cliente.getConta().setChavePIX(Pix.gerarChavePix());
            chaveAleatoria = cliente.getConta().getChavePIX();
            
            textAreaChaveAleatoria.setText(chaveAleatoria);

            LerClientesSerializados.atualizar(clientes); // atualiza o arquivo .pix

        }
    }
}
