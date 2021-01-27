package com.gui;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.Container;
import java.text.ParseException;

public class Abertura extends JFrame {
    private Container c;
    private JLabel labelTituloId;
    private JTextField textFieldId;
    private JRadioButton cpfRadioButton;
    private JRadioButton cnpjRadioButton;
    private JButton buttonEntrar;
    private JButton buttonAcessoEspecial;

    public Abertura() throws ParseException {
        super("Tela inicial");

        setBounds(100, 100, 100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        // Titulo
        labelTituloId = new JLabel("Selecione o tipo de identificação");
        labelTituloId.setSize(300,30);
        labelTituloId.setLocation(100,140);
        c.add(labelTituloId);

        // Botões de celeção entre CPF e CNPJ
        cpfRadioButton = new JRadioButton("CPF", true);
        cpfRadioButton.setLocation(100,180);
        cpfRadioButton.setSize(100,20);
        c.add(cpfRadioButton);
        
        cnpjRadioButton = new JRadioButton("CNPJ", false);
        cnpjRadioButton.setLocation(260,180);
        cnpjRadioButton.setSize(100,20);
        c.add(cnpjRadioButton);

        // Campo de texto para o CPF ou CNPJ
        textFieldId = new JTextField("Digite o documento ID");
        textFieldId.setSize(200,30);
        textFieldId.setLocation(115,210);
        c.add(textFieldId);

        // Botão de entrar
        buttonEntrar = new JButton("Entrar");
        buttonEntrar.setSize(100,50);
        buttonEntrar.setLocation(165, 255);
        c.add(buttonEntrar);

        // Botão de acesso especial
        buttonAcessoEspecial = new JButton("Acesso especial");
        buttonAcessoEspecial.setSize(200,50);
        buttonAcessoEspecial.setLocation(120, 400);
        c.add(buttonAcessoEspecial);
    }
}