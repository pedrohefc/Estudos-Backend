package testes;

import dao.ClienteDao;
import dao.ClienteDaoMock;
import dao.IClienteDao;
import org.junit.jupiter.api.Test;
import service.ClienteService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClienteServiceTest {

    @Test
    public void salvarTest() {

        IClienteDao mockDao = new ClienteDaoMock();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.salvar();

        assertEquals("Sucesso", retorno);
    }

    @Test
    public void buscarTest() {

        IClienteDao mockDao = new ClienteDaoMock();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.buscar();

        assertEquals("Sucesso", retorno);
    }

    @Test
    public void excluirTest() {

        IClienteDao mockDao = new ClienteDaoMock();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.excluir();

        assertEquals("Sucesso", retorno);
    }

    @Test
    public void atualizarTest() {

        IClienteDao mockDao = new ClienteDaoMock();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.atualizar();

        assertEquals("Sucesso", retorno);
    }

    @Test
    public void esperadoErroNoSalvarTest() {

        IClienteDao mockDao = new ClienteDao();
        ClienteService service = new ClienteService(mockDao);

        assertThrows(UnsupportedOperationException.class, service::salvar);
    }

    @Test
    public void esperadoErroNoBuscarTest() {

        IClienteDao mockDao = new ClienteDao();
        ClienteService service = new ClienteService(mockDao);

        assertThrows(UnsupportedOperationException.class, service::buscar);
    }

    @Test
    public void esperadoErroNoExcluirTest() {

        IClienteDao mockDao = new ClienteDao();
        ClienteService service = new ClienteService(mockDao);

        assertThrows(UnsupportedOperationException.class, service::excluir);
    }

    @Test
    public void esperadoErroNoAtualizarTest() {

        IClienteDao mockDao = new ClienteDao();
        ClienteService service = new ClienteService(mockDao);

        assertThrows(UnsupportedOperationException.class, service::atualizar);
    }
}
