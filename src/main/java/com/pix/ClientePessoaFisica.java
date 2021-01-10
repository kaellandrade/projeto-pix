package com.pix;
import com.bancocentral.Pix;

public class ClientePessoaFisica extends Cliente {
    private String cpf;

    public ClientePessoaFisica(String nome, String email, String telefone, String chaveString, Conta conta, String cpf) {
        super(nome, email, telefone, chaveString, conta);
        this.cpf = cpf;
    }

    @Override
    public String toString() {

        return String.format(
                "\nNome: %s\nE-mail: %s\nTelefone: %s\nChave Pix: %s\nCPF: %s\n\n*Conta*\nNúmero: %s\nSaldo: %.2fR$\n\nAgencia: %s\n\n*Banco*\nCódigo: %s\nNome: %s\n\n",
                this.getName(), this.getEmail(), this.getTelefone(), this.getChaveAleatoria(), this.cpf,
                getConta().getNumero(), getConta().getSaldo(), getConta().getAgencia().getNumeroAgencia(),
                getConta().getAgencia().getBanco().getCodigoBanco(), getConta().getAgencia().getBanco().getNomeBanco());
    }
}
