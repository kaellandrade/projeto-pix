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

        // todos_clientes.get("21637668000114").getConta().sacar(400);

        System.out.println(todos_clientes.get("65436995152").getConta());
        System.out.println(todos_clientes.get("65436995152").getConta());





        LerClientesSerializados.atualizar(todos_clientes.values()); // atualiza o arquivo .pix
    }
}
