package com.gui;

import com.pessoa.Cliente;
import com.pessoa.ClientePessoaFisica;
import com.backend.LerClientesSerializados;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collection;
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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public class Abertura extends JFrame {

    // declarando os elementos
    JFormattedTextField idCliente = new JFormattedTextField();
    JButton buttonEntrar = new JButton("Entrar"), buttonAcessoEspecial = new JButton("Acesso especial");
    JLabel labelTitulo = new JLabel("Selecione a ID");

    private final Icon iconUser = new ImageIcon("../projeto-pix/imgs/lock.png");
    private JRadioButton radioButtonCNPJ, radioButtonCPF;
    private RadioButtonHandler handlerRadioButton;
    private ButtonHandler handlerButtom;
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

        ImageIcon icon = new ImageIcon("../projeto-pix/imgs/pix.png");
        this.setIconImage(icon.getImage());
        this.setTitle("Faça seu login");
        
        painel1 = new JPanel();
        painel1.setLayout(new GridBagLayout());

        handlerRadioButton = new RadioButtonHandler();
        handlerButtom = new ButtonHandler();

        idCliente.setColumns(14);

        labelTitulo.setIcon(iconUser);

        // adição dos elementos à interface
        addElemento(painel1, labelTitulo , 0, 0, GridBagConstraints.CENTER, 70, 100, 10, 100);

        radioButtonCPF = new JRadioButton("CPF", false);
        addElemento(painel1, radioButtonCPF, 0, 1, GridBagConstraints.WEST, 10, 100, 10, 10);

        radioButtonCNPJ = new JRadioButton("CNPJ", false);
        addElemento(painel1, radioButtonCNPJ, 0, 1, GridBagConstraints.EAST, 10, 10, 10, 100);

        addElemento(painel1, idCliente, 0, 2, GridBagConstraints.CENTER, 0, 10, 10, 10);
        addElemento(painel1, buttonEntrar, 0, 3, GridBagConstraints.CENTER, 10, 10, 100, 10);

        // agrupamento dos RadioButtons
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(radioButtonCNPJ);
        grupo.add(radioButtonCPF);

        // Tratamento de eventos
        radioButtonCNPJ.addItemListener(handlerRadioButton);
        radioButtonCPF.addItemListener(handlerRadioButton);
        buttonEntrar.addActionListener(handlerButtom);

        // Dispara ação ao fechar a janela
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evento) {
                LerClientesSerializados.atualizar((Collection)todos_clientes.values()); // atualiza o arquivo .pix
                evento.getWindow().dispose();
            }
        });

        // Adição dos elementos ao painel
        this.add(painel1);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    // Método que adiciona os elementos
    private void addElemento(JPanel p, JComponent c, int coluna, int linha, int alinhamento,
            int superior, int esquerda, int inferior, int direita) {
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = coluna;
        gc.gridy = linha;
        gc.gridwidth = 1;
        gc.gridheight = 1;
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
    
    //Verifica se o cliente é válido e cria sua respectiva tela
    private void validaCliente(Cliente cli){
        if (cli != null) {// Cliente válido

            if (cli instanceof ClientePessoaFisica) {
                new TelaInicialPF(cli, todos_clientes.values());
                dispose();
            } else {
                new TelaInicialPJ(cli, todos_clientes.values());
                dispose();
            }
            // System.out.println(cli.getConta().getExtrato());
        } else {
            JOptionPane.showMessageDialog(null, "ID de formato incorreto", "ATENÇÃO!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}