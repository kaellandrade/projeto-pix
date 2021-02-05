package com.banco;

import com.gui.PixGui;
import java.util.Date;
import java.util.Locale;
import java.text.NumberFormat;

public class ContaCorrente extends Conta {

    private final Locale local = new Locale("pt", "BR");
    private final float TAXA = 0.02f;

    public ContaCorrente(String numero, float saldo, Agencia agencia) {
        super(numero, saldo, agencia);
    }

    /**
     * Recebe uma conta salário e efetua o pagamento, caso o empregado não tenha
     * recebido no mes atual
     */
    public boolean realizarPagamento(ContaSalario conta, float valor) {
        Date data = new Date();

        // TODO: Antes de depositar verificar o último pagamento;

        conta.depositar(valor);
        this.setSaldo(getSaldo() - valor); // Subtrai da conta corrente o valor pago

        // add extrato na conta salário
        conta.addExtrato(String.format("Crédito: %s\nData: %s\n", NumberFormat.getCurrencyInstance(local).format(valor),
                data.toString()));

        // add extrato na conta corrente(empregador)
        this.addExtrato(String.format("Pagamento: %s\nData: %s\nRecebedor: AG:%s CONT: %s",
                NumberFormat.getCurrencyInstance(local).format(valor), data.toString(),
                conta.getAgencia().getNumeroAgencia(), conta.getNumero()));
        return true;
    }

    /*
     * Para cada movimentação na conta esse método irá gerar uma taxa negativa de
     * 2%;
     */
    @Override
    public void gerartaxa(float valor) {
        setSaldo(getSaldo() - (valor * TAXA));
    }

    /**
     * Recebe um valor a ser sacado e verifica se o cliente possui saldo suficiente
     * na conta, além disso verifica se o valor não excede o limite de saque. Caso
     * contrário efetua o saque.
     */
    @Override
    public boolean sacar(float valor) {
        Date data = new Date();
        final float LIMITE_SAQUE_MAX = 5000;
        final float LIMITE_SAQUE_MIN = 100;
        if (valor > LIMITE_SAQUE_MAX || valor < LIMITE_SAQUE_MIN) {
            PixGui.dialogo(String.format("Limite de saque %s até %s",
                    NumberFormat.getCurrencyInstance(local).format(LIMITE_SAQUE_MIN),
                    NumberFormat.getCurrencyInstance(local).format(LIMITE_SAQUE_MAX)));
            return false;
        } else if (super.sacar(valor)) {
            gerartaxa(valor); // Efetua a cobrança da taxa
            PixGui.dialogo(String.format("Saque de R$ %.2f efetuado com sucesso.", valor));
            this.addExtrato(String.format("Saque: %s\nData: %s\nTaxa: %s",
                    NumberFormat.getCurrencyInstance(local).format(valor), data.toString(),
                    NumberFormat.getCurrencyInstance(local).format((valor * TAXA))));
            return true;
        } else {
            PixGui.dialogo("Saldo insuficiente.");
            return false;
        }
    }
}
