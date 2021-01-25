package com.gui;

import javax.naming.InitialContext;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;
import javax.swing.text.AttributeSet.FontAttribute;

import java.awt.Font;

import com.bancocentral.Pix;

import java.awt.Color;
import java.awt.FlowLayout;

import java.awt.GridLayout;
import java.text.ParseException;

public class FormularioCadastroCli extends JFrame {
    private GridLayout gridLayout;
    private FlowLayout flowLayout;

    // TxtFiled
    private JTextField nome;
    private JTextField documentoId;
    private JFormattedTextField telefone;
    private JTextField email;
    private JTextField chavePix;
    // Labels
    private JLabel labelNome;
    private JLabel labelDocumentoId;
    private JLabel labelTelefone;
    private JLabel labelemail;
    private JLabel labelchavePix;

    // Font
    private Font fontLabel; // fonte para texto em negrito
    private Font fontFild; // fonte para texto em negrito

    public FormularioCadastroCli() throws ParseException {
        super("Cadastro de cliente");
        fontLabel = new Font(Font.MONOSPACED, Font.PLAIN, 20); // configura a fonte para os campos
        fontFild = new Font(Font.MONOSPACED, Font.BOLD, 15); // configura a fonte para os campos

        gridLayout = new GridLayout(6, 3, 0, 50); // LINHAS, COLUNA, ESPAÇAMENTO COLUNAS, ESPAÇAMENTO LINHAS
        flowLayout = new FlowLayout(FlowLayout.LEADING);
        setLayout(gridLayout);

        // campo para nome
        labelNome = new JLabel("Nome cliente: ");
        labelNome.setToolTipText("Digite seu nome.");
        nome = new JTextField(20);
        labelNome.setFont(fontLabel);
        nome.setFont(fontFild);
        add(labelNome);
        add(nome);

        // campo para documentoId(cpf ou RG)
        labelDocumentoId = new JLabel("Documento: ");

        documentoId = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
        labelDocumentoId.setToolTipText("Digite seu RG ou CPF.");
        labelDocumentoId.setFont(fontLabel);
        documentoId.setFont(fontFild);
        add(labelDocumentoId);
        add(documentoId);

        labelTelefone = new JLabel("Telefone: ");

        telefone = new JFormattedTextField(new MaskFormatter("+##.(##).#####-####"));
        labelTelefone.setToolTipText("Digite seu telefone.");
        labelTelefone.setFont(fontLabel);
        telefone.setFont(fontFild);
        add(labelTelefone);
        add(telefone);

        // campo para email
        labelemail = new JLabel("Email: ");

        email = new JFormattedTextField();
        labelemail.setToolTipText("Digite seu email");
        labelemail.setFont(fontLabel);
        email.setFont(fontFild);
        add(labelemail);
        add(email);

        // campo para chave aleatória PIX
        labelchavePix = new JLabel("Chave PIX: ");

        Icon key1 = new ImageIcon("../projeto-pix-gui/imgs/pixkey.png");
        Icon key2 = new ImageIcon("../projeto-pix-gui/imgs/pixkey.png");

        JButton plainJButton = new JButton("Gerar Chave Pix", key1);
        JButton gravarDados = new JButton("Salvar Cliente", key1);
        plainJButton.setRolloverIcon(key2);

        chavePix = new JFormattedTextField(new MaskFormatter("****-****-****-********"));
        chavePix.setEditable(false);
        chavePix.setText(Pix.gerarChavePix());

        labelchavePix.setToolTipText("Gere sua sua chave");

        add(labelchavePix);
        add(chavePix);
        labelchavePix.setFont(fontLabel);
        chavePix.setFont(fontFild);

        add(plainJButton);
        add(gravarDados);
    }

}