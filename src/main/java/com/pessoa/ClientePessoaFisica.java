package com.pessoa;
import com.banco.*;

public class ClientePessoaFisica extends Cliente {
    private String cpf;

    public ClientePessoaFisica(String nome, String email, String telefone, Conta conta, String cpf) {
        super(nome, email, telefone, conta);
        this.cpf = cpf;
    }
    public String getCpf() {
        return cpf;
    }
}
