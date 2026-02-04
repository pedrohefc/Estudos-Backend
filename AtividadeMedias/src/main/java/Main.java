public class Main {

    public static void main(String[] args) {
        String aluno = "Ruan";

        System.out.println("        BOLETIM ESCOLAR");
        System.out.println("================================");
        System.out.println("Aluno: " + aluno);
        System.out.println("Média final: " + media());
        System.out.println("================================");
    }

    public static double media() {
        int n1 = 9;
        int n2 = 10;
        int n3 = 1;
        int n4 = 6;
        return (double) (n1 + n2 + n3 + n4) / 4;
    }
}
