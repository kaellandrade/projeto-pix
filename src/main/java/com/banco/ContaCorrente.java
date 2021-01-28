package com.banco;

public class ContaCorrente extends Conta {

    private final float TAXA = 0.02f;

    public ContaCorrente(String numero, float saldo, Agencia agencia) {
        super(numero, saldo, agencia);
    }

    /**
     * Recebe uma conta salário e efetua o pagamento, caso o empregado não tenha recebido
     * no mes atual
     */
    public boolean realizarPagamento(ContaSalario conta) {
        // Implementar...
        return true;
    }

    /*
     * Para cada movimentação na conta esse método irá gerar uma taxa negativa de 2%;
     */
    @Override
    public void gerartaxa() {
        // Implementar...
    }

    public boolean sacar(float valor) {
        final float LIMITE_SAQUE = 5000;
        if(valor > LIMITE_SAQUE){
            System.out.println("Limite de saque excedido");
        }
        if(valor <= getSaldo() && valor <= LIMITE_SAQUE){
            saldo -= valor;
            return true;
        }else{
            return false;
        }
    }
}
