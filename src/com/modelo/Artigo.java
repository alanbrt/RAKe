package com.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sun.istack.internal.NotNull;

@Entity
public class Artigo {

	@Id
	@GeneratedValue
	private int id_artigo;
	
	@NotNull
	private String resumo;
	
	@NotNull
	private String titulo;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public int getId_artigo() {
		return id_artigo;
	}

	public void setId_artigo(int id_artigo) {
		this.id_artigo = id_artigo;
	}
	
}
