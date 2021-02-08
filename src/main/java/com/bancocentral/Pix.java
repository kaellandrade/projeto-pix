package com.bancocentral;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import com.pessoa.Cliente;

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
     * Recebe como parâmetro uma chave pix aleatoria e o banco de dados de todos os clientes.
     * Retornar um cliente associado a uma determinada chave pix para realizar um PIX
     */
    public static Cliente encontrarChave(String chavepix, Collection clientes) {

        Iterator<Cliente> cliIterator = clientes.iterator();

        while (cliIterator.hasNext()) {
            Cliente cli = cliIterator.next();
            String chaveCliAtual = cli.getConta().getChavePIX();

            if (chaveCliAtual.equals(chavepix))
                return cli;

        }
        return null;
    }
}
