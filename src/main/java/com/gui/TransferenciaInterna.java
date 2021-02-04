package com.gui;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JComboBox;

public class TransferenciaInterna extends JFrame {

    // declarando os JTextField
    JTextField textFieldValor = new JTextField("Valor", 8), textFieldAgencia = new JTextField("Agência", 8), 
        textFieldConta = new JTextField("Conta", 8);

    // Declarando o JComboBox com a lista de bancos
    String bancos[] = {"Banco do Brasil", "Bradesco", "Itaú", "Santander"};
    JComboBox jComboBoxBanco = new JComboBox(bancos);

    String tipoConta[] = {"Conta corrente", "Conta poupança"};
    JComboBox jComboBoxConta = new JComboBox(tipoConta);

    // Declarando o JButton
    JButton buttonTransferir = new JButton("Transferir");

    // Declarando os JLabels
    JLabel labelHeader = new JLabel("<html><center>Realizar transferência <br /> interna</center></html>"),
        labelSaldo = new JLabel("<html><center>Saldo da <br /> conta corrente</center></html>"),
        labelBanco = new JLabel("Selecione o banco"), labelConta = new JLabel("Selecione a conta");

    public TransferenciaInterna() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());

        // título da tela
        addElemento(painel, labelHeader, 0, 0, 1, 1, GridBagConstraints.CENTER, 10, 100, 70, 100);

        // campo de exibição do saldo (provisório)
        addElemento(painel, labelSaldo, 0, 1, 1, 1, GridBagConstraints.CENTER, 10, 10, 10, 10);

        // campo de texto para entrada do saldo
        addElemento(painel, textFieldValor, 0, 2, 1, 1, GridBagConstraints.CENTER, 10, 10, 12, 10);

        // título da seleção de banco
        addElemento(painel, labelBanco, 0, 3, 1, 1, GridBagConstraints.CENTER, 12, 10, 3, 10);

        // lista de bancos
        addElemento(painel, jComboBoxBanco, 0, 4, 1, 1, GridBagConstraints.CENTER, 3, 10, 10, 10);

        // campo de entrada da agência
        addElemento(painel, textFieldAgencia, 0, 5, 1, 1, GridBagConstraints.WEST, 12, 70, 10, 10);

        // campo de entrada da conta
        addElemento(painel, textFieldConta, 0, 5, 1, 1, GridBagConstraints.EAST, 12, 10, 12, 70);

        // título da seleção de conta
        addElemento(painel, labelConta, 0, 6, 1, 1, GridBagConstraints.CENTER, 12, 10, 3, 10);

        // campo de seleção do tipo de conta
        addElemento(painel, jComboBoxConta, 0, 7, 1, 1, GridBagConstraints.CENTER, 3, 10, 10, 10);

        // botão de transfeir
        addElemento(painel, buttonTransferir, 0, 8, 1, 1, GridBagConstraints.CENTER, 70, 10, 10, 10);

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