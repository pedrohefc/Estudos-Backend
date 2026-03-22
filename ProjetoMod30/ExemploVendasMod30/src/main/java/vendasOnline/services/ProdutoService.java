/**
 * 
 */
package vendasOnline.services;

import vendasOnline.dao.IProdutoDAO;
import vendasOnline.domain.Produto;
import vendasOnline.services.generic.GenericService;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
