package com.gui;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.event.*;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicMenuUI.ChangeHandler;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public class TransferenciaPix extends JFrame {
    
    // Configuração do JComboBox
    private final JComboBox<String> jCBoxChaves;
    private static final String[] tiposChaves = {"Selecione uma chave", "CPF", "CNPJ", "E-mail", "Telefone", "Chave Pix"};

    // declarando os JTextField
    JFormattedTextField textFieldValor = new JFormattedTextField(), textFieldChave = new JFormattedTextField();

    // Declarando o JButton
    JButton buttonTransferir = new JButton("Transferir");

    // Declarando os JLabels
    JLabel labelHeader = new JLabel("<html><center>Realizar transferência <br />via Pix</center></html>"),
        labelSaldo = new JLabel("<html><center>Saldo da<br />conta corrente</center></html>"),
        labelTransferencia = new JLabel("<html><center>Selecione o meio<br />de transferência</center></html>");

    // Declarando o JMenu, JMenuBar e JMenuItem;
    private JMenuBar barra;
    private JMenu menu;
    private JMenuItem login;

    // Variáveis para tratamento de eventos do menu
    private BHandlerLogin bHandlerLogin;
    private JComboBoxHandler jComboBoxHandler;

    public TransferenciaPix() {

        jCBoxChaves = new JComboBox<String>(tiposChaves);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());

        // Definindo o tamanho dos JFormattedTextField
        textFieldValor.setColumns(8);
        textFieldChave.setColumns(14);

        // Define o menu e seus componentes
        barra = new JMenuBar();
        menu = new JMenu("Opções");
        login = new JMenuItem("Tela de login");

        bHandlerLogin = new BHandlerLogin();

        // título da tela
        addElemento(painel, labelHeader, 0, 0, 1, 1, GridBagConstraints.CENTER, 10, 100, 70, 100);

        // campo de exibição do saldo (provisório)
        addElemento(painel, labelSaldo, 0, 1, 1, 1, GridBagConstraints.CENTER, 10, 10, 10, 10);

        // campo de texto para entrada do saldo
        addElemento(painel, textFieldValor, 0, 2, 1, 1, GridBagConstraints.CENTER, 10, 10, 10, 10);

        // título da seleção do meio de transferência
        addElemento(painel, labelTransferencia, 0, 3, 1, 1, GridBagConstraints.CENTER, 30, 10, 10, 10);

        // lista de bancos
        addElemento(painel, jCBoxChaves, 0, 4, 1, 1, GridBagConstraints.CENTER, 1, 10, 10, 10);

        addElemento(painel, textFieldChave, 0, 5, 1, 1, GridBagConstraints.CENTER, 10, 10, 10, 10);

        // botão de transferência
        addElemento(painel, buttonTransferir, 0, 6, 1, 1, GridBagConstraints.CENTER, 70, 10, 10, 10);

        // adiciona menu ao JFrame
        menu.add(login);
        barra.add(menu);
        this.setJMenuBar(barra);

        this.add(painel);
        this.pack();
        this.setVisible(true);

        jComboBoxHandler = new JComboBoxHandler();

        // Tratamento de eventos
        login.addActionListener(bHandlerLogin);
        jCBoxChaves.addActionListener(jComboBoxHandler);

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

    private class JComboBoxHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {

            textFieldChave.setValue("");

            if (jCBoxChaves.getSelectedIndex() == 1) {
                try {
                    MaskFormatter mascaraCPF = new MaskFormatter("###.###.###-##");
                    mascaraCPF.install(textFieldChave);
                } catch (Exception e) {
                    System.out.print(e);
                }
            }

            if (jCBoxChaves.getSelectedIndex() == 2) {
                try {
                    MaskFormatter mascaraCNPJ = new MaskFormatter("##.###.###/0001-##");
                    mascaraCNPJ.install(textFieldChave);
                } catch (Exception e) {
                    System.out.print(e);
                }
            }

            if (jCBoxChaves.getSelectedIndex() == 4) {
                try {
                    MaskFormatter mascaraTelefone = new MaskFormatter("(##) # ####-####");
                    mascaraTelefone.install(textFieldChave);
                } catch (Exception e) {
                    System.out.print(e);
                }
            }
        }
    }
}