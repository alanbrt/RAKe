package com.bean;

import javax.faces.bean.ManagedBean;

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
	
	public String grava()
	{
				
		new DAO<Participante>(Participante.class).adiciona(this.participante);
		
		return "Gravando participante " + this.participante;

		
	}
	
}
