package dao;

import doMain.Cliente;
import generics.GenericDAO;

public class ClienteDAO extends GenericDAO<Cliente> implements IClienteDAO {
    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualiarDados(Cliente entity, Cliente entityCadastrado) {

    }

    public ClienteDAO() {
        super();
    }

    @Override
    public Cliente buscarPorCPF(Long cpf) {
        return null;
    }

    @Override
    public Boolean salvar(Cliente cliente) {
        return null;
    }
}
