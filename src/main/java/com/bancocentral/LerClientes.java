package com.bancocentral;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

// leitura do banco de dados CSV
public class LerClientes {
    private static final String CLIENTES_CSV = "src/main/java/com/bancocentral/clientes.csv";

    public static List<String[]> recuperaClientes(){
        List<String[]> records;

        Reader reader;
        try { // captura um erro
            reader = Files.newBufferedReader(Paths.get(CLIENTES_CSV));
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build(); // Pula o cabeçalho do arquivo CSV
            records = csvReader.readAll();
            
        } catch (IOException | CsvException e) {
            e.printStackTrace();
            return null;
        }

        return records;
    }
}
