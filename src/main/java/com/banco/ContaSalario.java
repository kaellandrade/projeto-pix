package com.banco;

public class ContaSalario extends Conta {

    private String ultimoPagamentoMES;

    public ContaSalario(String numero, float saldo, Agencia agencia) {
        super(numero, saldo, agencia);
    }

    public String getUltimoPagamentoMES() {
        return ultimoPagamentoMES;
    }

    public void setUltimoPagamentoMES(String ultimoPagamentoMES) {
        this.ultimoPagamentoMES = ultimoPagamentoMES;
    }

}
