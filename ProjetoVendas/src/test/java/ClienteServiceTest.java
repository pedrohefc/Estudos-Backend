import dao.ClienteDaoMOck;
import dao.IClienteDAO;
import doMain.Cliente;
import exception.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.ClienteService;
import service.IClienteService;


public class ClienteServiceTest {

    private final IClienteService clienteService;

    private Cliente cliente;

    public ClienteServiceTest() {
        IClienteDAO dao = new ClienteDaoMOck();
        clienteService = new ClienteService(dao);
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

        clienteService.salvar(cliente);
    }

    @Test
    public void pesquisarCliente() {

        Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() {

        Boolean retorno = clienteService.salvar(cliente);

        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        clienteService.excluir(cliente);
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Pedro Costa");
        clienteService.alterar(cliente);

        Assert.assertEquals("Pedro Costa", cliente.getNome());
    }
}
