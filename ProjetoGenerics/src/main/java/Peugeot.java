class Peugeot extends Carro {

    public Peugeot(String modelo) {
        super(modelo);
    }

    @Override
    public void acelerar() {
        System.out.println("Peugeot acelerando...");
    }
}