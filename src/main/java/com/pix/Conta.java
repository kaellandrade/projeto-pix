package com.pix;

public class Conta {
    private String numero;
    private float saldo;
    private Agencia agencia;

    Conta(String numero, float saldo, Agencia agencia){
        this.numero = numero;
        this.saldo = saldo;
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean realizarTransferenciaInterna(String numeroConta, String agencia, float valor){
        return true;
    }
    public boolean fazerPix(String chavePix, float valor){
        return true;
    }

    public boolean depositar(float valor){
        this.saldo+=valor;
        return true;
    }

    public void gerartaxa(){ // genérico

    }

    public Agencia getAgencia() {
        return agencia;
    }
}
