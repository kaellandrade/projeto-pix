package com.banco;

public class ContaPoupanca extends Conta{

    private final float TAXA = 0.012f;
    
    public ContaPoupanca(String numero, float saldo, Agencia agencia) {
        super(numero, saldo, agencia);
    }

    @Override
    public void gerartaxa() {
        // Implementar...
    }

    
}
