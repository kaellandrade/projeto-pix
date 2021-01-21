package com.banco;

public class ContaSalario extends Conta {

    public ContaSalario(String numero, float saldo, Agencia agencia) {
        super(numero, saldo, agencia);
    }

    @Override
    public void setSaldo(float saldo) {
        super.setSaldo(saldo);
    }

    public boolean verificarOperacaoMensal() {
        return true;
    }
}
