package dao;

public class ClienteDao implements IClienteDao {

    @Override
    public String salvar() {
        throw new UnsupportedOperationException("não funciona sem config de banco");
    }

    @Override
    public String buscar() {
        throw new UnsupportedOperationException("não funciona sem config de banco");
    }

    @Override
    public String excluir() {
        throw new UnsupportedOperationException("não funciona sem config de banco");
    }

    @Override
    public String atualizar() {
        throw new UnsupportedOperationException("não funciona sem config de banco");
    }
}
