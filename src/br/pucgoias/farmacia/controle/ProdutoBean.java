package br.pucgoias.farmacia.controle;

import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * Classe que representa o formulário web do produto 
 * @author Fábio Henrique Pires
 * 
 */

@Component
public class ProdutoBean {

	private Integer prodId;
	private String prodNome;
	private String prodDescricao;
	private String prodTarja;
	private Date prodDataFabric;
	private Date prodDataValid;
	private Float prodValor;
	
	
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
