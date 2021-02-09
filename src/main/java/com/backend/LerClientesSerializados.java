package com.backend;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.pessoa.Cliente;
import com.pessoa.ClientePessoaFisica;
import com.pessoa.ClientePessoaJuridica;

import java.io.ObjectOutputStream;

/**
 * LerClientesSerializados contém métodos responsáveis por deserializar o
 * arquivo clienteOJb.pix e atualizar as mudanças no arquivo serializado;
 */
public class LerClientesSerializados {
    private static ObjectInputStream input; // recupeara os dados do arquivo clienteOJb.pix
    private static ObjectOutputStream output; // gera saída dos dados no arquivo clienteOJb.pix

    private static final String PATHSERPIX = "src/main/java/com/backend/clientesOBj.pix";

    private static Map<String, Cliente> todosClientes = new HashMap<>(); // armazena todos os clientes deserializados

    /**
     * Abre o arquivo para desearilizar
     */
    public static void abreArquivo() {
        try {
            input = new ObjectInputStream(Files.newInputStream(Paths.get(PATHSERPIX)));
        } catch (IOException ioException) {
            System.err.println("Erro ao abrir o arquivo.");
            System.exit(1);
        }
    }

    /**
     * Retornar uma lista de Clientes lidos a partir do arquivo clienteOJb.pix
     */
    public static Map<String, Cliente> lerClientes() {

        try {
            while (true) // faz um loop até ocorrer uma EOFException
            {
                Cliente cli = (Cliente) input.readObject();
                if (cli instanceof ClientePessoaFisica) {
                    ClientePessoaFisica f;
                    f = (ClientePessoaFisica) cli; // faz o downcast
                    todosClientes.put(f.getCpf(), f);
                } else {
                    ClientePessoaJuridica j;
                    j = (ClientePessoaJuridica) cli; // faz o downcast
                    todosClientes.put(j.getCnpj(), j);
                }
                // System.out.println(cli);
            }
        } catch (EOFException endOfFileException) {
            // System.out.printf("Clientes lidos com sucesso!\n");
        } catch (ClassNotFoundException classNotFoundException) {
            System.err.println("Tipo de objeto inválido. Terminando.");
        } catch (IOException ioException) {
            System.err.println("Erro ao ler o arquivo .pix. Terminando.");
        }
        return todosClientes;

    }

    /**
     * Recebe uma lista de clintes e serializa todos eles novamente dentro do
     * arquivo clienteOJb.pix PS: Esse método deve ser executado após a finalização
     * da aplicação para manter os estados dos objetos atualizados.
     */
    public static void atualizar(Collection<Cliente> clientes) { // atualiza os estados dos objetos apois modificações
        try {
            output = new ObjectOutputStream(Files.newOutputStream(Paths.get(PATHSERPIX)));
            Iterator<Cliente> iterador = clientes.iterator();
            while (iterador.hasNext()) {
                output.writeObject(iterador.next());
            }
            output.close();
        } catch (IOException ioException) {
            System.err.println("Erro ao abrir o arquivo!");
            System.exit(1); // termina o programa
        }

    }

    /**
     * Fecha o arquivo e finaliza a gravação.
     */
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
