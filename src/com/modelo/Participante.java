package com.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
public class Participante {

	//@Id
	private int inscricao;
	
	private String nome;
	
	private String telefone;
	
	private Endereco endereco;
	
	private String email;
	
	private String localEmprego;
	
	private Cartao cartao;
	
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Cartao getCartao() {
		return cartao;
	}
	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	public boolean isRevisor() {
		return revisor;
	}
	public void setRevisor(boolean revisor) {
		this.revisor = revisor;
	} 
	
}
