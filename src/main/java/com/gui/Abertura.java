package com.gui;

import com.pessoa.Cliente;
import com.pessoa.ClientePessoaFisica;
import com.backend.LerClientesSerializados;
import com.banco.Conta;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public class Abertura extends JFrame {

    // declarando os elementos
    JFormattedTextField idCliente = new JFormattedTextField();
    JButton buttonEntrar = new JButton("Entrar"), buttonAcessoEspecial = new JButton("Acesso especial");

    private JRadioButton radioButtonCNPJ, radioButtonCPF;
    private RadioButtonHandler handlerRadioButton;
    private ButtonHandler handlerButtom;
    private ButtonHandlerAE buttonHadlerAE;
    private JPanel painel1;
    private String id;
    private Map<String, Cliente> todos_clientes;

    // Construtor
    public Abertura() {

        // Início Captura a data base
        LerClientesSerializados.abreArquivo();
        todos_clientes = LerClientesSerializados.lerClientes();
        LerClientesSerializados.fecharArquivo();
        // Fim Captura a data base

        painel1 = new JPanel();
        painel1.setLayout(new GridBagLayout());

        handlerRadioButton = new RadioButtonHandler();
        handlerButtom = new ButtonHandler();
        buttonHadlerAE = new ButtonHandlerAE();

        idCliente.setColumns(14);

        // adição dos elementos à interface
        addElemento(painel1, new JLabel("Selecione a ID"), 0, 0, 1, 1, GridBagConstraints.CENTER, 70, 100, 10, 100);

        radioButtonCPF = new JRadioButton("CPF", false);
        addElemento(painel1, radioButtonCPF, 0, 1, 1, 1, GridBagConstraints.WEST, 10, 70, 10, 10);

        radioButtonCNPJ = new JRadioButton("CNPJ", false);
        addElemento(painel1, radioButtonCNPJ, 0, 1, 1, 1, GridBagConstraints.EAST, 10, 10, 10, 70);

        addElemento(painel1, idCliente, 0, 2, 1, 1, GridBagConstraints.CENTER, 0, 10, 10, 10);

        addElemento(painel1, buttonEntrar, 0, 3, 1, 2, GridBagConstraints.CENTER, 10, 10, 150, 10);

        addElemento(painel1, buttonAcessoEspecial, 0, 4, 1, 1, GridBagConstraints.SOUTH, 100, 10, 20, 10);

        // agrupamento dos RadioButtons
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(radioButtonCNPJ);
        grupo.add(radioButtonCPF);

        // Adição dos elementos ao painel
        this.add(painel1);
        this.pack();
        this.setVisible(true);

        // Tratamento de eventos
        radioButtonCNPJ.addItemListener(handlerRadioButton);
        radioButtonCPF.addItemListener(handlerRadioButton);
        buttonEntrar.addActionListener(handlerButtom);
        buttonAcessoEspecial.addActionListener(buttonHadlerAE);
    }

    // Método que adiciona os elementos
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

    // Tratamento de evento do RadioButton
    private class RadioButtonHandler implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent evento) {

            idCliente.setValue("");

            if (radioButtonCPF.isSelected()) {

                try {
                    MaskFormatter mascaraCPF = new MaskFormatter("###.###.###-##");
                    mascaraCPF.install(idCliente);
                } catch (Exception e) {
                    System.out.print(e);
                }
            }

            if (radioButtonCNPJ.isSelected()) {

                try {
                    MaskFormatter mascaraCNPJ = new MaskFormatter("##.###.###/0001-##");
                    mascaraCNPJ.install(idCliente);
                } catch (Exception e) {
                    System.out.print(e);
                }
            }
        }
    }

    // Tratamento de evento do botão Entrar
    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {

            id = idCliente.getText();
            id = id.replaceAll("\\W", "");
            
            Cliente cli;
            
            cli = todos_clientes.get(id);
            validaCliente(cli);
        }
    }

    // Tratamento de evento do botão de acesso especial
    private class ButtonHandlerAE implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            AcessoEspecial acessoEspecial = new AcessoEspecial();
            dispose();
        }
    }
    
    //Verifica se o cliente é válido e cria sua respectiva tela
    private void validaCliente(Cliente cli){
        if (cli != null) {// Cliente válido

            // cli.getConta().depositar(500);
            // LerClientesSerializados.atualizar(todos_clientes.values()); // atualiza o arquivo .pix

            String nome = cli.getName();
            String saldo = Float.toString(cli.getConta().getSaldo());
            
            if (cli instanceof ClientePessoaFisica) {
                TelaInicialPF telaPF = new TelaInicialPF();
                telaPF.labelHeader.setText(nome);
                telaPF.labelSaldo.setText(saldo);
                dispose();
            } else {
                TelaInicialPJ telaPJ = new TelaInicialPJ();
                telaPJ.labelHeader.setText(nome);
                telaPJ.labelSaldo.setText(saldo);
                dispose();
            }
            // System.out.println(cli.getConta().getExtrato());
        } else {
            JOptionPane.showMessageDialog(null, "ID de formato incorreto", "ATENÇÃO!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}