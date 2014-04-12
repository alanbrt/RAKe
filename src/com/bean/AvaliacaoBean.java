package com.bean;

import java.net.MalformedURLException;
//import java.net.URL;


import javax.annotation.ManagedBean;

//import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

import com.dao.DAO;
import com.modelo.Avaliacao;

@ManagedBean
public class AvaliacaoBean {

	private Avaliacao avaliacao = new Avaliacao();

	private String comentario;
	
	public void addAvaliacao()
	{
		System.out.println("Gravando Avaliacao");
		new DAO<Avaliacao>(Avaliacao.class).adiciona(this.avaliacao);
	}
	
	public String cancelar()
	{
		return "menu.xhtml";
	}
	public String confirma() throws MalformedURLException, EmailException
	{
		if(avaliacao.getNota() <= 0 || comentario.length() <= 0)
		{
			addAvaliacao();
			enviaComentario();
			
			return "index.xhtml";
		}

		return "avaliacao.xhtml";//Colocar um aviso de avalia‹o realizada
		
	}
	
	public void enviaComentario() throws MalformedURLException, EmailException
	{
//		EmailAttachment attachment = new EmailAttachment(); 
//		attachment.setURL(new URL("http://www.apache.org/images/asf_logo_wide.gif"));
//		attachment.setDisposition(EmailAttachment.ATTACHMENT); 
//		attachment.setDescription("Apache logo"); 
//		attachment.setName("Apache logo");   
		
		// Cria a mensagem de e-mail 
		MultiPartEmail email = new MultiPartEmail(); 
		email.setHostName("mail.google.com"); 
		email.addTo("alandossantossoaress@gmail.com", "Kal"); 
		email.setFrom("rakemanage@gmail.com", "Me"); //Senha rake2014
		email.setAuthentication("rakemanage@gmail.com", "rake2014");
		email.setSubject("Teste Comentario RAKe"); 
		email.setMsg(comentario);   
		//email.attach(attachment); 
		
		// adiciona o anexo   
		email.send();// envia o e-mail

	}
	
	public Avaliacao getAvaliacao()
	{
		return avaliacao;
	}
	
	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
}
