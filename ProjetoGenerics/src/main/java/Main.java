public class Main {
    public static void main(String[] args) {

        ListaDeCarros<Carro> lista = new ListaDeCarros<>();

        lista.adicionar(new Honda("Civic"));
        lista.adicionar(new Peugeot("208"));

        lista.listar();
    }
}
