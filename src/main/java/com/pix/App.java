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

        // todos_clientes.get(0).getConta().setChavePIX(Pix.gerarChavePix());

        System.out.println(todos_clientes.get("21637668000114").getConta().getSaldo());
        // todos_clientes.get("21637668000114").getConta().sacar(5000);
        // todos_clientes.get("21637668000114").getConta().getSaldo();



        LerClientesSerializados.atualizar(todos_clientes.values()); // atualiza o arquivo .pix
    }
}
