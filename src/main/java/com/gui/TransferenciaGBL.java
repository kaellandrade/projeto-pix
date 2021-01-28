package com.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



public class TransferenciaGBL extends JFrame {

    private JLabel labelSaldoCC;
    private JLabel labelValor;
    private JLabel labelNomeBanco;
    private JLabel labelAgencia;
    private JLabel labelConta;
    private JLabel labelNomeCliente;
    private JLabel labelCPF;
    private JLabel labelTipoConta;
    private JTextField textFieldValor;
    private JTextField textFieldNomeBanco;
    private JTextField textFieldAgencia;
    private JTextField textFieldConta;
    private JTextField textFieldNomeCliente;
    private JTextField textFieldCpf;

    public TransferenciaGBL() {
        super("Realizar transferência");

        JPanel p = new JPanel();
        
        p.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(2,2,2,2);

        c.gridx = 0;
        c.gridy = 0;
        c.ipadx = 15;
        c.ipady = 50;

        p.add(new JButton("Transferencia"), c);

    }
}
