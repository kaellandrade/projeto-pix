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
    JTextField textFieldValor = new JTextField(7), textFieldAgencia = new JTextField(4), 
        textFieldConta = new JTextField(8);

    // Declarando o JComboBox com a lista de bancos
    String bancos[] = {"Banco do Brasil", "Bradesco", "Itaú", "Santander"};
    JComboBox jComboBoxBanco = new JComboBox(bancos);
    
    String tipoConta[] = {"Conta corrente", "Conta poupança"};
    JComboBox jComboBoxConta = new JComboBox(tipoConta);

    // Declarando o JButton
    JButton buttonTransferir = new JButton("Transferir");

    // Declarando os JLabels
    JLabel labelHeader = new JLabel("<html><center>Realizar transferência <br /> interna</center></html>"),
        labelSaldo = new JLabel("<html><center>Saldo da <br /> conta corrente</center></html>");

    public TransferenciaInterna() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());

        // adição do título da tela
        addElemento(painel, labelHeader, 0, 0, 1, 1, GridBagConstraints.CENTER, 10, 10, 10, 10);

        // adição do campo de exibição do saldo (provisório)
        addElemento(painel, labelSaldo, 0, 1, 1, 1, GridBagConstraints.CENTER, 10, 10, 10, 10);

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