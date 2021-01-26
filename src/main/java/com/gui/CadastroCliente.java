package com.gui;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
//import java.awt.FlowLayout;
import java.text.ParseException;
import java.awt.Container;

public class CadastroCliente extends JFrame {
    
    private Container x;
    private JLabel labelNome;
    private JLabel labelId;
    private JLabel labelTipoId;
    private JLabel labemTelefone;
    private JLabel labelChavePix;
    private JTextField txtfNome;
    private JTextField txtfId;
    private JTextField txtfTipoId;
    private JTextField txtfTelefone;
    private JTextField txtfChavePix;
    private final JRadioButton cpfRadioButton;
    private final JRadioButton cnpjRadioButton;

    // ButtonGroup
    //private final ButtonGroup radioGroup;

    public CadastroCliente() throws ParseException {
        super("Cadastro de cliente");

        setBounds(100, 100, 100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        x = getContentPane();
        x.setLayout(null);

        // Nome
        labelNome = new JLabel("Nome do cliente: ");
        labelNome.setSize(300,30);
        labelNome.setLocation(10,30);
        txtfNome = new JTextField(20);
        txtfNome.setSize(225,30);
        txtfNome.setLocation(140,30);
        x.add(labelNome);
        x.add(txtfNome);

        // Identificação
        labelTipoId = new JLabel("Tipo de ID:");
        labelId.setSize(300, 30);

        labelId = new JLabel("Documento ID:");
        labelId.setSize(300,30);
        labelId.setLocation(10,75);
        txtfId = new JTextField(20);
        txtfId.setSize(225,30);
        txtfId.setLocation(140,75);
        x.add(labelId);
        x.add(txtfId);

        // Configuração dos botões de seleção entre CPF e CNPJ
        cpfRadioButton = new JRadioButton("CPF", true);
        cpfRadioButton.setLocation(10,125);
        cpfRadioButton.setSize(100,100);


        cnpjRadioButton = new JRadioButton("CNPJ", false);
        cnpjRadioButton.setLocation(10,200);
        cnpjRadioButton.setSize(100,100);

        x.add(cpfRadioButton);
        x.add(cnpjRadioButton);
    }
}