package dao;

public class ClienteDaoMock implements IClienteDao {

    @Override
    public String salvar() {
        return "Sucesso";
    }

    @Override
    public String buscar() {
        return "Cliente encontrado";
    }

    @Override
    public String excluir() {
        return "Cliente excluído";
    }

    @Override
    public String atualizar() {
        return "Cliente atualizado";
    }
}
