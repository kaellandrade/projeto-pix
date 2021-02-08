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
        // Abertura abertura = new Abertura();
        // abertura.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // abertura.setVisible(true);


        // Início Captura a data base
        LerClientesSerializados.abreArquivo();
        Map<String, Cliente> todos_clientes = LerClientesSerializados.lerClientes();
        LerClientesSerializados.fecharArquivo();
        // Fim Captura a data base

        // Teste teste chave pix
        Cliente pessoj = (ClientePessoaJuridica) todos_clientes.get("21637668000114");
        Cliente pessof = (ClientePessoaFisica) todos_clientes.get("36579272554");

        String chave = pessoj.getConta().getChavePIX();

        Pix.encontrarChave(chave, todos_clientes.values());

        System.out.println(pessoj.getConta().getExtrato());
        System.out.println(pessof.getConta().getExtrato());



        // pessof.getConta().fazerPix(Pix.encontrarChave(chave, todos_clientes.values()), 100);
        
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
