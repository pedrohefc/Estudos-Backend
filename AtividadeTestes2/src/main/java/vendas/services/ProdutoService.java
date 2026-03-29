package vendas.services;

import vendas.dao.IProdutoDAO;
import vendas.domain.Produto;
import vendas.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
