package br.pucgoias.farmacia.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.pucgoias.farmacia.entidade.Produto;
import br.pucgoias.farmacia.persistencia.ProdutoDAO;
import br.pucgoias.util.FarmaciaException;

public class ProdutoServiceImpl implements ProdutoService{

	private ProdutoDAO produtoDAO;
	
	public ProdutoDAO getProdutoDAO() {
		return produtoDAO;
	}

	@Autowired
	public void setProdutoDAO(ProdutoDAO produtoDAO) {
		this.produtoDAO = produtoDAO;
	}

	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public Produto incluir(Produto produto) throws FarmaciaException {
		return getProdutoDAO().incluir(produto);
	}

	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public Produto alterar(Produto produto) throws FarmaciaException {
		return getProdutoDAO().alterar(produto);
	}

	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public void excluir(Integer id) throws FarmaciaException {
		getProdutoDAO().excluir(id);
	}

	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	@Override
	public Produto consultar(Integer id) throws FarmaciaException {
		Produto produto = getProdutoDAO().consultar(id);
		return produto;
	}

	
	@Transactional(readOnly=true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Produto> listar() throws FarmaciaException {
		return getProdutoDAO().listar();
	}

	
}
