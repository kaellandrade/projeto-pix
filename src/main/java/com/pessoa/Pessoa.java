package com.pessoa;

public abstract class  Pessoa{
    private String nome;
    Pessoa(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
