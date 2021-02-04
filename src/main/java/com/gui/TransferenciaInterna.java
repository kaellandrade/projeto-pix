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
    }
}