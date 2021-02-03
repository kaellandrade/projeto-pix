package com.gui;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
//import java.awt.Dimension;

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
        
    // declarando JButton
    JButton buttonEntrar = new JButton("Entrar"), buttonAcessoEspecial = new JButton("Acesso especial");

    public NewAbertura() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setPreferredSize(new Dimension(300,500));
        JPanel painel1 = new JPanel();
        painel1.setLayout(new GridBagLayout());

        // adição do texto "Selecione a ID"
        addElemento(painel1, new JLabel("Selecione a ID"), 0, 0, 1, 1, GridBagConstraints.CENTER, 10, 100, 10, 100);
        
        // ------ adição dos RadioButtons para CPF e CNPJ ------
        // adição do CPF
        JRadioButton radioButtonCPF = new JRadioButton("CPF");
        radioButtonCPF.setActionCommand("CPF");
        radioButtonCPF.setSelected(true);
        addElemento(painel1, radioButtonCPF, 0, 1, 1, 1, GridBagConstraints.WEST, 10, 70, 10, 10);

        // adição do CNPJ
        JRadioButton radioButtonCNPJ = new JRadioButton("CNPJ");
        radioButtonCNPJ.setActionCommand("CNPJ");
        radioButtonCNPJ.setSelected(false);
        addElemento(painel1, radioButtonCNPJ, 0, 1, 1, 1, GridBagConstraints.EAST, 10, 10, 10, 70);

        // agrupamento dos RadioButtons
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(radioButtonCNPJ);
        grupo.add(radioButtonCPF);

        // ADICIONAR O TEXTFIELD DO CNPJ DEPOIS
        // TextField do CPNJ
        addElemento(painel1, textFieldCPF, 0, 2, 1, 1, GridBagConstraints.CENTER, 0, 10, 10, 10);

        this.add(painel1);
        this.pack();
        this.setVisible(true);
    }

    private void addElemento(JPanel p, JComponent c, int linha, int coluna, int largura, 
        int altura, int alinhamento, int superior, int esquerda, int inferior, int direita) {
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = linha;
        gc.gridy = coluna;
        gc.gridwidth = largura;
        gc.gridheight = altura;
        gc.weightx = 100.0;
        gc.weighty = 100.0;
        gc.insets = new Insets(superior, esquerda, inferior, direita);
        gc.anchor = alinhamento;
        gc.fill = GridBagConstraints.NONE;
        p.add(c, gc);
    }
}
