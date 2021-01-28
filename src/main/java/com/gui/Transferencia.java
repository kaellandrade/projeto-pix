package com.gui;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Container;

public class Transferencia extends JFrame {
    private Container c;
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

    public Transferencia() {
        super("Realizar transferencia");

        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        // Saldo
        labelSaldoCC = new JLabel("Saldo");
        labelSaldoCC.setSize(100,30);
        labelSaldoCC.setLocation(205,20);
        c.add(labelSaldoCC);

        // Valor a ser transferido
        labelValor = new JLabel("Valor");
        labelValor.setSize(100,30);
        labelValor.setLocation(205,60);
        c.add(labelValor);

        textFieldValor = new JTextField("Digite o valor");
        textFieldValor.setSize(100,30);
        textFieldValor.setLocation(170,90);
        c.add(textFieldValor);

        // Nome do banco
        labelNomeBanco = new JLabel("Nome do banco");
        labelNomeBanco.setSize(300,30);
        labelNomeBanco.setLocation(165,130);
        c.add(labelNomeBanco);

        textFieldNomeBanco = new JTextField("Digite o nome do banco");
        textFieldNomeBanco.setSize(250,30);
        textFieldNomeBanco.setLocation(95,160);
        c.add(textFieldNomeBanco);
        
        // Agência
        labelAgencia = new JLabel("Agência");
        labelAgencia.setSize(100,30);
        labelAgencia.setLocation(125,200);
        c.add(labelAgencia);

        textFieldAgencia = new JTextField("Digite o numero da agência");
        textFieldAgencia.setSize(110,30);
        textFieldAgencia.setLocation(95,230);
        c.add(textFieldAgencia);

        // Conta
        labelConta = new JLabel("Conta");
        labelConta.setSize(100,30);
        labelConta.setLocation(275,200);
        c.add(labelConta);

        textFieldConta = new JTextField("Digite o numero da conta");
        textFieldConta.setSize(110,30);
        textFieldConta.setLocation(240,230);
        c.add(textFieldConta);

        // Nome da pessoa
        labelNomeCliente = new JLabel("Nome");
        labelNomeCliente.setSize(250,30);
        labelNomeCliente.setLocation(295,160);
        c.add(labelNomeCliente);
    }
}
