package com.gui;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.text.ParseException;

public class CadastroCliente extends JFrame {
    
    // JLabel
    private JLabel labelNome;
    private JLabel labelId;
    private JLabel labemTelefone;
    private JLabel labelChavePix;

    // JTextField
    private JTextField txtfNome;
    private JTextField txtfId;
    private JTextField txtfTelefone;
    private JTextField txtfChavePix;

    // JRadioButton
    private final JRadioButton cpfRadioButton;
    private final JRadioButton cnpjRadioButton;

    // ButtonGroup
    private final ButtonGroup radioGroup;

    public CadastroCliente() throws ParseException {
        super("Cadastro de cliente");
        setLayout(new FlowLayout());
        
        // Nome
        labelNome = new JLabel("Nome do cliente: ");
        txtfNome = new JTextField(20);
        add(labelNome);
        add(txtfNome);

        // Identificação
        labelId = new JLabel("Documento ID");
        txtfId = new JTextField(20);
        add(labelId);
        add(txtfId);

        // Configuração dos botões de seleção entre CPF e CNPJ
        cpfRadioButton = new JRadioButton("CPF", true);
        cnpjRadioButton = new JRadioButton("CNPJ", false);
        add(cpfRadioButton);
        add(cnpjRadioButton);
        radioGroup = new ButtonGroup();
        radioGroup.add(cpfRadioButton);
        radioGroup.add(cnpjRadioButton);




    }

}
