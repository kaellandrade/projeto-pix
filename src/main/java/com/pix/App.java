package com.pix;

import java.util.Map;

import com.bancocentral.Pix;
import com.bancocentral.PortalTransparencia;
import com.gui.*;
import javax.swing.JFrame;
import javax.swing.text.StyledEditorKit;

import com.pessoa.Cliente;
import com.pessoa.ClientePessoaFisica;
import com.pessoa.ClientePessoaJuridica;
import com.backend.*;
import com.banco.*;

public class App {
    public static void main(String[] args) {
        // popularDados();
        Abertura abertura = new Abertura();
        abertura.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        abertura.setVisible(true);


        // Início Captura a data base
        LerClientesSerializados.abreArquivo();
        Map<String, Cliente> todos_clientes = LerClientesSerializados.lerClientes();
        LerClientesSerializados.fecharArquivo();
        // Fim Captura a data base

        // Teste teste chave pix
        ClientePessoaFisica pessoaf = (ClientePessoaFisica) todos_clientes.get("86719122134");
        
        // pessoaf.getConta().setChavePIX(Pix.gerarChavePix());
        // System.out.println(pessoaf.getConta().getChavePIX());
        
        // System.out.println(Pix.encontrarChave("jh68o3zknz7yyij4mk13"));

        LerClientesSerializados.atualizar(todos_clientes.values()); // atualiza o arquivo .pix
    }

    /**
     * Captura os clientes do JSON e serializa-os. Basta executá-lo uma vez;
     */
    public static void popularDados() {
        CriaDataBase.abrirArquivo();
        CriaDataBase.populaDados();
        CriaDataBase.fechaArquivo();
    }
}
