package com.banco;

import java.io.Serializable;
import java.util.Date;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;

import com.gui.*;

import com.pessoa.Cliente;

public class Conta implements Serializable {
    private String numero; // número da conta
    protected float saldo;
    private Agencia agencia; // agencia atrelada a essa conta
    private LinkedList<String> extrato = new LinkedList<String>();
    private String chavePIX = "";
    private final Locale local = new Locale("pt", "BR");

    Conta(String numero, float saldo, Agencia agencia) {
        this.numero = numero;
        this.saldo = saldo;
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float valor) {
        this.saldo = valor;
    }

    public String getChavePIX() {
        return chavePIX;
    }

    public LinkedList<String> getExtrato() {
        return extrato;
    }

    /**
     * Recebe uma mensagem com detalhes da operação efetuada na conta e adiciona na
     * cabeça da lista encadeada a últma movimentação
     */
    public void addExtrato(String msg) {
        extrato.add(0, msg);
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Inicialmente uma chave pix aleatória é vazia, mas pode ser setada por esse
     * método;
     */
    public void setChavePIX(String chavePIX) {
        this.chavePIX = chavePIX;
    }

    /**
     * Realiza uma transferencia interna caso duas contas sejam do mesmo banco
     */
    public boolean realizarTransferenciaInterna(Cliente cli, float valor) {
        Date data = new Date();
        // Destinatário
        Conta conta_destino = cli.getConta();
        String codigo_banco_destino = cli.getConta().getAgencia().getBanco().getCodigoBanco();

        // Remetente
        String codigo_banco_atual = this.getAgencia().getBanco().getCodigoBanco();

        if (codigo_banco_atual.equals(codigo_banco_destino)) { // caso seja do mesmo banco
            if (this.getSaldo() >= valor) { // caso haja saldo suficiente
                conta_destino.setSaldo(conta_destino.getSaldo() + valor);
                ; // realiza o depósito;
                this.setSaldo(getSaldo() - valor); // atualiza o saldo;
                PixGui.dialogo(
                        String.format("Transferência de %.2f realizada com sucesso para %s", valor, cli.getName()));

                // Atualiza extrato conta atual
                this.addExtrato(String.format("Transferencia Interna: %s\nData: %s\nConta Destino: %s",
                        NumberFormat.getCurrencyInstance(local).format(valor), data.toLocaleString(),
                        conta_destino.getNumero()));

                // Atualiza extrato conta destino
                conta_destino.addExtrato(String.format("Depósito: %s\nData: %s\nConta Remetente: %s",
                        NumberFormat.getCurrencyInstance(local).format(valor), data.toLocaleString(),
                        this.getNumero()));
            } else {
                PixGui.dialogo(String.format("Saldo insuficiente."));
                return false;
            }
        } else {
            PixGui.dialogo(String.format("Operação não permitida, bancos diferentes."));
            return false;
        }
        return true;
    }

    /**
     * Realiza um pix para um determinado cliente passada como parâmetro;
     */
    public boolean fazerPix(Cliente cli, float valor) {
        Date data = new Date();
        Conta conta_destino = cli.getConta();

        if (this.getSaldo() >= valor) {
            conta_destino.setSaldo(valor + conta_destino.getSaldo());

            this.setSaldo(this.getSaldo() - valor);
            this.addExtrato(String.format("PIX enviado: %s\nData: %s\nPara: %s", NumberFormat.getCurrencyInstance(local).format(valor), data.toLocaleString(), cli.getName()));
            conta_destino.addExtrato(String.format("PIX recebido: %s\nData: %s",NumberFormat.getCurrencyInstance(local).format(valor), data.toLocaleString()));
            return true;
        }
        return false;
    }

    public boolean depositar(float valor) {
        saldo += valor;
        return true;
    }

    public boolean sacar(float valor) {
        if (valor <= this.saldo) {
            saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    /*
     * Gera uma determinada taxa de acordo com a conta;
     */
    public void gerartaxa(float valor) {

    };

}
