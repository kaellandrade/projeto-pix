package com.gui;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;

public class Abertura extends JFrame {

    // declarando os elementos
    JTextField textFieldCPF = new JTextField(11), textFieldCNPJ = new JTextField(14);
    JButton buttonEntrar = new JButton("Entrar"), buttonAcessoEspecial = new JButton("Acesso especial");
    
    private JRadioButton radioButtonCNPJ, radioButtonCPF;
    private RadioButtonHandler handler;

    public Abertura() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setPreferredSize(new Dimension(300,500));
        JPanel painel1 = new JPanel();
        painel1.setLayout(new GridBagLayout());
        handler = new RadioButtonHandler();

        // adição dos elementos à interface 
        addElemento(painel1, new JLabel("Selecione a ID"), 0, 0, 1, 1, GridBagConstraints.CENTER, 70, 100, 10, 100);

        radioButtonCPF = new JRadioButton("CPF", false);
        //radioButtonCPF.setSelected(true);
        addElemento(painel1, radioButtonCPF, 0, 1, 1, 1, GridBagConstraints.WEST, 10, 70, 10, 10);

        radioButtonCNPJ = new JRadioButton("CNPJ", false);
        //radioButtonCNPJ.setSelected(false);
        addElemento(painel1, radioButtonCNPJ, 0, 1, 1, 1, GridBagConstraints.EAST, 10, 10, 10, 70);

        //addElemento(painel1, textFieldCPF, 0, 2, 1, 1, GridBagConstraints.CENTER, 0, 10, 10, 10);

        addElemento(painel1, buttonEntrar, 0, 3, 1, 2, GridBagConstraints.CENTER, 10, 10, 150, 10);

        addElemento(painel1, buttonAcessoEspecial, 0, 4, 1, 1, GridBagConstraints.SOUTH, 100, 10, 20, 10);

        // agrupamento dos RadioButtons
        //ButtonGroup grupo = new ButtonGroup();
        //grupo.add(radioButtonCNPJ);
        //grupo.add(radioButtonCPF);

        this.add(painel1);
        this.pack();
        this.setVisible(true);

        // Tratamento de eventos
        radioButtonCNPJ.addItemListener(handler);
        radioButtonCPF.addItemListener(handler);

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

    public class RadioButtonHandler implements ItemListener {
        String cpf, cnpj;
        
        @Override
        public void itemStateChanged(ItemEvent evento) {

            if (radioButtonCPF.isSelected())
                cpf = JOptionPane.showInputDialog("Informe seu CPF");

            if (radioButtonCNPJ.isSelected())
                cnpj = JOptionPane.showInputDialog("Informe seu CPF");

            System.out.println(cpf);
        }
    }
}