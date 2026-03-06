package Reflection;

public class Main {

    public static void main(String[] args) {

        Class<Cliente> classe = Cliente.class;

        if (classe.isAnnotationPresent(Tabela.class)) {

            Tabela tabela = classe.getAnnotation(Tabela.class);

            System.out.println("Nome da tabela: " + tabela.value());

        }
    }
}
