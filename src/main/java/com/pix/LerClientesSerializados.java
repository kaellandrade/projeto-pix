package com.pix;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.pessoa.Cliente;
import java.io.ObjectOutputStream;

public class LerClientesSerializados {
    private static ObjectInputStream input;
    private static ObjectOutputStream output; // gera saída dos dados no arquivo

    private static final String PATHSERPIX = "src/main/java/com/pix/clientesOBj.pix";
    private static ArrayList<Cliente> todosClientes = new ArrayList<Cliente>();

    public static void abreArquivo() {
        try { // abre o arquivo para desearilizar
            input = new ObjectInputStream(Files.newInputStream(Paths.get(PATHSERPIX)));
        } catch (IOException ioException) {
            System.err.println("Erro ao abrir o arquivo.");
            System.exit(1);
        }
    }

    // lê o registro no arquivo
    public static ArrayList<Cliente> lerClientes() {

        try {
            while (true) // faz um loop até ocorrer uma EOFException
            {
                Cliente cli = (Cliente) input.readObject();
                todosClientes.add(cli);
                // System.out.println(cli);
            }
        } catch (EOFException endOfFileException) {
            System.out.printf("Não há mais clientes\n");
        } catch (ClassNotFoundException classNotFoundException) {
            System.err.println("Tipo de objeto inválido. Terminando.");
        } catch (IOException ioException) {
            System.err.println("Erro ao ler o arquivo .pix. Terminando.");
        }
        return todosClientes;

    }

    public static void atualizar(ArrayList<Cliente> clientes) { // atualiza os estados dos objetos apois modificações
        try {
            output = new ObjectOutputStream(Files.newOutputStream(Paths.get(PATHSERPIX)));
            for (int i = 0; i < clientes.size(); i++) {
                output.writeObject(clientes.get(i));
            }
            output.close();
        } catch (IOException ioException) {
            System.err.println("Erro ao abrir o arquivo!");
            System.exit(1); // termina o programa
        }

    }

    // fecha o arquivo e termina o aplicativo
    public static void fecharArquivo() {

        try {
            if (input != null)
                input.close();
        } catch (IOException ioException) {
            System.err.println("Error closing file. Terminating.");
            System.exit(1);
        }
    }
}
