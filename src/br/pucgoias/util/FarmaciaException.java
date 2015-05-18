package br.pucgoias.util;

/**
 * Classe que encapsula as excecoes da aplicacao Farmacia
 * @author Fábio Henrique Pires	
 *
 */

public class FarmaciaException extends Exception {

	private Exception ex;
	private String msg;
	
	public FarmaciaException(Exception e){
		this.ex = e;
		this.msg = e.getMessage();
	}
	
	public FarmaciaException(Exception e, String mensagem){
		e.printStackTrace();
		this.ex = e;
		this.msg = mensagem;
	}
	
	public Exception getEx() {
		return ex;
	}

	public String getMsg() {
		return msg;
	}
	
}
