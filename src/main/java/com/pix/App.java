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

        ClientePessoaJuridica juridico =  (ClientePessoaJuridica) todos_clientes.get("85598612000180");
        ContaCorrente cc = (ContaCorrente) juridico.getConta(); // conta corrente do empregador

        
        
        ClientePessoaFisica pf =  (ClientePessoaFisica) todos_clientes.get("09532371338");
        ContaPoupanca cp = (ContaPoupanca) pf.getConta(); // conta corrente do empregador

        /*

        System.out.println("\n\nAntes tranferencia interna");
        System.out.println("Saldo Conta Corrente: " + cc.getSaldo());
        System.out.println("Extrato Conta Corrente:" + cc.getExtrato());

        System.out.println("Saldo Conta POP: " + cp.getSaldo());
        System.out.println("Extrato Conta POP: " + cp.getExtrato());
        
        cc.realizarTransferenciaInterna(pf, 100);
        
        */

        /*
        System.out.println("\n\nDepois transferencia interna");

        System.out.println("Saldo Conta Corrente: " + cc.getSaldo());
        System.out.println("Extrato Conta Corrente:" + cc.getExtrato());

        System.out.println("Saldo Conta POP: " + cp.getSaldo());
        System.out.println("Extrato Conta POP: " + cp.getExtrato());
        */




        LerClientesSerializados.atualizar(todos_clientes.values()); // atualiza o arquivo .pix
    }
}
