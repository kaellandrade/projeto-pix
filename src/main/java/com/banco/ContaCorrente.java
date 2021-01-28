package com.banco;

public class ContaCorrente extends Conta{
    
    private final float TAXA = 0.02f;
    
    public ContaCorrente(String numero, float saldo, Agencia agencia){
        super(numero, saldo, agencia);
    }

    public boolean realizarPagamento(ContaSalario conta){
        // Implementar...
        return true;
    }

    @Override
    public void gerartaxa() {
        // Implementar...
    }
}
