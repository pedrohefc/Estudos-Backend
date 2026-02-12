import java.util.*;

public class SegundaTarefa {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite no formato Nome-Sexo separados por vírgula (ex: Pedro-M, Ana-F):");
        String entrada = scanner.nextLine();

        String[] pessoasArray = entrada.split(",");

        List<String> masculino = new ArrayList<>();
        List<String> feminino = new ArrayList<>();

        for (String pessoa : pessoasArray) {
            pessoa = pessoa.trim();
            String[] partes = pessoa.split("-");

            String nome = partes[0].trim();
            String sexo = partes[1].trim().toUpperCase();

            if (sexo.equals("M")) {
                masculino.add(nome);
            } else if (sexo.equals("F")) {
                feminino.add(nome);
            }
        }

        Collections.sort(masculino);
        Collections.sort(feminino);

        System.out.println("Masculino:");
        for (String nome : masculino) {
            System.out.println(nome);
        }

        System.out.println("Feminino:");
        for (String nome : feminino) {
            System.out.println(nome);
        }

        scanner.close();
    }
}
