package br.pucgoias.farmacia.negocio;


import java.util.List;
import br.pucgoias.farmacia.entidade.Produto;
import br.pucgoias.util.FarmaciaException;

/**
 * @author Fábio Henrique Pires
 * Interface que define operações da camada de negocio do Produto
 *
 */

public interface ProdutoService {
	
	/**
	 * Inclui um porduto 
	 * @param produto
	 * @return
	 * @throws FarmaciaException
	 */	
	public Produto incluir(Produto produto) throws FarmaciaException;
	
	/**
	 * Alterar um produto
	 * @param produto
	 * @return
	 * @throws FarmaciaException
	 */
	public Produto alterar(Produto produto) throws FarmaciaException;
	
	/**
	 * Exclui um produto
	 * @param id
	 * @throws AgendaException
	 */
	public void excluir(Integer id) throws FarmaciaException;
	
	/**
	 * Consulta uma pessoa pelo identificador
	 * @param id
	 * @return
	 * @throws FarmaciaException
	 */
	public Produto consultar(Integer id) throws FarmaciaException;
	
	/**
	 * Lista todos os produtos cadastrados
	 * @return
	 * @throws FarmaciaException
	 */
	public List<Produto> listar() throws FarmaciaException;
	
	

}
