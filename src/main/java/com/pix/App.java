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

        System.out.println(todos_clientes.get("30322013305").getConta().getSaldo());
        // System.out.println(todos_clientes.get(1).getConta().getSaldo());
        // System.out.println(todos_clientes.get(2).getConta().getSaldo());
        // todos_clientes.get(2).getConta().sacar(3560);

        // LerClientesSerializados.atualizar(todos_clientes.); // atualiza o arquivo .pix
    }
}
