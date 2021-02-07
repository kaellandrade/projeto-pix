package com.bancocentral;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import com.backend.LerClientesSerializados;

/**
 * Pix é responsável pela manutenção das chaves.
 */
public class Pix {
    private static final String CARACTERES = "0123456789987654321abcdefghijklmnopqrstuvwxyz";
    private static final int TAMANHO_CHAVE = 20;

    /**
     * Método responsável por gerar uma chave pix com 20 caracteres alfanuméricos
     */
    public static String gerarChavePix() {
        String chave = "";
        int ch;

        Random random = new Random();

        for (int i = 0; i < TAMANHO_CHAVE; i++) {
            ch = random.nextInt(CARACTERES.length()); // sorteia um caractere da cadeia;
            chave += CARACTERES.charAt(ch);
        }
        return chave;
    }

    /**
     * Retornar um cliente associado a uma determinada chave pix aleatória para realizar um PIX
     */
    public static com.pessoa.Cliente encontrarChave(String chavepix) {
        Collection<com.pessoa.Cliente> todos_clientes;

        // Início Captura a data base
        LerClientesSerializados.abreArquivo();
        todos_clientes = LerClientesSerializados.lerClientes().values();
        LerClientesSerializados.fecharArquivo();
        // Fim Captura a data base

        Iterator<com.pessoa.Cliente> cliIterator = todos_clientes.iterator();
        while (cliIterator.hasNext()) {
            String chaveCliAtual = cliIterator.next().getConta().getChavePIX();
            if (chavepix.equals(chaveCliAtual))
                return cliIterator.next();

        }
        return null;
    }
}
