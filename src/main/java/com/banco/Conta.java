package com.banco;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class Conta implements Serializable {
    private String numero; // número da conta
    protected float saldo;
    private Agencia agencia; // agencia atrelada a essa conta
    private LinkedList<String> extrato = new LinkedList<String>();
    private String chavePIX;

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

    public void setConta(){
        
    }

    public String getChavePIX() {
        return chavePIX;
    }

    public LinkedList<String> getExtrato() {
        return extrato;
    }
    public void addExtrato(String msg) {
        extrato.add(0, msg);
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Inicialmente uma chave pix aleatória é null, mas pode ser setada por esse
     * método;
     */
    public void setChavePIX(String chavePIX) {
        this.chavePIX = chavePIX;
    }

    /**
     * Realiza uma transferencia interna caso duas contas sejam do mesmo banco
     */
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
        if(valor <= this.saldo){
            saldo -= valor;
            return true;
        }else{
            return false;
        }
    }

    /*
     * Gera uma determinada taxa de acordo com a conta;
     */
    public void gerartaxa(int valor) {

    };

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

}
