package com.bancocentral;

import org.junit.Assert;
import org.junit.Test;

/**
 * Teste para métodos da classe Pix
 */
public class TestePix {

    // Verifica se a chave gerada contém 20 caracteres.
    @Test
    public void tamanhoChavePixValida(){
        Assert.assertEquals("Chave com tamanho 20",20, Pix.gerarChavePix().length());
    }

    // Verifica se as chaves geradas contém apenas caracteres alfanuméricos;
    @Test
    public void chaveAlfanumerico(){
        String chavePix = Pix.gerarChavePix();
        Assert.assertTrue(chavePix.matches("[a-z0-9]+")); // retorna true se a chave for alfanumérica.
    }
}
