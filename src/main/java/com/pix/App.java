package com.pix;

import java.util.Map;

import com.bancocentral.Pix;
import com.pessoa.Cliente;
import com.pessoa.ClientePessoaFisica;
import com.pessoa.ClientePessoaJuridica;
import com.backend.*;
import com.banco.*;

public class App {
    public static void main(String[] args) {
        Map<String, Cliente> todos_clientes;
        // CriaDataBase.abrirArquivo();
        // CriaDataBase.populaDados();
        // CriaDataBase.fechaArquivo();

        LerClientesSerializados.abreArquivo();
        todos_clientes = LerClientesSerializados.lerClientes();
        LerClientesSerializados.fecharArquivo();

        // TODO: Operações aqui

        ClientePessoaJuridica empregador =  (ClientePessoaJuridica) todos_clientes.get("21637668000114");
        ContaCorrente cc = (ContaCorrente) empregador.getConta(); // conta corrente do empregador

        
        
        ClientePessoaFisica funcionario =  (ClientePessoaFisica) todos_clientes.get("91365036146");
        ContaSalario cs = (ContaSalario) funcionario.getConta(); // conta corrente do empregador


        System.out.println("Antes do pagamento");
        System.out.println(cc.getSaldo());
        System.out.println(cc.getExtrato());
        System.out.println(cs.getSaldo());
        System.out.println(cs.getExtrato());
        
        // cc.realizarPagamento(cs, 100); // realiza pagamento para uma conta corrente;
        cc.sacar(100);


        System.out.println("Depois do pagamento");
        System.out.println(cc.getSaldo());
        System.out.println(cc.getExtrato());
        System.out.println(cs.getSaldo());
        System.out.println(cs.getExtrato());

        




        LerClientesSerializados.atualizar(todos_clientes.values()); // atualiza o arquivo .pix
    }
}
