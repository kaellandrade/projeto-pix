package com.banco;

import com.gui.PixGui;
import com.pessoa.ClientePessoaFisica;

import java.util.Date;
import java.util.Locale;

import java.lang.ClassCastException;
import java.text.NumberFormat;

public class ContaCorrente extends Conta {

    private final Locale local = new Locale("pt", "BR");
    private final float TAXA = 0.02f;

    public ContaCorrente(String numero, float saldo, Agencia agencia) {
        super(numero, saldo, agencia);
    }

    /**
     * Recebe uma pessoa Física e efetua o pagamento caso a conta seja contaSalário
     */
    public boolean realizarPagamento(ClientePessoaFisica funcionario, float valor) {
        Date data = new Date();
        try {
            ContaSalario cs = (ContaSalario) funcionario.getConta();

            // TODO: Antes de depositar verificar o último pagamento;

            cs.depositar(valor);
            this.setSaldo(getSaldo() - valor); // Subtrai da conta corrente o valor pago

            // add extrato na conta salário(funcionário)
            cs.addExtrato(String.format("Crédito: %s\nData: %s\n",
                    NumberFormat.getCurrencyInstance(local).format(valor), data.toLocaleString()));

            // add extrato na conta corrente(empregador)
            this.addExtrato(String.format("Pagamento: %s\nData: %s\nBeneficiário: %s",
                    NumberFormat.getCurrencyInstance(local).format(valor), data.toLocaleString(),
                    funcionario.getName()));

        } catch (ClassCastException e) {
            System.out.println("Permitido apenas conta salário para essa operação");
            return false;
        }
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
        if (!(valor >= LIMITE_SAQUE_MIN && valor <= LIMITE_SAQUE_MAX)) { // se não estiver no intervalo retorna true
            PixGui.dialogo(String.format("Limite de saque %s até %s",
                    NumberFormat.getCurrencyInstance(local).format(LIMITE_SAQUE_MIN),
                    NumberFormat.getCurrencyInstance(local).format(LIMITE_SAQUE_MAX)));
            return false;
        } else if (super.sacar(valor)) {
            gerartaxa(valor); // Efetua a cobrança da taxa
            PixGui.dialogo(String.format("Saque de R$ %.2f efetuado com sucesso.", valor));
            this.addExtrato(String.format("Saque: %s\nData: %s\nTaxa: %s",
                    NumberFormat.getCurrencyInstance(local).format(valor), data.toLocaleString(),
                    NumberFormat.getCurrencyInstance(local).format((valor * TAXA))));
            return true;
        } else {
            PixGui.dialogo("Saldo insuficiente.");
            return false;
        }
    }

    /**
     * Recebe um valor e efetua o depósito caso esteja no limite mínimo e máximo
     * permitido
     */
    @Override
    public boolean depositar(float valor) {
        Date data = new Date();
        final float LIMITE_DEPOS_MAX = 10000;
        final float LIMITE_DEPOS_MIN = 100;

        if (valor >= LIMITE_DEPOS_MIN && valor <= LIMITE_DEPOS_MAX) {
            super.depositar(valor);
            this.addExtrato(String.format("Depósito: %s\nData: %s",
                    NumberFormat.getCurrencyInstance(local).format(valor), data.toLocaleString()));
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
