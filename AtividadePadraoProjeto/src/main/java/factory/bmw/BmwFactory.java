package factory.bmw;

import factory.interfaces.CarroDeLuxo;
import factory.interfaces.CarroPopular;
import factory.interfaces.FabricaDeCarros;

public class BmwFactory implements FabricaDeCarros {

    public CarroPopular criarCarroPopular() {
        return new BmwPopular();
    }

    public CarroDeLuxo criarCarroLuxo() {
        return new BmwLuxo();
    }
}
