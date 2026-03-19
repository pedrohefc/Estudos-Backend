package service;

import doMain.Cliente;
import exception.TipoChaveNaoEncontradaException;

public interface IClienteService {
    Boolean salvar(Cliente cliente);

    Cliente buscarPorCPF(Long cpf);

    void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

    void excluir(Cliente cliente);
}
