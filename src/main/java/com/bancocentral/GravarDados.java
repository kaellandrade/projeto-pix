package com.bancocentral;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GravarDados {
    private static final String CLIENTES_CSV = "src/main/java/com/bancocentral/clientes.csv";
    public static boolean salvarNovoCliente(String dadosClientes) {

        try {
            File file = new File(CLIENTES_CSV);
            // create FileWriter object with file as parameter
            
            FileWriter outputfile = new FileWriter(file, true);
            BufferedWriter out = new BufferedWriter(outputfile);

            out.write(dadosClientes); // informação ar ser gravada

            out.newLine();
            out.close();
            return true; // cliente salvo com sucesso;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
