package factory.toyota;

import factory.interfaces.CarroDeLuxo;
import factory.interfaces.CarroPopular;
import factory.interfaces.FabricaDeCarros;

public class ToyotaFactory implements FabricaDeCarros {

    public CarroPopular criarCarroPopular() {
        return new ToyotaPopular();
    }

    public CarroDeLuxo criarCarroLuxo() {
        return new ToyotaLuxo();
    }
}
