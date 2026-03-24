package vendasOnlineTest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import dao.ProdutoDAO;
import doMain.Produto;

public class ProdutoTest {

    private ProdutoDAO produtoDao;

    public ProdutoTest() {
        produtoDao = new ProdutoDAO();
    }

    @Test
    public void cadastrar() {
        Produto produto = new Produto();
        produto.setNome("Notebook");
        produto.setDescricao("Notebook Dell");
        produto.setValor(3500.0);

        produto = produtoDao.cadastrar(produto);

        assertNotNull(produto);
        assertNotNull(produto.getId());
    }
}
