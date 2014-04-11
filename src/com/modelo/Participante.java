package com.modelo;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Participante{

	@Id
	@GeneratedValue
	private int inscricao;
	
	private String nome;
	
	@OneToMany
	private Collection<Telefone> telefone;
	
	private String rua;
	
	private String bairro;
	
	private String cep;
	
	private String numero;
	
	private String complemento;
	
	private String email;
	
	private String local_de_emprego;
	
	private String numero_cartao;
	
	private String vencimento_cartao;
	
	private String marca_cartao;
	
	private boolean revisor;

	
	public String getLocal_de_emprego() {
		return local_de_emprego;
	}
	public void setLocal_de_emprego(String local_de_emprego) {
		this.local_de_emprego = local_de_emprego;
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

	public boolean isRevisor() {
		return revisor;
	}
	public void setRevisor(boolean revisor) {
		this.revisor = revisor;
	}
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
	public Collection<Telefone> getTelefone() {
		return telefone;
	}
	public void setTelefone(Collection<Telefone> telefone) {
		this.telefone = telefone;
	}
	
	
}
