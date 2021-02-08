package com.gui;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.bancocentral.Cliente;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TransferenciaInterna extends JFrame {
    private com.pessoa.Cliente cliente;
    private final Locale local = new Locale("pt", "BR");

    // declarando os JTextField
    JTextField textFieldValor = new JTextField("Valor", 8), textFieldAgencia = new JTextField("Agência", 8),
            textFieldConta = new JTextField("Conta", 8);

    // Declarando o JComboBox com a lista de bancos
    String bancos[] = { "Banco do Brasil", "Bradesco", "Itaú", "Santander" };
    JComboBox jComboBoxBanco = new JComboBox(bancos);

    String tipoConta[] = { "Conta corrente", "Conta poupança" };
    JComboBox jComboBoxConta = new JComboBox(tipoConta);

    // Declarando o JButton
    JButton buttonTransferir = new JButton("Transferir");

    // Declarando os JLabels
    JLabel labelHeader = new JLabel("<html><center>Realizar transferência <br /> interna</center></html>"),
            labelSaldo = new JLabel("<html><center>Saldo da <br /> conta corrente</center></html>"),
            labelBanco = new JLabel("Selecione o banco"),
            labelTituloSaldo = new JLabel("Saldo atual"),
            labelConta = new JLabel("Selecione a conta");

    // Declarando o JMenu, JMenuBar e JMenuItem;
    private JMenuBar barra;
    private JMenu menu;
    private JMenuItem login;

    // Variáveis para tratamento de eventos do menu
    private BHandlerLogin bHandlerLogin;

    public TransferenciaInterna(com.pessoa.Cliente cli) {
        this.cliente = cli;
        Float saldoExibicao = cli.getConta().getSaldo();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());

        // Define o menu e seus componentes
        barra = new JMenuBar();
        menu = new JMenu("Opções");
        login = new JMenuItem("Tela de login");

        bHandlerLogin = new BHandlerLogin();
        labelSaldo.setText(NumberFormat.getCurrencyInstance(local).format(saldoExibicao));

        labelSaldo.setFont(labelSaldo.getFont().deriveFont(20.0f));

        // Adição dos elementos
        addElemento(painel, labelHeader, 0, 0, 1, 1, GridBagConstraints.CENTER, 10, 100, 40, 100);
        addElemento(painel, labelTituloSaldo, 0, 1, 1, 1, GridBagConstraints.CENTER, 10, 10, 2, 10);
        addElemento(painel, labelSaldo, 0, 2, 1, 1, GridBagConstraints.CENTER, 2, 10, 30, 10);
        addElemento(painel, textFieldValor, 0, 3, 1, 1, GridBagConstraints.CENTER, 0, 10, 20, 10);
        addElemento(painel, labelBanco, 0, 4, 1, 1, GridBagConstraints.CENTER, 12, 10, 3, 10);
        addElemento(painel, jComboBoxBanco, 0, 5, 1, 1, GridBagConstraints.CENTER, 3, 10, 10, 10);
        addElemento(painel, textFieldAgencia, 0, 6, 1, 1, GridBagConstraints.WEST, 12, 70, 10, 10);
        addElemento(painel, textFieldConta, 0, 6, 1, 1, GridBagConstraints.EAST, 12, 10, 12, 70);
        addElemento(painel, labelConta, 0, 7, 1, 1, GridBagConstraints.CENTER, 12, 10, 3, 10);
        addElemento(painel, jComboBoxConta, 0, 8, 1, 1, GridBagConstraints.CENTER, 3, 10, 10, 10);
        addElemento(painel, buttonTransferir, 0, 9, 1, 1, GridBagConstraints.CENTER, 70, 10, 10, 10);

        // adiciona menu ao JFrame
        menu.add(login);
        barra.add(menu);
        this.setJMenuBar(barra);

        // adiciona os componentes ao JFrame
        this.add(painel);
        this.pack();
        this.setVisible(true);

        // Tratamento de eventos
        login.addActionListener(bHandlerLogin);
    }

    private void addElemento(JPanel p, JComponent c, int linha, int coluna, int largura, int altura, int alinhamento,
            int superior, int esquerda, int inferior, int direita) {
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

    // Tratamento de eventos do menu (login)
    private class BHandlerLogin implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            Abertura abertura = new Abertura();
            dispose();
        }
    }
}