package com.pix;

public class Agencia {
    private String nomeBanco;
    private String numeroAgencia;

    private Banco banco;

    public String getNomeBanco() {
        return nomeBanco;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public Banco getBanco() {
        return banco;
    }
}
