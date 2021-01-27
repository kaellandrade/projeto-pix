package com.pessoa;
import java.io.Serializable;


public abstract class  Pessoa implements Serializable{
    private String nome;
    Pessoa(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
