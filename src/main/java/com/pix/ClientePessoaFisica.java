package com.pix;

public class ClientePessoaFisica extends Cliente {
    private String cpf;
    private String dataNascimento;

    ClientePessoaFisica(String nome, String email, String telefone, String chaveString, Conta conta, String cpf,
            String dataNascimento) {
        super(nome, email, telefone, chaveString, conta);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;

    }
}
