package br.pucgoias.farmacia.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe que representa os dados persistentes de pessoa
 * @author Fábio Henrique Pires
 */

@Entity
@Table(name="PRODUTO") 
public class Produto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="prod_id")
	private Integer prodId;
	
	@Column(name="prod_nome")
	private String prodNome;
	
	@Column(name="prod_descricao")
	private String prodDescricao;
	
	@Column(name="prod_tarja")
	private String prodTarja;
	
	@Column(name="prod_data_fabric")
	private Date prodDataFabric;
	
	@Column(name="prod_data_valid")
	private Date prodDataValid;
	
	@Column(name="prod_valor")
	private Float prodValor;

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((prodId == null) ? 0 : prodId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (prodId == null) {
			if (other.prodId != null)
				return false;
		} else if (!prodId.equals(other.prodId))
			return false;
		return true;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public String getProdNome() {
		return prodNome;
	}

	public void setProdNome(String prodNome) {
		this.prodNome = prodNome;
	}

	public String getProdDescricao() {
		return prodDescricao;
	}

	public void setProdDescricao(String prodDescricao) {
		this.prodDescricao = prodDescricao;
	}

	public String getProdTarja() {
		return prodTarja;
	}

	public void setProdTarja(String prodTarja) {
		this.prodTarja = prodTarja;
	}

	public Date getProdDataFabric() {
		return prodDataFabric;
	}

	public void setProdDataFabric(Date prodDataFabric) {
		this.prodDataFabric = prodDataFabric;
	}

	public Date getProdDataValid() {
		return prodDataValid;
	}

	public void setProdDataValid(Date prodDataValid) {
		this.prodDataValid = prodDataValid;
	}

	public Float getProdValor() {
		return prodValor;
	}

	public void setProdValor(Float prodValor) {
		this.prodValor = prodValor;
	}
	
}
