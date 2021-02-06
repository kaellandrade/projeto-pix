package com.banco;
import java.io.Serializable;

public class Banco implements Serializable{
    private String codigoBanco;
    private String nomeBanco;

    public Banco(String codigoBanco, String nomeBanco) {
        this.codigoBanco = codigoBanco;
        this.nomeBanco = nomeBanco;
    }

    public String getCodigoBanco() {
        return codigoBanco;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }
}
