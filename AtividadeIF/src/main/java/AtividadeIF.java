import java.util.Scanner;

public class AtividadeIF {
    public static void main(String[] args) {

        Scanner n = new Scanner(System.in);
        String resposta;


        do {
            double snotas = 0;

            for (int i = 1; i <= 4; i++) {
                System.out.println("Digite a " + i + "ª nota do aluno:");
                double nota = n.nextDouble();

                while (nota < 0 || nota > 10) {
                    System.out.println("Por favor digite uma nota de 0 a 10.");
                    nota = n.nextDouble();
                }
                snotas += nota;
            }

            double media = snotas / 4;

            if (media >= 7) {
                System.out.println("O aluno teve media igual a " + media +
                        " e por isso foi aprovado.");
            } else if (media >= 5) {
                System.out.println("O aluno teve media igual a " + media +
                        " e por isso está de recuperação.");
            } else {
                System.out.println("O aluno teve media igual a " + media +
                        " e por isso foi reprovado.");
            }

            System.out.println("Deseja realizar uma nova consulta?");
            resposta = n.next();

        } while (resposta.equalsIgnoreCase("sim"));

        System.out.println("Fechando sistema de notas. Obrigado!");

        n.close();
    }
}

