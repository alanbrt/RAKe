package com.bean;

import java.net.MalformedURLException;
//import java.net.URL;


import java.util.List;

import javax.annotation.ManagedBean;



//import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

import com.dao.DAO;
import com.modelo.Avaliacao;
import com.modelo.Participante;

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
		if((!avaliacao.getNota().isEmpty()) && (!comentario.isEmpty()))
		{
			addAvaliacao();
			enviaComentario();
			
			return "index.xhtml";
		}

		return "avaliacao.xhtml";//Colocar um aviso de erro
		
	}
	
	public void enviaComentario() throws MalformedURLException, EmailException
	{ 
		
		Participante p = new DAO<Participante>(Participante.class).buscaPorId(avaliacao.getId_avaliacao().getInscricao_fk());
		
		// Cria a mensagem de e-mail 
		MultiPartEmail email = new MultiPartEmail(); 
		email.setHostName("mail.google.com"); 
		email.addTo(p.getEmail(), p.getNome()); 
		email.setFrom("rakemanage@gmail.com", "eCongress"); //Senha rake2014
		email.setAuthentication("rakemanage@gmail.com", "rake2014");
		email.setSubject(p.getCongresso()+" - Avaliacao de Artigo"); 
		email.setMsg(comentario);   
   
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
	
	
	public List<Avaliacao> getListaAvaliacao()
	{
		return new DAO<Avaliacao>(Avaliacao.class).listaTodos();

	}
	
}
