package com.bancocentral;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GravarDados {
    private static final String CLIENTES_CSV = "src/main/java/com/bancocentral/clientes.csv";
    public static boolean cadastrarCliente(String dadosClientes) {

        try {
            File file = new File(CLIENTES_CSV);
            
            
            FileWriter outputfile = new FileWriter(file, true);
            BufferedWriter out = new BufferedWriter(outputfile); // ler o arquivo para er gravado

            out.write(dadosClientes); // Informação para ser gravada
            out.newLine();
            out.close();

            return true; // cliente salvo com sucesso;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
