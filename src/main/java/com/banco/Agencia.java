package com.banco;

import java.io.Serializable;

public class Agencia implements Serializable {
    private String numeroAgencia;
    private Banco banco;

    public Agencia(String numeroAgencia, Banco banco) {
        this.numeroAgencia = numeroAgencia;
        this.banco = banco;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public Banco getBanco() {
        return banco;
    }
}
