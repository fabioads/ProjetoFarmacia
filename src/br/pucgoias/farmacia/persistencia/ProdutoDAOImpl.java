package br.pucgoias.farmacia.persistencia;

import org.springframework.stereotype.Repository;

import br.pucgoias.farmacia.entidade.Produto;

/**
 * Classe que define as operacoes da camada de persistencia do Produto
 * @author Fábio Henrique Pires
 *
 */
@Repository
public class ProdutoDAOImpl extends GenericoDAOImpl<Produto, Integer> implements
		ProdutoDAO {

}
