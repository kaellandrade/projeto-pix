package com.banco;

public class ContaCorrente extends Conta{

    public ContaCorrente(String numero, float saldo, Agencia agencia){
        super(numero, saldo, agencia);
    }

    @Override
    public void setSaldo(float saldo) {
        super.setSaldo(saldo);
    }

    @Override
    public void gerartaxa() {
        // Implementar...
    }
}
