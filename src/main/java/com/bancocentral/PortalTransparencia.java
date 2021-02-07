package com.bancocentral;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.backend.LerClientesSerializados;
import com.banco.Banco;
import com.banco.Conta;
import com.banco.ContaCorrente;
import com.banco.ContaPoupanca;
import com.banco.ContaSalario;
import com.pessoa.Cliente;

public class PortalTransparencia {
    // codigos dos bancos
    private final String BANCO_BRASIL = "001";
    private final String BANCO_ITAU = "003";
    private final String BANCO_SANTANDER = "004";
    private final String BANCO_BRADESCO = "002";

    private Collection<Cliente> todos_clientes;

    private ArrayList<Conta> todasContasBrasil = new ArrayList<Conta>();
    private ArrayList<Conta> todasContasItau = new ArrayList<Conta>();
    private ArrayList<Conta> todasContasSantander = new ArrayList<Conta>();
    private ArrayList<Conta> todasContasBradesco = new ArrayList<Conta>();

    public PortalTransparencia() {
        // Início Captura a data base
        LerClientesSerializados.abreArquivo();
        todos_clientes = LerClientesSerializados.lerClientes().values();
        LerClientesSerializados.fecharArquivo();
        // Fim Captura a data base
        lerContas();

    }

    private void lerContas() {
        for (Cliente cliente : todos_clientes) {
            Banco banco = cliente.getConta().getAgencia().getBanco();
            Conta conta = cliente.getConta();
            if (BANCO_BRASIL.equals(banco.getCodigoBanco()))
                todasContasBrasil.add(conta);

            if (BANCO_ITAU.equals(banco.getCodigoBanco()))
                todasContasItau.add(conta);

            if (BANCO_SANTANDER.equals(banco.getCodigoBanco()))
                todasContasSantander.add(conta);

            if (BANCO_BRADESCO.equals(banco.getCodigoBanco()))
                todasContasBradesco.add(conta);

        }
    }

    /**
     * Calcula o montante aplicado no banco Itau para todas as contas
     */
    public Map<String, Float> calcularMontanteItau() {
        Map<String, Float> contas = new HashMap<>();
        contas.put("poupanca", 0f);
        contas.put("salario", 0f);
        contas.put("corrente", 0f);

        for (Conta conta : todasContasItau) {
            if (conta instanceof ContaPoupanca) {
                contas.put("poupanca", contas.get("poupanca") + conta.getSaldo());
            }
            if (conta instanceof ContaSalario) {
                contas.put("salario", contas.get("salario") + conta.getSaldo());
            }
            if (conta instanceof ContaCorrente) {
                contas.put("corrente", contas.get("corrente") + conta.getSaldo());
            }
        }
        return contas;
    }

    /**
     * Calcula o montante aplicado no banco Brasil para todas as contas
     */
    public Map<String, Float> calcularMontanteBrasil() {
        Map<String, Float> contas = new HashMap<>();
        contas.put("poupanca", 0f);
        contas.put("salario", 0f);
        contas.put("corrente", 0f);

        for (Conta conta : todasContasBrasil) {
            if (conta instanceof ContaPoupanca) {
                contas.put("poupanca", contas.get("poupanca") + conta.getSaldo());
            }
            if (conta instanceof ContaSalario) {
                contas.put("salario", contas.get("salario") + conta.getSaldo());
            }
            if (conta instanceof ContaCorrente) {
                contas.put("corrente", contas.get("corrente") + conta.getSaldo());
            }
        }
        return contas;
    }

    /**
     * Calcula o montante aplicado no banco Bradesco para todas as contas
     */
    public Map<String, Float> calcularMontanBradesco() {
        Map<String, Float> contas = new HashMap<>();
        contas.put("poupanca", 0f);
        contas.put("salario", 0f);
        contas.put("corrente", 0f);

        for (Conta conta : todasContasBradesco) {
            if (conta instanceof ContaPoupanca) {
                contas.put("poupanca", contas.get("poupanca") + conta.getSaldo());
            }
            if (conta instanceof ContaSalario) {
                contas.put("salario", contas.get("salario") + conta.getSaldo());
            }
            if (conta instanceof ContaCorrente) {
                contas.put("corrente", contas.get("corrente") + conta.getSaldo());
            }
        }
        return contas;
    }

    /**
     * Calcula o montante aplicado no banco Bradesco para todas as contas
     */
    public Map<String, Float> calcularMontanSantander() {
        Map<String, Float> contas = new HashMap<>();
        contas.put("poupanca", 0f);
        contas.put("salario", 0f);
        contas.put("corrente", 0f);

        for (Conta conta : todasContasSantander) {
            if (conta instanceof ContaPoupanca) {
                contas.put("poupanca", contas.get("poupanca") + conta.getSaldo());
                
            }
            if (conta instanceof ContaSalario) {
                contas.put("salario", contas.get("salario") + conta.getSaldo());
            }
            if (conta instanceof ContaCorrente) {
                contas.put("corrente", contas.get("corrente") + conta.getSaldo());
            }
        }
        return contas;
    }
}
