import java.util.*;

public class PrimeiraTarefa {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os nomes separados por vírgula:");
        String entrada = scanner.nextLine();

        String[] nomesArray = entrada.split(",");

        List<String> nomes = new ArrayList<>();

        for (String nome : nomesArray) {
            nomes.add(nome.trim());
        }

        Collections.sort(nomes);

        System.out.println("Lista ordenada:");
        for (String nome : nomes) {
            System.out.println(nome);
        }

        scanner.close();
    }
}