package com.modelo;

import java.io.Serializable;

public class Cartao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String numero_cartao;
	
	private String vencimento_cartao;
	
	private String marca_cartao;
	
	public String getNumero_cartao() {
		return numero_cartao;
	}
	public void setNumero_cartao(String numero_cartao) {
		this.numero_cartao = numero_cartao;
	}
	public String getVencimento_cartao() {
		return vencimento_cartao;
	}
	public void setVencimento_cartao(String vencimento_cartao) {
		this.vencimento_cartao = vencimento_cartao;
	}
	public String getMarca_cartao() {
		return marca_cartao;
	}
	public void setMarca_cartao(String marca_cartao) {
		this.marca_cartao = marca_cartao;
	}
}
