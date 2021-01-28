package com.pix;

import java.util.ArrayList;
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

        System.out.println(todos_clientes.get("51829592734").getConta().getSaldo());
        System.out.println(todos_clientes.get("51829592734").getConta().getExtrato());

        // System.out.println(todos_clientes.get("51829592734").getConta());
        // todos_clientes.get("51829592734").getConta().sacar(10);






        LerClientesSerializados.atualizar(todos_clientes.values()); // atualiza o arquivo .pix
    }
}
