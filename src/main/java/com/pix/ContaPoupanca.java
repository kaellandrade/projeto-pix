package com.pix;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(String numero, float saldo, Agencia agencia) {
        super(numero, saldo, agencia);
    }

    @Override
    public void setSaldo(float saldo) {
        super.setSaldo(saldo);
    }

    @Override
    public void gerartaxa() {
        // Lógica para Conta Poucança
    }
}
