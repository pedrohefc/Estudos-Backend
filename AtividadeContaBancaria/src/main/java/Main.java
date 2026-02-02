public class Main {

    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria(1000.00);
        conta.saque(300);
        double restante = conta.consultaSaldo();

        System.out.printf("Estou querendo comprar um curso novo.%n" +
                "Para isso saquei R$300.00%n" +
                "e me sobrou um valor de R$%.2f para gastar.", restante);
    }
}
