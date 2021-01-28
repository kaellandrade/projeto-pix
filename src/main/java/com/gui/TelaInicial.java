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
    private JButton buttonPix;

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

        // Botão de extrato
        buttonExtrato = new JButton("<html><center>Ver <br /> extrato</center></html>");
        buttonExtrato.setSize(130,50);
        buttonExtrato.setLocation(70,180);
        c.add(buttonExtrato);

        // Botão de transferência
        buttonTransferencia = new JButton("<html><center>Fazer <br /> TEF</center></html>");
        buttonTransferencia.setSize(130,50);
        buttonTransferencia.setLocation(220,180);
        c.add(buttonTransferencia);

        // Botão do PIX
        buttonPix = new JButton("PIX");
        buttonPix.setSize(130,50);
        buttonPix.setLocation(140,245);
        c.add(buttonPix);
    }
}