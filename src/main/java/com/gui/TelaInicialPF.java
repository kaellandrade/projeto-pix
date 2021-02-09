package com.gui;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Collection;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.banco.Banco;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.pessoa.Cliente;

public class TelaInicialPF extends JFrame {
    private Cliente cliente;
    private Collection<Cliente> clientes;

    private final Locale local = new Locale("pt", "BR");

    // declarando os JLabel
    JLabel labelHeader = new JLabel("Menu Pessoa Física"), labelSaldo = new JLabel("Saldo");
    
    // declarando os JButtons
    JButton buttonTI = new JButton("Realizar transferência"),
            buttonExtrato = new JButton("Consultar o extrato da conta"),
            buttonPix = new JButton("Acessar o Pix"),
            buttonSaldo = new JButton("Saldo geral");

    private BHandlerTransferencia bHandlerTransferencia;
    private BHandlerPix bHandlerPix;
    private BHandlerExtrato bHandlerExtrato;
    private BHandlerSaldo bHandlerSaldo;

    // Declarando o JMenu, JMenuBar e JMenuItem;
    private JMenuBar barra;
    private JMenu menu;
    private JMenuItem login;

    // Variáveis para tratamento de eventos do menu
    private BHandlerLogin bHandlerLogin;

    public TelaInicialPF(com.pessoa.Cliente cli, Collection cli2) {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());

        // Define o menu e seus componentes
        barra = new JMenuBar();
        menu = new JMenu("Opções");
        login = new JMenuItem("Tela de login");
        bHandlerLogin = new BHandlerLogin();

        this.clientes = cli2;

        this.cliente = cli;
        String nomeExibicao = cli.getName();
        Float saldoExibicao = cli.getConta().getSaldo();
        Banco banco = cli.getConta().getAgencia().getBanco();
        ImageIcon icon = new ImageIcon("../projeto-pix/imgs/" + banco.getCodigoBanco() + ".png");

        this.setTitle("Bem-Vindo ao " + banco.getNomeBanco());
        this.setIconImage(icon.getImage());

        bHandlerTransferencia = new BHandlerTransferencia();
        bHandlerPix = new BHandlerPix();
        bHandlerExtrato = new BHandlerExtrato();
        bHandlerSaldo = new BHandlerSaldo();

        labelSaldo.setFont(labelSaldo.getFont().deriveFont(20.0f));
        labelHeader.setFont(labelHeader.getFont().deriveFont(14.0f));
        labelHeader.setText(nomeExibicao);
        labelSaldo.setText(NumberFormat.getCurrencyInstance(local).format(saldoExibicao));

        // Adição dos elementos
        addElemento(painel, labelHeader, 1, 0, GridBagConstraints.CENTER, 10, 100, 10, 100, GridBagConstraints.NONE, 50);
        addElemento(painel, labelSaldo, 1, 1, GridBagConstraints.CENTER, 10, 10, 10, 10, GridBagConstraints.NONE, 50);
        addElemento(painel, buttonTI, 1, 2, GridBagConstraints.CENTER, 30, 80, 10, 80, GridBagConstraints.HORIZONTAL, 10);
        addElemento(painel, buttonPix, 1, 3,GridBagConstraints.CENTER, 10, 80, 10, 80, GridBagConstraints.HORIZONTAL, 10);
        addElemento(painel, buttonExtrato, 1, 4, GridBagConstraints.CENTER, 10, 80, 10, 80, GridBagConstraints.HORIZONTAL, 10);
        addElemento(painel, buttonSaldo, 1, 5, GridBagConstraints.CENTER, 10, 80, 70, 80, GridBagConstraints.HORIZONTAL, 10);

        // adiciona menu ao JFrame
        menu.add(login);
        barra.add(menu);
        this.setJMenuBar(barra);

        // Tratamento de eventos
        buttonTI.addActionListener(bHandlerTransferencia);
        buttonPix.addActionListener(bHandlerPix);
        buttonExtrato.addActionListener(bHandlerExtrato);
        login.addActionListener(bHandlerLogin);
        buttonSaldo.addActionListener(bHandlerSaldo);

        this.add(painel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    // Método que adiciona os elementos
    private void addElemento(JPanel p, JComponent c, int coluna, int linha, int alinhamento, int superior, int esquerda,
            int inferior, int direita, int preenchimento, int ipady) {
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = coluna;
        gc.gridy = linha;
        gc.gridwidth = 1;
        gc.gridheight = 1;
        gc.ipady = ipady;
        gc.insets = new Insets(superior, esquerda, inferior, direita);
        gc.anchor = alinhamento;
        gc.fill = preenchimento;
        p.add(c, gc);
    }

    // Tratamento de eventos do botão de transferência
    private class BHandlerTransferencia implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            new TransferenciaInterna(cliente);
            dispose();
        }
    }

  // Tratamento de eventos do botão do Pix
    private class BHandlerPix implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            new TelaPix(cliente, clientes);
            dispose();
        }
    }

    private class BHandlerExtrato implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            new Extrato(cliente);
            dispose();
        }
    }

    // Tratamento de eventos do menu (login)
    private class BHandlerLogin implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            Abertura abertura = new Abertura();
            dispose();
        }
    }

    public class BHandlerSaldo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            AcessoEspecial acessoEspecial = new AcessoEspecial();
            dispose();
        }
    }
}