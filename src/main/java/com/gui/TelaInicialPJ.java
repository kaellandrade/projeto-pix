package com.gui;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaInicialPJ extends JFrame {

    // declarando os JLabel
    JLabel labelHeader = new JLabel("Menu Pessoa Jurídica"), labelSaldo = new JLabel("Saldo");

    // declarando os JButtons
    JButton buttonTI = new JButton("Realizar transferência"),
        buttonExtrato = new JButton("Consultar o extrato da conta"),
        buttonPix = new JButton("Realizar transferência via Pix"),
        buttonPagamento = new JButton("Realizar pagamento");

    private BHandlerTransferencia bHandlerTransferencia;
    private BHandlerPix bHandlerPix;
    //private BHandlerPagamento bHandlerPagamento;
    //private BHandlerExtrato bHandlerExtrato;

    public TelaInicialPJ() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());

        bHandlerTransferencia = new BHandlerTransferencia();
        bHandlerPix = new BHandlerPix();
        //bHandlerPagamento = new BHandlerPagamento();
        //bHandlerExtrato = new BHandlerExtrato();

        labelSaldo.setFont(labelSaldo.getFont().deriveFont(20.0f));

        // título da tela
        addElemento(painel, labelHeader, 1, 0, 1, 1, GridBagConstraints.CENTER, 10, 100, 10, 100, 50);

        // campo de exibição do saldo
        addElemento(painel, labelSaldo, 1, 1, 1, 1, GridBagConstraints.CENTER, 10, 10, 10, 10, 50);

        // botões de operações
        addElemento(painel, buttonTI, 1, 2, 1, 1, GridBagConstraints.CENTER, 30, 10, 10, 10, 10);
        addElemento(painel, buttonPix, 1, 3, 1, 1, GridBagConstraints.CENTER, 10, 10, 10, 10, 10);
        addElemento(painel, buttonPagamento, 1, 4, 1, 1, GridBagConstraints.CENTER, 10, 10, 10, 10, 10);
        addElemento(painel, buttonExtrato, 1, 5, 1, 1, GridBagConstraints.CENTER, 10, 10, 70, 10, 10);

        this.add(painel);
        this.pack();
        this.setVisible(true);

        // Tratamento de eventos
        buttonTI.addActionListener(bHandlerTransferencia);
        buttonPix.addActionListener(bHandlerPix);
        //buttonPagamento.addActionListener(bHandlerPagamento);
        //buttonExtrato.addActionListener(bHandlerExtrato);
    }

    // Método que adiciona os elementos
    private void addElemento(JPanel p, JComponent c, int linha, int coluna, int largura, 
        int altura, int alinhamento, int superior, int esquerda, int inferior, int direita, int ipady) {
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = linha;
        gc.gridy = coluna;
        gc.gridwidth = largura;
        gc.gridheight = altura;
        gc.ipady = ipady;
        //gc.ipadx = 0;
        //gc.weightx = 0;
        //gc.weighty = 0;
        gc.insets = new Insets(superior, esquerda, inferior, direita);
        gc.anchor = alinhamento;
        gc.fill = GridBagConstraints.NONE;
        p.add(c, gc);
    }

    // Tratamento de eventos do botão de transferência
    private class BHandlerTransferencia implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            TransferenciaInterna transferencia = new TransferenciaInterna();
            dispose();
        }
    }

    // Tratamento de eventos do botão do Pix
    private class BHandlerPix implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            TransferenciaPix pix = new TransferenciaPix();
            dispose();
        }
    }

    // TODO: Tela de pagamento
    // Tratamento de eventos do botão de pagamento
    /* 
    private class BHandlerPagamento implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            Pagamento pagamento = new Pagamento();
            dispose();
        }
    }
    */

    // TODO: Tela de extrato
    // Tratamento de eventos do botão de pagamento
    /*
    private class BHandlerExtrato implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            Extrato extrato = new Extrato();
            dispose();
        }
    }
    */
}