package vendasOnline.dao;

import vendasOnline.dao.generic.IGenericDAO;
import vendasOnline.domain.Venda;
import vendasOnline.exceptions.DAOException;
import vendasOnline.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
