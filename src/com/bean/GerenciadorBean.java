package com.bean;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

import com.dao.DAO;
import com.modelo.Artigo;
import com.modelo.Participante;

@ManagedBean
public class GerenciadorBean {

	public void geraCertificado()
	{
		
	}
	
	public void geraCracha()
	{
		
	}
	
	public void enviaEmail(int id, Artigo a) throws EmailException, MalformedURLException
	{
		Participante p = new DAO<Participante>(Participante.class).buscaPorId(id);
		String link = "localhost:8080/RAKe/avaliacao.xhtml";
		// Cria a mensagem de e-mail 
		
		EmailAttachment attachment = new EmailAttachment(); 
		attachment.setURL(new URL("http://www.apache.org/images/asf_logo_wide.gif"));
		attachment.setDisposition(EmailAttachment.ATTACHMENT); 
		attachment.setDescription("Artigo"); 
		attachment.setName(a.getTitulo());   
		
		MultiPartEmail email = new MultiPartEmail(); 
		
		email.setHostName("smtp.googlemail.com"); 
		email.setSmtpPort(465);
		email.setSSLOnConnect(true);
		email.addTo(p.getEmail(), p.getNome()); 
		email.setFrom("rakemanage@gmail.com", "eCongress"); //Senha rake2014
		email.setAuthentication("rakemanage@gmail.com", "rake2014");
		email.setSubject("eCongress - Avaliacao de Artigo"); 
		email.setMsg(" Ola, "+p.getNome()+ ".\n Segue em anexo o artigo para avaliacao.\n"
				+ "A avaliacao deve ser feita através do link abaixo:\n"
		+ link+"\nOs campos nota e comentário são obrigatórios.\nNota entre 0-10.\n"
				+ "Comentário de no máximo 250 caracteres.\nAtenciosamente, eCongress");   
		
		// adiciona o anexo
		email.attach(attachment);
   
		// envia o e-mail
		email.send();
	}
	
	public void enviaArtigo() throws EmailException, MalformedURLException
	{
		List<Artigo> artigos = new ArtigoBean().getListaArtigos();
		
		for(Artigo a : artigos)
		{
			List<Integer> revisores = randomRevisores();

			for(Integer id : revisores)
			{
				enviaEmail(id,a);
			}
		}
	}
	
	public List<Integer> randomRevisores()
	{
		ParticipanteBean bean = new ParticipanteBean();
		List<Participante> revisores =  new ArrayList<Participante>();
		int count = 0;
		List<Integer> r =  new ArrayList<Integer>(5);
		
		boolean randomOK = false;
		
		for(Participante p : bean.getParticipantes())
			if(p.isRevisor()) revisores.add(p);
		
		while(!randomOK)
		{
			for(int i=0;i<5;i++)
				r.add(1+(int)(revisores.size()*Math.random()));
			
		    for(int i=0;i<5;i++)
			for(int j=0;j<5;j++)
				if(r.get(i).equals(r.get(j))) count++;
		    
		    if(count == 5) randomOK = true;
		}
	    
		return r;
		
	}
	
	
	public void enviaLista()
	{
		
	}
	
	public String getMenu()
	{
		return "menu.xhtml";
	}
}
