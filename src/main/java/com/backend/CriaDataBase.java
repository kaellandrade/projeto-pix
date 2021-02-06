package com.backend;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import com.banco.*;
import com.pessoa.*;

/**
 * CriaDataBase contém métodos responsáveis por criar e semear o arquivo
 * clientesOBj.pix (armazena Clientes) com base no arquivo clientesDataBase.json
 * (listas de clients para ser instanciada).
 */

public class CriaDataBase {
    private static ObjectOutputStream output; // gera saída dos dados no arquivo
    private static final String PATHJ = "src/main/java/com/backend/clientesDataBase.json";
    private static final String PATHSERPIX = "src/main/java/com/backend/clientesOBj.pix";

    /**
     * Abre o arquivo clientesOBj.pix caso exista, senão será criado;
     */
    public static void abrirArquivo() {
        try {
            output = new ObjectOutputStream(Files.newOutputStream(Paths.get(PATHSERPIX)));
        } catch (IOException ioException) {
            System.err.println("Erro ao abrir o arquivo!");
            System.exit(1); // termina o programa
        }
    }

    /**
     * populaDados irá instanciar todos os clientes do arquivo clientesDataBase.json
     * serializando-os no arqruivo clientesOBj.pix.
     * PS: Basta executar esse método uma única vez.
     */
    public static void populaDados() {
        final int LENGTH_CNPJ = 14;

        try {
            Scanner scanner = new Scanner(new File(PATHJ));
            while (scanner.hasNext()) { // itera o arquivo json, onde cada linha é um JSON
                // converte cada linha para JSON
                JSONObject obj = (JSONObject) new JSONParser().parse(scanner.nextLine());

                // instanciando cada linha
                Banco bc = new Banco(obj.get("codigoBanco").toString(), obj.get("nomeBanco").toString());
                Agencia ag = new Agencia(obj.get("agencia").toString(), bc);

                Cliente cli;
                Conta conta;

                // se for CNPJ criar conta Corrente e uma pessoa jurídica
                if (obj.get("cpfOUCNPJ").toString().length() == LENGTH_CNPJ) {
                    conta = new ContaCorrente(obj.get("conta").toString(),
                            Float.parseFloat(obj.get("saldo").toString()), ag);

                    cli = new ClientePessoaJuridica(obj.get("nome").toString(), obj.get("email").toString(),
                            obj.get("telefone").toString(), conta, obj.get("cpfOUCNPJ").toString());
                } else { // caso contrário cria uma conta Poupanca e uma pessoa física
                    // TODO: Criar uma conta salário ou poupança com RANDOM;
                    conta = new ContaPoupanca(obj.get("conta").toString(),
                            Float.parseFloat(obj.get("saldo").toString()), ag);

                    cli = new ClientePessoaFisica(obj.get("nome").toString(), obj.get("email").toString(),
                            obj.get("telefone").toString(), conta, obj.get("cpfOUCNPJ").toString());
                }
                output.writeObject(cli); // serializa o objeto cli
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    // Após a serialização fecha o arquivo
    public static void fechaArquivo() {
        try {
            if (output != null)
                output.close();
        } catch (IOException ioException) {
            System.err.println("Erro ao fechar arquivo. Terminando.");
        }
    }

}
