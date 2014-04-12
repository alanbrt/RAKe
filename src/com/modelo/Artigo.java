package com.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Artigo {

	@Id
	@GeneratedValue
	private int id_artigo;
	
	private String resumo;
	
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
