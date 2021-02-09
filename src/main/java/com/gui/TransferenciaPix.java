package com.gui;

import com.pessoa.Cliente;

import com.backend.LerClientesSerializados;
import com.bancocentral.Pix;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.event.*;

import java.text.NumberFormat;
import java.util.Collection;
import java.util.Locale;


import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public class TransferenciaPix extends JFrame {

    private Cliente cliente;
    private Collection<Cliente> clientes;
    private final Locale local = new Locale("pt", "BR");

    // Configuração do JComboBox
    private final JComboBox<String> jCBoxChaves;
    private static final String[] tiposChaves = { "Selecione uma chave", "CPF", "CNPJ", "E-mail", "Telefone",
            "Chave Pix" };

    // declarando os JTextField
    JFormattedTextField textFieldValor = new JFormattedTextField(), textFieldChave = new JFormattedTextField();

    // Declarando o JButton
    JButton buttonTransferir = new JButton("Transferir");

    // Declarando os JLabels
    JLabel labelHeader = new JLabel("<html><center>Realizar transferência <br />via Pix</center></html>"),
            labelSaldo = new JLabel(""), labelTituloSaldo = new JLabel("Saldo atual"),
            labelTransferencia = new JLabel("<html><center>Selecione o meio<br />de transferência</center></html>");

    // Declarando o JMenu, JMenuBar e JMenuItem;
    private JMenuBar barra;
    private JMenu menu;
    private JMenuItem login;

    // Variáveis para tratamento de eventos do menu
    private BHandlerLogin bHandlerLogin;

    private JComboBoxHandler jComboBoxHandler;
    private BHandlerTransferir bHandlerTransferir;

    public TransferenciaPix(Cliente cli, Collection cli2) {
        this.cliente = cli;
        this.clientes = cli2;

        Float saldoExibicao = cliente.getConta().getSaldo();
        labelSaldo.setText(NumberFormat.getCurrencyInstance(local).format(saldoExibicao));

        jCBoxChaves = new JComboBox<String>(tiposChaves);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());

        // Definindo o tamanho dos JFormattedTextField
        textFieldValor.setColumns(8);
        textFieldChave.setColumns(14);

        // Define o menu e seus componentes
        barra = new JMenuBar();
        menu = new JMenu("Opções");
        login = new JMenuItem("Tela de login");

        bHandlerLogin = new BHandlerLogin();
        bHandlerTransferir = new BHandlerTransferir();

        labelSaldo.setFont(labelSaldo.getFont().deriveFont(20.0f));

        // Adição dos elementos
        addElemento(painel, labelHeader, 0, 0, 1, 1, GridBagConstraints.CENTER, 10, 100, 40, 100);
        addElemento(painel, labelTituloSaldo, 0, 1, 1, 1, GridBagConstraints.CENTER, 10, 10, 2, 10);
        addElemento(painel, labelSaldo, 0, 2, 1, 1, GridBagConstraints.CENTER, 2, 10, 30, 10);
        addElemento(painel, textFieldValor, 0, 3, 1, 1, GridBagConstraints.CENTER, 0, 10, 20, 10);
        addElemento(painel, labelTransferencia, 0, 4, 1, 1, GridBagConstraints.CENTER, 30, 10, 10, 10);
        addElemento(painel, jCBoxChaves, 0, 5, 1, 1, GridBagConstraints.CENTER, 1, 10, 10, 10);
        addElemento(painel, textFieldChave, 0, 6, 1, 1, GridBagConstraints.CENTER, 10, 10, 10, 10);
        addElemento(painel, buttonTransferir, 0, 7, 1, 1, GridBagConstraints.CENTER, 70, 10, 10, 10);

        // adiciona menu ao JFrame
        menu.add(login);
        barra.add(menu);
        this.setJMenuBar(barra);

        // Dispara ação ao fechar a janela
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evento) {
                LerClientesSerializados.atualizar(clientes); // atualiza o arquivo .pix
                evento.getWindow().dispose();
            }
        });

        // Tratamento de eventos
        jComboBoxHandler = new JComboBoxHandler();
        login.addActionListener(bHandlerLogin);
        jCBoxChaves.addActionListener(jComboBoxHandler);
        buttonTransferir.addActionListener(bHandlerTransferir);

        this.add(painel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
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
            LerClientesSerializados.atualizar(clientes); // atualiza o arquivo .pix
            Abertura abertura = new Abertura();
            dispose();
        }
    }

    private class JComboBoxHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {

            textFieldChave.setValue("");

            if (jCBoxChaves.getSelectedIndex() == 1) {
                try {
                    MaskFormatter mascaraCPF = new MaskFormatter("###.###.###-##");
                    mascaraCPF.install(textFieldChave);
                } catch (Exception e) {
                    System.out.print(e);
                }
            }

            if (jCBoxChaves.getSelectedIndex() == 2) {
                try {
                    MaskFormatter mascaraCNPJ = new MaskFormatter("##.###.###/0001-##");
                    mascaraCNPJ.install(textFieldChave);
                } catch (Exception e) {
                    System.out.print(e);
                }
            }

            if (jCBoxChaves.getSelectedIndex() == 4) {
                try {
                    MaskFormatter mascaraTelefone = new MaskFormatter("(##) # ####-####");
                    mascaraTelefone.install(textFieldChave);
                } catch (Exception e) {
                    System.out.print(e);
                }
            }

            if (jCBoxChaves.getSelectedIndex() == 5) {
                try {
                    MaskFormatter mascaraChavePix = new MaskFormatter("****-****-****-****-****");
                    mascaraChavePix.install(textFieldChave);
                } catch (Exception e) {
                    System.out.print(e);
                }
            }
        }
    }

    private class BHandlerTransferir implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            String chave = textFieldChave.getText();

            Float valor = Math.abs(Float.parseFloat(textFieldValor.getText()));

            int selecionado = jCBoxChaves.getSelectedIndex();
            // retira a másca dos campos de cpf, cnpj, telefone e chavepix
            if (selecionado == 1 || selecionado == 2 || selecionado == 4 || selecionado == 5) {
                chave = chave.replaceAll("\\W", "");
            }

            Float saldoExibicao = cliente.getConta().getSaldo();

            if (!chave.isEmpty()) { // se há valor no campo
                Cliente recebedor = Pix.encontrarChave(chave, clientes);
                if (recebedor != null && recebedor != cliente) { // verifica se há um cliente válido
                    String valor_formatado = NumberFormat.getCurrencyInstance(local).format(valor);
                    int resposta = JOptionPane.showConfirmDialog(null,
                            String.format("Fazer pix de %s para %s", valor_formatado, recebedor.getName()), "Atenção!",
                            JOptionPane.INFORMATION_MESSAGE);
                    if (resposta == JOptionPane.YES_NO_OPTION) {

                        if (cliente.getConta().fazerPix(recebedor, valor)) {
                            JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso", "Atenção",
                                    JOptionPane.INFORMATION_MESSAGE);

                            labelSaldo.setText(NumberFormat.getCurrencyInstance(local).format(saldoExibicao));
                            new TransferenciaPix(cliente, clientes);
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Atenção",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Não há clientes associados a essa chave", "Atenção",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Digite uma chave", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }
}