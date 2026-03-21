import dao1.IProdutoDAO;
import dao1.ProdutoDAO;
import domin.Produto;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProdutoTest {

    private IProdutoDAO produtoDAO;

    @Test
    public void cadastrarTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Produto Teste");

        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.buscar("10");
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());

        Integer countDel = produtoDAO.excluir(produtoBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void buscarTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Produto Teste");

        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.buscar("10");
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());

        Integer countDel = produtoDAO.excluir(produtoBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void excluirTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Produto Teste");

        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.buscar("10");
        assertNotNull(produtoBD);

        Integer countDel = produtoDAO.excluir(produtoBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void buscarTodosTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto p1 = new Produto();
        p1.setCodigo("10");
        p1.setNome("Produto 1");
        produtoDAO.cadastrar(p1);

        Produto p2 = new Produto();
        p2.setCodigo("20");
        p2.setNome("Produto 2");
        produtoDAO.cadastrar(p2);

        List<Produto> list = produtoDAO.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        int countDel = 0;
        for (Produto p : list) {
            produtoDAO.excluir(p);
            countDel++;
        }

        assertEquals(list.size(), countDel);

        list = produtoDAO.buscarTodos();
        assertEquals(0, list.size());
    }

    @Test
    public void atualizarTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Produto Teste");

        produtoDAO.cadastrar(produto);

        Produto produtoBD = produtoDAO.buscar("10");
        assertNotNull(produtoBD);

        produtoBD.setCodigo("20");
        produtoBD.setNome("Produto Atualizado");

        Integer countUpdate = produtoDAO.atualizar(produtoBD);
        assertTrue(countUpdate == 1);

        Produto produtoAntigo = produtoDAO.buscar("10");
        assertNull(produtoAntigo);

        Produto produtoNovo = produtoDAO.buscar("20");
        assertNotNull(produtoNovo);
        assertEquals(produtoBD.getId(), produtoNovo.getId());
        assertEquals(produtoBD.getCodigo(), produtoNovo.getCodigo());
        assertEquals(produtoBD.getNome(), produtoNovo.getNome());

        List<Produto> list = produtoDAO.buscarTodos();
        for (Produto p : list) {
            produtoDAO.excluir(p);
        }
    }
}