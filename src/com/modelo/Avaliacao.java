package com.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.sun.istack.internal.NotNull;

@Entity
public class Avaliacao{


	@EmbeddedId
	private ChaveComposta id_avaliacao = new ChaveComposta();
	

	@NotNull
	private float nota;

	public ChaveComposta getId_avaliacao() {
		return id_avaliacao;
	}

	public void setId_avaliacao(ChaveComposta id_avaliacao) {
		this.id_avaliacao = id_avaliacao;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}
	
	
}
