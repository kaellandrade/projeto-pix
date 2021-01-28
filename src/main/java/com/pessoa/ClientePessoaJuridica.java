package com.pessoa;
import com.banco.*;

public class ClientePessoaJuridica extends Cliente{
    private String cnpj;

    public ClientePessoaJuridica(String nome, String email, String telefone, Conta conta, String cnpj) {
        super(nome, email, telefone, conta);
        this.cnpj = cnpj;
    }
    public String getCnpj() {
        return cnpj;
    }
}
