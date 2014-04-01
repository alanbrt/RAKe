package com.bean;

import javax.annotation.ManagedBean;

import com.modelo.Participante;

@ManagedBean
public class ParticipanteBean {

	private Participante participante = new Participante();

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}
}
