class Honda extends Carro {

    public Honda(String modelo) {
        super(modelo);
    }

    @Override
    public void acelerar() {
        System.out.println("Honda acelerando...");
    }
}