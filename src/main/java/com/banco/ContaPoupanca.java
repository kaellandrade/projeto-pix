package com.banco;

import java.util.Date;
import java.util.Locale;

import com.gui.PixGui;
import java.text.NumberFormat;

public class ContaPoupanca extends Conta {

    private final Locale local = new Locale("pt", "BR");
    private final float TAXA = 0.001f; // 0.1 %

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

        if (!(valor >= LIMITE_SAQUE_MIN && valor <= LIMITE_SAQUE_MAX)) { // se não estiver no intervalo retorna true
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
     * Gera uma taxa positiva de 0.1%
     */
    @Override
    public void gerartaxa(float valor) {
        setSaldo(getSaldo() + (TAXA * valor));
    }

    /**
     * Recebe um valor e efetua o depósito caso esteja no limite mínimo e máximo
     * permitido
     */
    @Override
    public boolean depositar(float valor) {
        Date data = new Date();
        final float LIMITE_DEPOS_MAX = 1000;
        final float LIMITE_DEPOS_MIN = 10;

        if (valor >= LIMITE_DEPOS_MIN && valor <= LIMITE_DEPOS_MAX) {
            
            super.depositar(valor);
            gerartaxa(valor);
            this.addExtrato(String.format("Depósito: %s\nData: %s \nRendimento: %s",
            NumberFormat.getCurrencyInstance(local).format(valor), data.toLocaleString(), (TAXA*valor)));
            PixGui.dialogo(String.format("Depósito de R$ %.2f efetuado com sucesso.", valor));

            return true;

        } else {
            PixGui.dialogo(String.format("Limite de depósito %s até %s",
                    NumberFormat.getCurrencyInstance(local).format(LIMITE_DEPOS_MIN),
                    NumberFormat.getCurrencyInstance(local).format(LIMITE_DEPOS_MAX)));
            
            return false;
        }
    }

}
