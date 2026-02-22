package factory;

import factory.interfaces.CarroDeLuxo;
import factory.interfaces.CarroPopular;
import factory.interfaces.FabricaDeCarros;
import factory.toyota.ToyotaFactory;

public class Main {

    public static void main(String[] args) {

        FabricaDeCarros fabrica = new ToyotaFactory();

        CarroPopular popular = fabrica.criarCarroPopular();
        CarroDeLuxo luxo = fabrica.criarCarroLuxo();

        popular.exibirInfo();
        luxo.exibirInfo();
    }
}
