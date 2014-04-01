package com.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Artigo {

	@Id
	private int id;
	
	private String resumo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	
}
