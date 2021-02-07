package com.gui;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TransferenciaPix extends JFrame {

    // declarando os JTextField
    JTextField textFieldValor = new JTextField("Valor", 8);

    // Declarando o JComboBox com os meios de transferências
    String meiosTransferencia[] = {"CPF", "E-mail", "Telefone", "Chave Pix"};
    JComboBox comboBoxTransferencia = new JComboBox(meiosTransferencia);

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

    public TransferenciaPix() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());

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
        addElemento(painel, comboBoxTransferencia, 0, 4, 1, 1, GridBagConstraints.CENTER, 1, 10, 10, 10);

        // botão de transferência
        addElemento(painel, buttonTransferir, 0, 5, 1, 1, GridBagConstraints.CENTER, 70, 10, 10, 10);

        // adiciona menu ao JFrame
        menu.add(login);
        barra.add(menu);
        this.setJMenuBar(barra);

        this.add(painel);
        this.pack();
        this.setVisible(true);

        // Tratamento de eventos
        login.addActionListener(bHandlerLogin);
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