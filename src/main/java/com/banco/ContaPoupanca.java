package com.banco;

import java.util.Date;
import com.gui.PixGui;

public class ContaPoupanca extends Conta {

    private final float TAXA = 0.012f;

    public ContaPoupanca(String numero, float saldo, Agencia agencia) {
        super(numero, saldo, agencia);
    }

    /**
     * Recebe um valor a ser sacado e verifica se o cliente possui saldo suficiente
     * na conta, além disso verifica se o valor não excede o limite de saque. Caso
     * contrário efetua o saque.
     */
    @Override
    public boolean sacar(float valor) {
        Date data = new Date();
        final float LIMITE_SAQUE = 1500;
        if (valor > LIMITE_SAQUE) {
            PixGui.dialogo(String.format("Limite de saque R$ %.2f", LIMITE_SAQUE));
            return false;
        } else if (super.sacar(valor)) {
            PixGui.dialogo(String.format("Saque de R$ %.2f efetuado com sucesso.", valor));
            this.addExtrato(String.format("Saque: R$ %.2f\nData: %s", valor, data.toString()));
            return true;
        } else {
            PixGui.dialogo("Saldo insuficiente.");
            return false;
        }
    }

    /**
     * Gera uma taxa positiva de 1.2%
     */
    @Override
    public void gerartaxa(float valor) {
        // Implementar...
    }

}
