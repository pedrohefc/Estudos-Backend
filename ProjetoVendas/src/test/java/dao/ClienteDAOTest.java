package dao;

import doMain.Cliente;
import exception.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteDAOTest {

    private IClienteDAO clienteDao;

    private Cliente cliente;

    public ClienteDAOTest() {
        clienteDao = new ClienteDaoMOck();
    }

    @Before
    public void init() {
        cliente = new Cliente();
        cliente.setCpf(12345678912L);
        cliente.setCidade("rj");
        cliente.setEnd("Rua Santa Alexandrina");
        cliente.setEstado("RJ");
        cliente.setNome("Pedro");
        cliente.setTel(21997743259L);
        cliente.setNumero(101);

        clienteDao.salvar(cliente);
    }

    @Test
    public void pesquisarCliente() {

        Cliente clienteConsultado = clienteDao.buscarPorCPF(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void excluirCliente() {
        clienteDao.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Pedro Costa");
        clienteDao.alterar(cliente);
    }
}
