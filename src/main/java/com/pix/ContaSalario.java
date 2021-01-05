package com.pix;

public class ContaSalario extends Conta{

    ContaSalario(String titular, String numero, float saldo, Agencia agencia) {
        super(titular, numero, saldo, agencia);
    }

    @Override
    public void setSaldo(float saldo) {
        super.setSaldo(saldo);
    }
    public boolean verificarOperacaoMensal(){
        return true;
    }
}
