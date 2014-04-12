package com.modelo;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

@Embeddable
public class Submissao{

	@EmbeddedId
	private ChaveComposta id_submissao = new ChaveComposta();


	public ChaveComposta getId_submissao() {
		return id_submissao;
	}


	public void setId_submissao(ChaveComposta id_submissao) {
		this.id_submissao = id_submissao;
	}
	

	
	
}
