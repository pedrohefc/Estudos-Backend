package dao;

import doMain.Cliente;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClienteDaoMOck implements IClienteDAO {

    private Map<Long, Cliente> map = new HashMap<>();

    @Override
    public Boolean cadastrar(Cliente entity) {
        map.put(entity.getCpf(), entity);
        return true;
    }

    @Override
    public void excluir(Long valor) {
        map.remove(valor);
    }

    @Override
    public void alterar(Cliente entity) {
        map.put(entity.getCpf(), entity);
    }

    @Override
    public Cliente consultar(Long valor) {
        return map.get(valor);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return map.values();
    }

    @Override
    public Cliente buscarPorCPF(Long cpf) {
        return map.get(cpf);
    }

    @Override
    public Boolean salvar(Cliente cliente) {
        map.put(cliente.getCpf(), cliente);
        return true;
    }
}
