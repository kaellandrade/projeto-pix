package com.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Container;

public class TelaInicial extends JFrame {
    private Container c;
    private JButton buttonTransferencia;
    private JButton buttonExtrato;
    private JLabel labelSaldo;

    public TelaInicial() {
        super("Tela inicial");

        setBounds(100, 100, 100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        // Saldo
        labelSaldo = new JLabel("Saldo");
        labelSaldo.setSize(300,30);
        labelSaldo.setLocation(200,140);
        c.add(labelSaldo);

        // Botão de transferência
        buttonExtrato = new JButton("<html><center>Ver <br /> extrato</center></html>");
        buttonExtrato.setSize(130,50);
        buttonExtrato.setLocation(70,180);
        c.add(buttonExtrato);

        // Botão de extrato
        buttonTransferencia = new JButton("<html><center>Fazer <br /> transferência</center></html>");
        buttonTransferencia.setSize(130,50);
        buttonTransferencia.setLocation(220,180);
        c.add(buttonTransferencia);
    }
}