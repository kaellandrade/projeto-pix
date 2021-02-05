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

        
        
        ClientePessoaFisica funcionario =  (ClientePessoaFisica) todos_clientes.get("89657670160");
        ContaSalario cs = (ContaSalario) funcionario.getConta(); // conta corrente do empregador


        System.out.println("\n\nAntes do pagamento");
        System.out.println("Saldo Conta Corrente: " + cc.getSaldo());
        System.out.println("Extrato Conta Corrente:" + cc.getExtrato());
        // System.out.println("\nSaldo Conta Salario: " + cs.getSaldo());
        // System.out.println("Extrato Conta Salario: " + cs.getExtrato());
        
        // cc.realizarPagamento(funcionario, 600); // realiza pagamento para uma conta corrente;
        cc.depositar(100);


        System.out.println("\n\nDepois do pagamento");
        System.out.println("Saldo Conta Corrente: " + cc.getSaldo());
        System.out.println("Extrato Conta Corrente: " + cc.getExtrato());
        // System.out.println("\nSaldo Conta Salario:" + cs.getSaldo());
        // System.out.println("Extrato Conta Salario: " + cs.getExtrato());

        




        LerClientesSerializados.atualizar(todos_clientes.values()); // atualiza o arquivo .pix
    }
}
