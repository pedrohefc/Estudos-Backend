public class Main {
    public static void main(String[] args) {
        int numeroPrimitivo = Integer.parseInt(args[0]);

        Integer numeroWrapper = Integer.valueOf(numeroPrimitivo);

        System.out.println("Primitivo (int): " + numeroPrimitivo);
        System.out.println("Wrapper (Integer): " + numeroWrapper);
    }
}
