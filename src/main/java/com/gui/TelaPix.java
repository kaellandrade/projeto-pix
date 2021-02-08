package com.gui;

import com.banco.Conta;
import com.pessoa.Cliente;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class TelaPix extends JFrame {
    private com.pessoa.Cliente cliente;
    private final Icon iconKey = new ImageIcon("../projeto-pix/imgs/key.png");

    // declarando os elementos
    JLabel labelHeader = new JLabel("Pix"), labelChave = new JLabel("Crie uma chave");
    JButton buttonTransferir = new JButton("Realizar transferência"), buttonExtrato = new JButton("Extrato"),
            buttonGenChaves = new JButton("Gerenciar chaves");

    private BHandlerTransferir bHandlerTransferir;
    // private BHandlerExtrato bHandlerExtrato;
    // private BHandlerGenChaves bHandlerGenChaves;

    private Conta conta;

    public TelaPix(Cliente cliente) {
        this.cliente = cliente;
        String minhaChave = cliente.getConta().getChavePIX();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());

        bHandlerTransferir = new BHandlerTransferir();
        labelChave.setIcon(iconKey);
        if (minhaChave != null) { // caso tenha uma chave
            labelChave.setText(minhaChave);
        }
        
        // bHandlerExtrato = new BHandlerExtrato();
        // bHandlerGenChaves = BHandlerGenChaves();

        // Adição dos elementos
        addElemento(painel, labelHeader, 1, 0, GridBagConstraints.CENTER, 10, 150, 40, 150, GridBagConstraints.NONE);
        addElemento(painel, labelChave, 1, 1, GridBagConstraints.CENTER, 10, 10, 40, 10, GridBagConstraints.NONE);
        addElemento(painel, buttonTransferir, 1, 2, GridBagConstraints.CENTER, 10, 60, 20, 60,
                GridBagConstraints.HORIZONTAL);
        addElemento(painel, buttonExtrato, 1, 3, GridBagConstraints.CENTER, 10, 60, 20, 60,
                GridBagConstraints.HORIZONTAL);
        addElemento(painel, buttonGenChaves, 1, 4, GridBagConstraints.CENTER, 10, 60, 40, 60,
                GridBagConstraints.HORIZONTAL);

        // Adiciona ao painel e torna visível
        this.add(painel);
        this.pack();
        this.setVisible(true);

        // tratamento de eventos
        buttonTransferir.addActionListener(bHandlerTransferir);
        // buttonExtrato.addActionListener(bHandlerExtrato);
        // buttonGenChaves.addActionListener(bHandlerGenChaves);
    }

    // Método que adiciona os elementos à interface
    private void addElemento(JPanel p, JComponent c, int coluna, int linha, int alinhamento, int superior, int esquerda,
            int inferior, int direita, int preenchimento) {

        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = coluna;
        gc.gridy = linha;
        gc.gridwidth = 1;
        gc.gridheight = 1;
        gc.insets = new Insets(superior, esquerda, inferior, direita);
        gc.anchor = alinhamento;
        gc.fill = preenchimento;
        p.add(c, gc);
    }

    private class BHandlerTransferir implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            new TransferenciaPix(cliente);
            dispose();
        }
    }
}