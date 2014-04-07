package com.bean;

import javax.annotation.ManagedBean;

import com.dao.DAO;
import com.modelo.Participante;

@ManagedBean
public class ParticipanteBean {

	private Participante participante = new Participante();

	public Participante getParticipante() 
	{
		return participante;
	}

	public void setParticipante(Participante participante) 
	{
		this.participante = participante;
	}
	
	
	public void addParticipante()
	{
		
	}
	
	public void confirma()
	{

	}
	
	public void grava()
	{
		
		System.out.println("Gravando participante " + this.participante);
		
		new DAO<Participante>(Participante.class).adiciona(this.participante);
		
	}
	
}
