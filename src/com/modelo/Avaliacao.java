package com.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.openjpa.persistence.jdbc.ForeignKey;

import com.sun.istack.internal.NotNull;

@Entity
public class Avaliacao {

	@Id
	@GeneratedValue
	private int id;
	
	@ForeignKey
	@NotNull
	private int inscricao_fk;
	
	@NotNull
	private float nota;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
