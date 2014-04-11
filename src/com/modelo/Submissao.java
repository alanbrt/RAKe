package com.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Submissao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//@JoinColumn(name="inscricao_fk",referencedColumnName="inscricao")
	@Id
	private int inscricao_fk;
	
	//@JoinColumn(name="id_artigo_fk",referencedColumnName="id_artigo")
	@Id
	private int id_artigo_fk;

	public int getInscricao_fk() {
		return inscricao_fk;
	}

	public void setInscricao_fk(int inscricao_fk) {
		this.inscricao_fk = inscricao_fk;
	}

	public int getId_artigo_fk() {
		return id_artigo_fk;
	}

	public void setId_artigo_fk(int id_artigo_fk) {
		this.id_artigo_fk = id_artigo_fk;
	}

	
	
}
