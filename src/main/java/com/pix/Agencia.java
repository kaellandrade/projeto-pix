package com.pix;

public class Agencia {
    protected  String nomeBanco ;
    protected  String numeroAgencia;

    protected Banco banco;

    public String getNomeBanco() {
        return nomeBanco;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }
}
