package com.pix;

import java.util.Map;

import com.bancocentral.Pix;
import com.pessoa.Cliente;
import com.backend.*;

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

        // passando um cnpj
        System.out.println(todos_clientes.get("21637668000114").getConta().getSaldo());
        System.out.println(todos_clientes.get("21637668000114").getConta().getExtrato());

        // passando um cpf
        System.out.println(todos_clientes.get("86719122134").getConta().getSaldo());
        System.out.println(todos_clientes.get("86719122134").getConta().getExtrato());


        // todos_clientes.get("86719122134").getConta().sacar(60);






        LerClientesSerializados.atualizar(todos_clientes.values()); // atualiza o arquivo .pix
    }
}
