package factory.bmw;

import factory.interfaces.CarroPopular;

public class BmwPopular implements CarroPopular {

    @Override
    public void exibirInfo() {
        System.out.println("Carro Popular BMW");
    }
}
