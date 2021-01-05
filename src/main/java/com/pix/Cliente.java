package com.pix;

public class Cliente extends Pessoa{
    private String email;
    private String telefone;
    private String chave_aleatoria;
    private Conta conta;

    Cliente(String nome, String email,String telefone, String chaveString, Conta conta){
        super(nome);
        this.email = email;
        this.telefone = telefone;
        this.chave_aleatoria = chaveString;
        this.conta = conta;
    }
}
