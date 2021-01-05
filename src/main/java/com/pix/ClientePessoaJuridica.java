package com.pix;

public class ClientePessoaJuridica extends Cliente{
    private String cnpj;

    ClientePessoaJuridica(String nomeFantasia, String email, String telefone, String chaveString, Conta conta, String cnpj) {
        super(nomeFantasia, email, telefone, chaveString, conta);
        this.cnpj = cnpj;
    }
}
