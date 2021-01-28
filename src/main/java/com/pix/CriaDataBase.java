package com.pix;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import com.banco.Agencia;
import com.banco.Banco;
import com.banco.Conta;
import com.banco.ContaCorrente;
import com.banco.ContaPoupanca;
import com.pessoa.Cliente;
import com.pessoa.ClientePessoaFisica;
import com.pessoa.ClientePessoaJuridica;

/*
Serializa todos os clients no arquivo JSON
*/
public class CriaDataBase {
    private static ObjectOutputStream output; // gera saída dos dados no arquivo
    private static final String PATHJ = "src/main/java/com/pix/clientesDataBase.json";
    private static final String PATHSERPIX = "src/main/java/com/pix/clientesOBj.pix";

    // abre o arquivo clientes.pix
    public static void abrirArquivo() {
        try {
            output = new ObjectOutputStream(Files.newOutputStream(Paths.get(PATHSERPIX)));
        } catch (IOException ioException) {
            System.err.println("Erro ao abrir o arquivo!");
            System.exit(1); // termina o programa
        }
    }

    // popula os dados a partir do arquivo CSV
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

                if (obj.get("cpfOUCNPJ").toString().length() == LENGTH_CNPJ) {// se for CNPJ
                    conta = new ContaCorrente(obj.get("conta").toString(),
                            Float.parseFloat(obj.get("saldo").toString()), ag);

                    cli = new ClientePessoaJuridica(obj.get("nome").toString(), obj.get("email").toString(),
                            obj.get("telefone").toString(), conta, obj.get("cpfOUCNPJ").toString());
                } else {
                    conta = new ContaPoupanca(obj.get("conta").toString(),
                            Float.parseFloat(obj.get("saldo").toString()), ag);

                    cli = new ClientePessoaFisica(obj.get("nome").toString(), obj.get("email").toString(),
                            obj.get("telefone").toString(), conta, obj.get("cpfOUCNPJ").toString());
                }
                output.writeObject(cli);

                // serializa todos os clientes

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    // fecha o arquivo e termina o aplicativo
    public static void fechaArquivo() {
        try {
            if (output != null)
                output.close();
        } catch (IOException ioException) {
            System.err.println("Erro ao fechar arquivo. Terminando.");
        }
    }

}
