package service;

import dao.IClienteDAO;
import doMain.Cliente;
import exception.TipoChaveNaoEncontradaException;

public class ClienteService implements IClienteService {

    private final IClienteDAO clienteDAO;

    public ClienteService(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public Boolean salvar(Cliente cliente) {
        return clienteDAO.salvar(cliente);
    }

    @Override
    public Cliente buscarPorCPF(Long cpf) {
        return clienteDAO.buscarPorCPF(cpf);
    }

    @Override
    public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        clienteDAO.alterar(cliente);
    }

    @Override
    public void excluir(Cliente cliente) {

    }
}
