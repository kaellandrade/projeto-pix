package com.banco;

public class ContaSalario extends Conta {

    private String ultimoPagamentoMes; // armazena o último mês do pagamento;

    public ContaSalario(String numero, float saldo, Agencia agencia) {
        super(numero, saldo, agencia);
    }

    public String getUltimoPagamentoMES() {
        return ultimoPagamentoMes;
    }

    public void setUltimoPagamentoMES(String ultimoPagamentoMes) {
        this.ultimoPagamentoMes = ultimoPagamentoMes;
    }
    
}
