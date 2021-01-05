package com.bancocentral;

import java.util.Random;

public class Pix {
    private static final String CARACTERES = "0123456789987654321abcdefghijklmnopqrstuvwxyz";
    private static final int TAMANHO_CHAVE = 20;

    public static String gerarChavePix(){
        String chave = "";
        int ch;

        Random random = new Random();

        for(int i = 0; i < TAMANHO_CHAVE; i++){
            ch = random.nextInt(CARACTERES.length()); // sorteia um caractere da cadeia;
            chave += CARACTERES.charAt(ch);
        }
        return chave;
    }
}
