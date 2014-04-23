package com.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Submissao{

	@EmbeddedId
	private ChaveComposta id_submissao = new ChaveComposta();


	public ChaveComposta getId_submissao() {
		return id_submissao;
	}
	
	public void setInscricao_fk(int id_inscricao){
		id_submissao.setInscricao_fk(id_inscricao);
	}
	
	public void setId_artigo_fk(int id_artigo){
		id_submissao.setId_artigo_fk(id_artigo);
	}
	
	public void setId_submissao(ChaveComposta id_submissao) {
		this.id_submissao = id_submissao;
	}

}
