package com.banco;

import com.gui.PixGui;

public class ContaCorrente extends Conta {

    private final float TAXA = 0.02f;

    public ContaCorrente(String numero, float saldo, Agencia agencia) {
        super(numero, saldo, agencia);
    }

    /**
     * Recebe uma conta salário e efetua o pagamento, caso o empregado não tenha
     * recebido no mes atual
     */
    public boolean realizarPagamento(ContaSalario conta) {
        // Implementar...
        return true;
    }

    /*
     * Para cada movimentação na conta esse método irá gerar uma taxa negativa de
     * 2%;
     */
    @Override
    public void gerartaxa() {
        // Implementar...
    }

    @Override
    public boolean sacar(float valor) {
        final float LIMITE_SAQUE = 5000;
        if (valor > LIMITE_SAQUE) {
            PixGui.dialogo(String.format("Limite de saque R$ %.2f", LIMITE_SAQUE));
            return false;
        } else if (super.sacar(valor)) {
            PixGui.dialogo(String.format("Saque de R$ %.2f efetuado com sucesso.", valor));
            return true;
        } else {
            PixGui.dialogo("Saldo insuficiente.");
            return false;
        }
    }
}
