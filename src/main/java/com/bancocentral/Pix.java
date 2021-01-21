package com.bancocentral;

import java.util.Random;

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
}
