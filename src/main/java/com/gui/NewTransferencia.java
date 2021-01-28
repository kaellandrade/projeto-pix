package com.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NewTransferencia {
    private JFrame frame;
    private JLabel labelStatus;
    private JPanel painelControle;
    private JLabel labelSaldo;
    private JLabel labelValor;
    private JLabel labelSelecaoTransferencia;
    private JTextField textFieldValor;
    private JComboBox comboBoxMeiosTransferencia;

    public NewTransferencia() {
        prepararGUI();
    }

    private void prepararGUI() {

        // Define o título da página e o tamanho da janela
        frame = new JFrame("Realizar transferência");
        frame.setSize(400,600);
        frame.setLayout(new GridLayout(3, 1));

        // Inicializa e define a orientação dos JLabel
        labelSaldo = new JLabel("", JLabel.CENTER);

        // 
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        // Painel
        painelControle = new JPanel();
        painelControle.setLayout(new FlowLayout());

        // Adição dos JLabel ao painel
        frame.add(labelSaldo);
        frame.add(painelControle);
        frame.setVisible(true);
    }

    public void InterfaceGraficaGBL() {

        // Definição do layout
        JPanel painel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        painel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        labelSaldo.setText("Saldo");

        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(new JLabel("Valor a ser transferido"), gbc);




        painelControle.add(painel);
        frame.setVisible(true);

    }
}
