/**
 * Classe que representa uma conta bancária do mundo real.
 * Ela possui informações básicas como saldo e status da conta,
 * além de métodos para depositar, sacar e consultar saldo.
 */
public class ContaBancaria {

    // Propriedades da conta
    private double saldo;
    private boolean ativa;

    // Constructor
    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
        this.ativa = true;
    }

    // Metodo para depositar dinheiro na conta
    public void depositar(double valor) {
        if (saldo > 0 && ativa) {
            saldo += valor;
        }
    }

    // Metodo para sacar dinheiro
    public void saque(double valorSaque) {
        if (saldo > 0 && ativa && valorSaque <= saldo) {
            saldo -= valorSaque;
        } else {
            System.out.println("Não foi possível sacar a quantia de R$"
            + valorSaque);
        }
    }

    //Metodo consultar saldo
    public double consultaSaldo() {
        return saldo;
    }

    //Metodo para desativar a conta
    public void desativarConta() {
        ativa = false;
    }
}
