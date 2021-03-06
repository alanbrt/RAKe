package com.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Participante{

	/**
	 * 
	 */

	@Id
	@GeneratedValue
	private int inscricao;
	
	private String nome;
	
	private String telefone;
	
	private String rua;
	
	private String bairro;
	
	private String cep;
	
	private String numero;
	
	private String complemento;
	
	private String email;
	
	private String localEmprego;
	
	private String numeroCartao;
	
	private String vencimentoCartao;
	
	private String marcaCartao;
	
	private boolean revisor;
	
	public String getLocalEmprego() {
		return localEmprego;
	}
	
	public void setLocalEmprego(String localEmprego) {
		this.localEmprego = localEmprego;
	}
	
	public int getInscricao() {
		return inscricao;
	}
	public void setInscricao(int inscricao) {
		this.inscricao = inscricao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getVencimentoCartao() {
		return vencimentoCartao;
	}

	public void setVencimentoCartao(String vencimentoCartao) {
		this.vencimentoCartao = vencimentoCartao;
	}

	public String getMarcaCartao() {
		return marcaCartao;
	}

	public void setMarcaCartao(String marcaCartao) {
		this.marcaCartao = marcaCartao;
	}

	public boolean isRevisor() {
		return revisor;
	}
	public void setRevisor(boolean revisor) {
		this.revisor = revisor;
	} 
	
}
