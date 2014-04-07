package com.modelo;

public class Avaliacao {

	private int id;
	
	private int inscricao_fk;
	
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
