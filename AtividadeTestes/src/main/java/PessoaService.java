import java.util.ArrayList;
import java.util.List;

public class PessoaService {

    public static List<String> filtrarMulheres(String entrada) {

        String[] pessoas = entrada.split(",");

        List<String> mulheres = new ArrayList<>();

        for (String pessoa : pessoas) {

            String[] dados = pessoa.split("-");

            String nome = dados[0].trim();
            String sexo = dados[1].trim();

            if (sexo.equalsIgnoreCase("F")) {
                mulheres.add(nome);
            }
        }

        return mulheres;
    }
}