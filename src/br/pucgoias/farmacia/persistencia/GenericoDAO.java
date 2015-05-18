package br.pucgoias.farmacia.persistencia;

import java.io.Serializable;
import java.util.List;
import br.pucgoias.util.FarmaciaException;

public interface GenericoDAO<T, ID extends Serializable> {

	/**
	 * Retorna a classe a ser persistida
	 * @return
	 */
	public Class<T> getObjectClass();
	
	/**
	 * Inclui um objeto T na base de dados
	 * @param object
	 * @return
	 * @throws FarmaciaException
	 */
	public T incluir(T object) throws FarmaciaException;
	
	/**
	 * Altera um objeto T na base de dados
	 * @param object
	 * @return
	 * @throws FarmaciaException
	 */
	public T alterar(T object) throws FarmaciaException;
	
	/**
	 * Consulta um objeto T da base de dados
	 * @param id
	 * @return
	 * @throws FarmaciaException
	 */
	public T consultar(Integer id) throws FarmaciaException;
	
	/**
	 * Exclui um objeto T  da base de dados
	 * @param id
	 * @throws FarmaciaException
	 */
	public void excluir(Integer id) throws FarmaciaException;
	
	/**
	 * Lista os objetos T da base de dados
	 * @return
	 * @throws FarmaciaException
	 */
	public List<T> listar() throws FarmaciaException;
	
	
}
