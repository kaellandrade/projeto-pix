package com.banco;

public class Agencia {
    private  String numeroAgencia;
    private Banco banco;

    public Agencia(String numeroAgencia, Banco banco){
        this.numeroAgencia = numeroAgencia;
        this.banco = banco;
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
