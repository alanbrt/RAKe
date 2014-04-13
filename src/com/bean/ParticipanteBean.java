package com.bean;


import javax.annotation.ManagedBean;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

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
	
	public void validaCampos()
	{


	}
	
	public void enviaEmail() throws EmailException
	{
		
		int inscricao  = new DAO<Participante>(Participante.class).contaTodos("Participante");
		Participante p = new DAO<Participante>(Participante.class).buscaPorId(inscricao);
		
		// Cria a mensagem de e-mail 
		Email email = new SimpleEmail(); 
		
		email.setHostName("smtp.googlemail.com"); 
		email.setSmtpPort(465);
		email.setSSLOnConnect(true);
		email.addTo(p.getEmail(), p.getNome()); 
		email.setFrom("rakemanage@gmail.com", "eCongress"); //Senha rake2014
		email.setAuthentication("rakemanage@gmail.com", "rake2014");
		email.setSubject(p.getCongresso()+ " - Confirmacao de Inscricao"); 
		email.setMsg(" Ola, "+p.getNome()+ ".\n Sua inscricao foi realizada com sucesso!\n Numero de inscricao: "
		+ inscricao+" \n Congresso: "+p.getCongresso());   
		
		// adiciona o anexo   
		email.send();// envia o e-mail
	}
	
	public String cancelar()
	{
		return "menu.xhtml";
	}
	
	public String grava() throws EmailException
	{ 		
		validaCampos();
		
		System.out.println("Gravando Participante");
		new DAO<Participante>(Participante.class).adiciona(this.participante);
		
		enviaEmail();
		
		return "index.xhtml";
		
	}
	
	
}
