package com.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.sun.istack.internal.NotNull;

@Entity
public class Avaliacao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//@JoinColumn(name="inscricao_fk",referencedColumnName="inscricao")
	@Id
	private int inscricao_fk;
	
	//@JoinColumn(name="artigo_fk",referencedColumnName="id_artigo")
	@Id
	private int artigo_fk;
	
	@NotNull
	private float nota;

	
	public int getArtigo_fk() {
		return artigo_fk;
	}

	public void setArtigo_fk(int artigo_fk) {
		this.artigo_fk = artigo_fk;
	}

	public int getInscricao_fk() {
		return inscricao_fk;
	}

	public void setInscricao_fk(int inscricao_fk) {
		this.inscricao_fk = inscricao_fk;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}
	
	
}
