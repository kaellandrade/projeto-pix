package com.banco;

import java.util.Date;
import java.util.Locale;

import com.gui.PixGui;
import java.text.NumberFormat;

public class ContaPoupanca extends Conta {

    private final float TAXA = 0.012f;
    private final Locale local = new Locale("pt", "BR");

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
        final float LIMITE_SAQUE_MAX = 1500;
        final float LIMITE_SAQUE_MIN = 10;

        if (valor > LIMITE_SAQUE_MAX || valor < LIMITE_SAQUE_MIN) {
            PixGui.dialogo(String.format("Limite de saque %s até %s",
                    NumberFormat.getCurrencyInstance(local).format(LIMITE_SAQUE_MIN),
                    NumberFormat.getCurrencyInstance(local).format(LIMITE_SAQUE_MAX)));
            return false;
        } else if (super.sacar(valor)) {

            PixGui.dialogo(String.format("Saque de %s efetuado com sucesso.",
                    NumberFormat.getCurrencyInstance(local).format(valor)));

            this.addExtrato(String.format("Saque: %s\nData: %s", NumberFormat.getCurrencyInstance(local).format(valor),
                    data.toString()));
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
