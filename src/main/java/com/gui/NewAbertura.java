package com.gui;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;

public class NewAbertura extends JFrame {

    // declarando JTextField
    JTextField textFieldCPF = new JTextField(11), textFieldCNPJ = new JTextField(14);
    
    // declarando JRadioButton
    JRadioButton radioButtonCPF = new JRadioButton("CPF"), radioButtonCNPJ = new JRadioButton("CNPJ");
    
    // declarando JButton
    JButton buttonEntrar = new JButton("Entrar"), buttonAcessoEspecial = new JButton("Acesso especial");

    public NewAbertura() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setPreferredSize(new Dimension(300,500));
        JPanel painel1 = new JPanel();
        painel1.setLayout(new GridBagLayout());

        addElemento(painel1, new JLabel("Selecione a ID"), 0, 0, 1, 1, GridBagConstraints.CENTER);
        addElemento(painel1, textFieldCPF, 0, 1, 1, 1, GridBagConstraints.CENTER);

        this.add(painel1);
        this.pack();
        this.setVisible(true);
    }

    private void addElemento(JPanel p, JComponent c, int x, int y, int largura, int altura, int alinhamento) {
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = x;
        gc.gridy = y;
        gc.gridwidth = largura;
        gc.gridheight = altura;
        gc.weightx = 100.0;
        gc.weighty = 100.0;
        gc.insets = new Insets(5, 5, 5, 5);
        gc.anchor = alinhamento;
        gc.fill = GridBagConstraints.NONE;
        p.add(c, gc);
    }
}
