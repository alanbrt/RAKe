package com.bean;

//import javax.faces.application.FacesMessage;
//import javax.faces.context.FacesContext;
//import org.primefaces.event.FileUploadEvent;  
//import org.primefaces.model.UploadedFile; 
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.dao.DAO;
import com.modelo.Artigo;
import com.modelo.Participante;
import com.modelo.Submissao;

@ManagedBean
@ApplicationScoped
public class ArtigoBean {

	private Artigo artigo = new Artigo();
	
	private List<Integer> inscricoes;

	private long tamArquivo;
	
	private int inscricao;
	
	public ArtigoBean()
	{
		inscricoes = new ArrayList<Integer>();
		
	}
	public long getTamArquivo() {
		return tamArquivo;
	}

	public void setTamArquivo(long tamArquivo) {
		this.tamArquivo = tamArquivo;
	}

	public int getInscricao() {
		return inscricao;
	}

	public void setInscricao(int inscricao) {
		this.inscricao = inscricao;
	}

	public List<Integer> getInscricoes() {
		return inscricoes;
	}

	public void setInscricoes(List<Integer> inscricoes) {
		this.inscricoes = inscricoes;
	}

	public void setArtigo(Artigo artigo) {
		this.artigo = artigo;
	}

	public Artigo getArtigo()
	{
		return artigo;
		
	}
	
	public boolean validaAutores()
	{
		for(Integer inscricao : inscricoes)
		{
			Participante p = new DAO<Participante>(Participante.class).buscaPorId(inscricao);
			
			if(p == null) return false;
		}
		
		return true;
		
	}
	
	
	public String confirmar()
	{
		if(validaAutores())
		{
			if((!artigo.getResumo().isEmpty()) && (!artigo.getTitulo().isEmpty()) && (tamArquivo > 0))
			{
				
				new DAO<Artigo>(Artigo.class).adiciona(this.artigo);
				
				int id = new DAO<Artigo>(Artigo.class).contaTodos("artigo");
				
				for(Integer inscricao : inscricoes)
				{
					Submissao submissao = new Submissao();
					
					submissao.getId_submissao().setInscricao_fk(inscricao);
					submissao.getId_submissao().setId_artigo_fk(id);
					
					new DAO<Submissao>(Submissao.class).adiciona(submissao);
				}
				
				return "index.xhtml";
			}
		}
		
		
		return "menu.xhtml";
	}
	
	public String cancelar()
	{
		return "menu.xhtml";
	}
	
	public void doUpload(FileUploadEvent fileUploadEvent)
	{ 
		UploadedFile uploadedFile = fileUploadEvent.getFile(); 
		String fileNameUploaded = uploadedFile.getFileName(); 
		long fileSizeUploaded = uploadedFile.getSize(); 
		this.tamArquivo = fileSizeUploaded;
		String infoAboutFile = "<br/> Arquivo recebido: <b>" +fileNameUploaded +"</b><br/>"+ "Tamanho do Arquivo: <b>"+fileSizeUploaded+"</b>"; 
		FacesContext facesContext = FacesContext.getCurrentInstance(); 
		facesContext.addMessage(null, new FacesMessage("Sucesso", infoAboutFile)); 
	}
	
	public void addAutor()
	{
		inscricoes.add(inscricao);
		
		System.out.println(inscricoes);
	}
    
}
