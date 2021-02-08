package com.gui;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.banco.Banco;

import com.bancocentral.Cliente;

public class TelaInicialPF extends JFrame {
    private com.pessoa.Cliente cliente;
    private final Locale local = new Locale("pt", "BR");

    // declarando os JLabel
    JLabel labelHeader = new JLabel("Menu Pessoa Física"), labelSaldo = new JLabel("Saldo");
    // declarando os JButtons
    JButton buttonTI = new JButton("Realizar transferência"),
            buttonExtrato = new JButton("Consultar o extrato da conta"), buttonPix = new JButton("Acessar o Pix");

    private BHandlerTransferencia bHandlerTransferencia;
    private BHandlerPix bHandlerPix;
    // private BHandlerExtrato bHandlerExtrato;

    public TelaInicialPF(com.pessoa.Cliente cli) {
        this.cliente = cli; // cliente logado
        Float saldoExibicao = cli.getConta().getSaldo();
        String nomeExibicao = cli.getNome();
        Banco banco = cli.getConta().getAgencia().getBanco();
        ImageIcon icon = new ImageIcon("../projeto-pix/imgs/" + banco.getCodigoBanco() + ".png");

        this.setTitle("Bem-Vindo ao " + banco.getNomeBanco());
        this.setIconImage(icon.getImage());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        bHandlerTransferencia = new BHandlerTransferencia();
        bHandlerPix = new BHandlerPix();
        //bHandlerExtrato = new BHandlerExtrato();

        labelSaldo.setFont(labelSaldo.getFont().deriveFont(20.0f));
        labelHeader.setText(nomeExibicao);

        
        labelSaldo.setText(NumberFormat.getCurrencyInstance(local).format(saldoExibicao));




        // título da tela
        addElemento(painel, labelHeader, 1, 0, 1, 1, GridBagConstraints.CENTER, 10, 100, 10, 100, 50);

        // campo de exibição do saldo
        addElemento(painel, labelSaldo, 1, 1, 1, 1, GridBagConstraints.CENTER, 10, 100, 10, 100, 50);

        // botões de operações
        addElemento(painel, buttonTI, 1, 2, 1, 1, GridBagConstraints.CENTER, 30, 10, 10, 10, 10);
        addElemento(painel, buttonPix, 1, 3, 1, 1, GridBagConstraints.CENTER, 10, 10, 10, 10, 10);
        addElemento(painel, buttonExtrato, 1, 4, 1, 1, GridBagConstraints.CENTER, 10, 10, 20, 10, 10);

        this.add(painel);
        this.pack();
        this.setVisible(true);

        // Tratamento de eventos
        buttonTI.addActionListener(bHandlerTransferencia);
        buttonPix.addActionListener(bHandlerPix);
        //buttonExtrato.addActionListener(bHandlerExtrato);
    }

    // Método que adiciona os elementos
    private void addElemento(JPanel p, JComponent c, int linha, int coluna, int largura, int altura, int alinhamento,
            int superior, int esquerda, int inferior, int direita, int ipady) {
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = linha;
        gc.gridy = coluna;
        gc.gridwidth = largura;
        gc.gridheight = altura;
        gc.ipady = ipady;
        // gc.ipadx = 0;
        // gc.weightx = 0;
        // gc.weighty = 0;
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
            TelaPix pix = new TelaPix();
            dispose();
        }
    }

    // TODO: Tela de extrato
    // Tratamento de eventos do botão de pagamento
    /*
     * private class BHandlerExtrato implements ActionListener {
     * 
     * @Override public void actionPerformed(ActionEvent evento) { Extrato extrato =
     * new Extrato(); dispose(); } }
     */
}