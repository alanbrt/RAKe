package com.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Submissao{

	@Id
	private ChaveComposta id_submissao = new ChaveComposta();


	public ChaveComposta getId_submissao() {
		return id_submissao;
	}


	public void setId_submissao(ChaveComposta id_submissao) {
		this.id_submissao = id_submissao;
	}
	

	
	
}
