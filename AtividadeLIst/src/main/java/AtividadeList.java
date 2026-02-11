import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AtividadeList {
    public static void main(String[] args) {

        Scanner n = new Scanner(System.in);

        String resposta;
        String sexo;
        boolean sexoValido;

        List<String> masculino = new ArrayList<>();
        List<String> feminino = new ArrayList<>();

        do {
            System.out.println("Digite um nome:");
            String nome = n.next();

            do {
                System.out.println("Digite o Sexo (m ou f):");
                sexo = n.next();

                sexoValido = sexo.equalsIgnoreCase("m") ||
                        sexo.equalsIgnoreCase("f");

                if (!sexoValido) {
                    System.out.println("Por gentileza, escolha 'm' para " +
                            "masculino e 'f' para feminino");
                }
            } while (!sexoValido);

            System.out.println("Deseja cadastrar outra pessoa?");
            resposta = n.next();

            if (sexo.equalsIgnoreCase("m")) {
                masculino.add(nome);
            } else {
                feminino.add(nome);
            }

        } while (resposta.equalsIgnoreCase("sim"));

        System.out.println("================");
        System.out.println("Lista de homens");
        System.out.println(masculino);
        System.out.println("================");
        System.out.println("Lista de mulheres");
        System.out.println(feminino);
        System.out.println("================");
    }
}
