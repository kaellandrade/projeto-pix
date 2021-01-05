package com.pix;

public class ContaCorrente extends Conta{

    ContaCorrente(String titular, String numero, float saldo, Agencia agencia){
        super(titular, numero, saldo, agencia);
    }

    @Override
    public void setSaldo(float saldo) {
        super.setSaldo(saldo);
    }

    @Override
    public void gerartaxa() {
        // Lógica para manutenção da Conta Corrente
    }
}
