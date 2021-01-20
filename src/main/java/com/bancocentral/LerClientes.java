package com.bancocentral;

import com.banco.*;
import com.pessoa.*;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;

// leitura do banco de dados CSV
public class LerClientes {
    private static final String CLIENTES_CSV = "src/main/java/com/banco/clientes.csv";

    // Retorna uma lista de lista de string com cada cliente;
    public static List<String[]> recuperaClientes() {
        List<String[]> records;

        Reader reader;
        try { // captura um erro
            reader = Files.newBufferedReader(Paths.get(CLIENTES_CSV));
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build(); // Pula o cabeçalho do arquivo
            records = csvReader.readAll();

        } catch (IOException | CsvException e) {
            e.printStackTrace();
            return null;
        }

        return records;
    }

    public static List<Cliente> recuperarClientesObj() {
        String tipoCli, tipoConta, nome, email, documentoID, telefone, chaveAleatoria, numConta, codigoBanco, nomeBanco,
                numeroAgencia;
        float saldo;

        Banco banc;
        Agencia ag;
        Conta conta;
        Cliente cli;

        List<Cliente> clientes = new ArrayList<>();
        try {

            CSVReader reader = new CSVReader(new FileReader(CLIENTES_CSV));

            String[] nextLine;

            while ((nextLine = reader.readNext()) != null) { // lertodas as linhas do arquivo CSV
                // Armazena os valores de cada coluna;
                tipoCli = nextLine[0];
                tipoConta = nextLine[1];
                nome = nextLine[2];
                email = nextLine[3];
                documentoID = nextLine[4];
                telefone = nextLine[5];
                chaveAleatoria = nextLine[6];
                numConta = nextLine[7];
                codigoBanco = nextLine[8];
                nomeBanco = nextLine[9];
                numeroAgencia = nextLine[10];
                saldo = Float.parseFloat(nextLine[11]);
                banc = new Banco(codigoBanco, nomeBanco); // Instância um objeto do tipo banco;
                ag = new Agencia(numeroAgencia, banc); // Instância um objeto do tipo Agencia e vincula ao um determinado banco;
                
                // Verifica o tipo da conta
                if (tipoConta.equals("CC")) // conta corrente
                    conta = new ContaCorrente(numConta, saldo, ag);
                else if (tipoConta.equals("CP")) // conta poupanca
                    conta = new ContaPoupanca(numConta, saldo, ag);
                else //conta salario
                    conta = new ContaSalario(numConta, saldo, ag);

                // Verifica o tipo de cliente.
                if (tipoCli.equals("PJ"))
                    cli = new ClientePessoaJuridica(nome, email, telefone, chaveAleatoria, conta, documentoID);
                else
                    cli = new ClientePessoaFisica(nome, email, telefone, chaveAleatoria, conta, documentoID);

                clientes.add(cli);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return clientes;
    }

}
