package com.pix;

import java.util.Map;

import com.gui.*;

import com.bancocentral.Pix;
import com.pessoa.Cliente;
import com.pessoa.ClientePessoaFisica;
import com.pessoa.ClientePessoaJuridica;
import com.backend.*;
import com.banco.*;
import javax.swing.JFrame;

public class App {
    public static void main(String[] args) {

        Abertura abertura = new Abertura();
        abertura.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        abertura.setVisible(true);

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

        
        
        ClientePessoaFisica pf =  (ClientePessoaFisica) todos_clientes.get("89657670160");
        ContaPoupanca cp = (ContaPoupanca) pf.getConta(); // conta corrente do empregador


        System.out.println("\n\nAntes");
        System.out.println("Saldo Conta Corrente: " + cp.getSaldo());
        System.out.println("Extrato Conta Corrente:" + cp.getExtrato());
        // System.out.println("\nSaldo Conta Salario: " + cs.getSaldo());
        // System.out.println("Extrato Conta Salario: " + cs.getExtrato());
        
        // cc.realizarPagamento(funcionario, 600); // realiza pagamento para uma conta corrente;
        cp.depositar(1000);


        System.out.println("\n\nDepois");
        System.out.println("Saldo Conta Corrente: " + cp.getSaldo());
        System.out.println("Extrato Conta Corrente: " + cp.getExtrato());
        // System.out.println("\nSaldo Conta Salario:" + cs.getSaldo());
        // System.out.println("Extrato Conta Salario: " + cs.getExtrato());

        




        LerClientesSerializados.atualizar(todos_clientes.values()); // atualiza o arquivo .pix
    }
}
