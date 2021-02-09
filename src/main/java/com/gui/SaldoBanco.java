package com.gui;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.GridBagConstraints;

import com.bancocentral.PortalTransparencia;

import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class SaldoBanco extends JFrame {
    PortalTransparencia transparencia = new PortalTransparencia();

    // declarando o JLabel
    JLabel labelH1 = new JLabel("Informações privilegiadas"),
    labelH2 = new JLabel("Saldo dos bancos"),
    labelSaldoCC = new JLabel("Saldo das contas correntes"),
    labelSaldoPP = new JLabel("Saldo das contas poupanças"),
    labelSaldoCS = new JLabel("Saldo das contas salário"),
    labelSaldoGeral = new JLabel("Saldo geral");

    // declarando o JComboBox
    private final JComboBox<String> jCBoxBancos;
    private static final String[] bancos = {"Selecione um banco", "Banco do Brasil", "Bradesco", "Itaú", "Santander"};

    // Declarando o JMenu, JMenuBar e JMenuItem;
    private JMenuBar barra;
    private JMenu menu;
    private JMenuItem login;

    // Variáveis para tratamento de eventos do menu
    private BHandlerLogin bHandlerLogin;

    private JComboBoxHandler jComboBoxHandler;

    private final Locale local = new Locale("pt", "BR");

    public SaldoBanco() {
       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());

        // Define o menu e seus componentes
        barra = new JMenuBar();
        menu = new JMenu("Opções");
        login = new JMenuItem("Tela de login");
        bHandlerLogin = new BHandlerLogin();

        jCBoxBancos = new JComboBox<String>(bancos);

        labelH1.setFont(labelH1.getFont().deriveFont(15.0f));
        labelSaldoCC.setFont(labelSaldoCC.getFont().deriveFont(20.0f));
        labelSaldoPP.setFont(labelSaldoPP.getFont().deriveFont(20.0f));
        labelSaldoCS.setFont(labelSaldoCS.getFont().deriveFont(20.0f));
        labelSaldoGeral.setFont(labelSaldoGeral.getFont().deriveFont(20.0f));
        
        // Adição dos elementos
        addElemento(painel, labelH1, 0, 0, 1, 1, GridBagConstraints.CENTER, 10, 100, 30, 100);
        addElemento(painel, labelH2, 0, 1, 1, 1, GridBagConstraints.WEST, 10, 10, 3, 10);
        addElemento(painel, labelSaldoCC, 0, 3, 1, 1, GridBagConstraints.CENTER, 40, 10, 50, 10);
        addElemento(painel, labelSaldoPP, 0, 4, 1, 1, GridBagConstraints.CENTER, 40, 10, 50, 10);
        addElemento(painel, labelSaldoCS, 0, 5, 1, 1, GridBagConstraints.CENTER, 40, 10, 50, 10);
        addElemento(painel, labelSaldoGeral, 0, 6, 1, 1, GridBagConstraints.CENTER, 40, 10, 50, 10);
        addElemento(painel, jCBoxBancos, 0, 2, 1, 1, GridBagConstraints.WEST, 3, 10, 10, 10);

        // adiciona menu ao JFrame
        menu.add(login);
        barra.add(menu);
        this.setJMenuBar(barra);

        // Tratamento de eventos
        login.addActionListener(bHandlerLogin);
        jComboBoxHandler = new JComboBoxHandler();
        jCBoxBancos.addActionListener(jComboBoxHandler);

        this.add(painel);
        this.pack();
        this.setLocationRelativeTo(null);
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

    // Tratamento de eventos do menu (login)
    private class BHandlerLogin implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            Abertura abertura = new Abertura();
            dispose();
        }
    }

    private class JComboBoxHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {

            ArrayList<Float> total = new ArrayList<>();

            if (jCBoxBancos.getSelectedIndex() == 0) {
                labelSaldoCC.setText("Saldo das contas correntes");
                labelSaldoPP.setText("Saldo das contas poupança");
                labelSaldoCS.setText("Saldo das contas salário");
                //labelSaldoCC.setText("Saldo geral");
            }

            if (jCBoxBancos.getSelectedIndex() == 1) {

                Float exibeLabelSaldoCC = transparencia.calcularMontanteBrasil().get("corrente");
                labelSaldoCC.setText(NumberFormat.getCurrencyInstance(local).format(exibeLabelSaldoCC));

                Float exibeLabelSaldoPP = transparencia.calcularMontanteBrasil().get("poupanca");
                labelSaldoPP.setText(NumberFormat.getCurrencyInstance(local).format(exibeLabelSaldoPP));

                Float exibeLabelSaldoCS = transparencia.calcularMontanteBrasil().get("salario");
                labelSaldoCS.setText(NumberFormat.getCurrencyInstance(local).format(exibeLabelSaldoCS));
                // TODO: Saldo geral
            }

            if (jCBoxBancos.getSelectedIndex() == 2) {

                Float exibeLabelSaldoCC = transparencia.calcularMontanBradesco().get("corrente");
                labelSaldoCC.setText(NumberFormat.getCurrencyInstance(local).format(exibeLabelSaldoCC));

                Float exibeLabelSaldoPP = transparencia.calcularMontanBradesco().get("poupanca");
                labelSaldoPP.setText(NumberFormat.getCurrencyInstance(local).format(exibeLabelSaldoPP));

                Float exibeLabelSaldoCS = transparencia.calcularMontanBradesco().get("salario");
                labelSaldoCS.setText(NumberFormat.getCurrencyInstance(local).format(exibeLabelSaldoCS));
                // TODO: Saldo geral
            }

            if (jCBoxBancos.getSelectedIndex() == 4) {

                Float exibeLabelSaldoCC = transparencia.calcularMontanSantander().get("corrente");
                labelSaldoCC.setText(NumberFormat.getCurrencyInstance(local).format(exibeLabelSaldoCC));

                Float exibeLabelSaldoPP = transparencia.calcularMontanSantander().get("poupanca");
                labelSaldoPP.setText(NumberFormat.getCurrencyInstance(local).format(exibeLabelSaldoPP));

                Float exibeLabelSaldoCS = transparencia.calcularMontanSantander().get("salario");
                labelSaldoCS.setText(NumberFormat.getCurrencyInstance(local).format(exibeLabelSaldoCS));
                // TODO: Saldo geral
            }

            if (jCBoxBancos.getSelectedIndex() == 3) {

                Float exibeLabelSaldoCC = transparencia.calcularMontanteItau().get("corrente");
                labelSaldoCC.setText(NumberFormat.getCurrencyInstance(local).format(exibeLabelSaldoCC));

                Float exibeLabelSaldoPP = transparencia.calcularMontanteItau().get("poupanca");
                labelSaldoPP.setText(NumberFormat.getCurrencyInstance(local).format(exibeLabelSaldoPP));

                Float exibeLabelSaldoCS = transparencia.calcularMontanteItau().get("salario");
                labelSaldoCS.setText(NumberFormat.getCurrencyInstance(local).format(exibeLabelSaldoCS));
                // TODO: Saldo geral
            }


        }
    }
    
}
