import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite as pessoas no formato Nome-Sexo separadas por vírgula:");
        System.out.println("Exemplo: Maria-F,Joao-M,Ana-F,Carlos-M");

        String entrada = scanner.nextLine();

        List<String> mulheres = PessoaService.filtrarMulheres(entrada);

        System.out.println("\nLista de mulheres:");

        mulheres.forEach(System.out::println);

        scanner.close();
    }
}