package com.pix;

public class App {
    public static void main(String[] args) {
        CriaDataBase.abrirArquivo();
        CriaDataBase.populaDados();
        CriaDataBase.fechaArquivo();
        // ArrayList<Cliente> todos_clientes;

        // LerClientesSerializados.abreArquivo();
        // todos_clientes = LerClientesSerializados.lerClientes();
        // LerClientesSerializados.fecharArquivo();

        // // Operações aqui
        
        // System.out.println(todos_clientes.get(0).getConta().getSaldo());
        // System.out.println(todos_clientes.get(1).getConta().getSaldo());
        // System.out.println(todos_clientes.get(2).getConta().getSaldo());
        // // todos_clientes.get(2).getConta().depositar(712);


        // LerClientesSerializados.atualizar(todos_clientes); // atualiza o arquivo .pix
    }
}
