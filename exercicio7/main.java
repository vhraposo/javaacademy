package exercicio7;

public class main {
    public static void main(String[] args) {
        ContaCorrente novaConta = new ContaCorrente();

        novaConta.depositar(2000);
        novaConta.sacar(800);
        novaConta.sacar(1500);

        System.out.println("O saldo é: R$" + novaConta.getSaldo());
    }
}

