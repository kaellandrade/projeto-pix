package com.pessoa;
import com.banco.*;

public class ClientePessoaJuridica extends Cliente{
    private String cnpj;

    public ClientePessoaJuridica(String nome, String email, String telefone, String chaveString, Conta conta, String cnpj) {
        super(nome, email, telefone, chaveString, conta);
        this.cnpj = cnpj;
    }
    @Override
    public String toString() {

        return String.format(
                "\nNome: %s\nE-mail: %s\nTelefone: %s\nChave Pix: %s\nCNPJ: %s\n\n*Conta*\nNúmero: %s\nSaldo: %.2fR$\n\nAgencia: %s\n\n*Banco*\nCódigo: %s\nNome: %s\n\n",
                this.getName(), this.getEmail(), this.getTelefone(), this.getChaveAleatoria(), this.cnpj,
                getConta().getNumero(), getConta().getSaldo(), getConta().getAgencia().getNumeroAgencia(),
                getConta().getAgencia().getBanco().getCodigoBanco(), getConta().getAgencia().getBanco().getNomeBanco());
    }
}
