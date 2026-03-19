package dao;

import doMain.Cliente;
import exception.TipoChaveNaoEncontradaException;
import generics.IGenericDAO;

public interface IClienteDAO extends IGenericDAO<Cliente> {
    Cliente buscarPorCPF(Long cpf);

    Boolean salvar(Cliente cliente);

    void excluir(Long cpf);

    void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;
}
