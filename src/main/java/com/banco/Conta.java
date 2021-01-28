package com.banco;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Conta implements Serializable{
    private String numero;
    private float saldo;
    private Agencia agencia;
    private ArrayList <String> extrato = new ArrayList<String>();

    Conta(String numero, float saldo, Agencia agencia) {
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

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean realizarTransferenciaInterna(String numeroConta, String agencia, float valor) {
        // Implementar...
        return true;
    }

    public boolean fazerPix(String chavePix, float valor) {
        // Implementar...
        return true;
    }

    public boolean depositar(float valor) {
        saldo += valor;
        return true;
    }

    public boolean sacar(float valor) {
        saldo-=valor;
        return true;
    }

    public abstract void gerartaxa();

    public ArrayList <String> getExtrato(){
        return extrato;
    }

    /**
     * Realiza transferência para uma determinada conta;
     */
    public boolean transferir(Conta conta, float valor) {
        if (this.getSaldo() >= valor) {// Se possuir valor suficiente na conta;
            conta.depositar(valor); // transfere o dinheiro
            this.sacar(valor); // retira o valor transferido
            return true;
        }
        return false;
    }

    public Agencia getAgencia() {
        return agencia;
    }
}
