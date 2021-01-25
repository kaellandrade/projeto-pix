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

    public void setCodigoBanco(String codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    @Override
    public String toString() {
        return String.format("Codigo: %s\nNome: %s", this.getCodigoBanco(), this.getNomeBanco());
    }
}
