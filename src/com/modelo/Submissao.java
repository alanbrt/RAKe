package com.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Submissao {

	@Id
	private int inscricao_fk;
	
	@Id
	private int id_artigo;

	public int getInscricao_fk() {
		return inscricao_fk;
	}

	public void setInscricao_fk(int inscricao_fk) {
		this.inscricao_fk = inscricao_fk;
	}

	public int getId_artigo() {
		return id_artigo;
	}

	public void setId_artigo(int id_artigo) {
		this.id_artigo = id_artigo;
	}
	
	
}
