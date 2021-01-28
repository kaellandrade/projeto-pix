package com.pessoa;
import java.io.Serializable;

import com.banco.*;

public class Cliente extends Pessoa implements Serializable{
    private String email;
    private String telefone;
    private Conta conta;

    Cliente(String nome, String email, String telefone, Conta conta) {
        super(nome);
        this.email = email;
        this.telefone = telefone;
        this.conta = conta;
    }

    public Conta getConta() {
        return conta;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getName() {
        return super.getNome();
    }
}
