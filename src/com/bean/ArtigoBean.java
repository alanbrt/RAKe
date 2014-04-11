package com.bean;

//import javax.faces.application.FacesMessage;
//import javax.faces.context.FacesContext;
//import org.primefaces.event.FileUploadEvent;  
//import org.primefaces.model.UploadedFile; 
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.modelo.Artigo;

public class ArtigoBean {

	private Artigo artigo = new Artigo();
	

	public void setArtigo(Artigo artigo) {
		this.artigo = artigo;
	}

	public Artigo getArtigo()
	{
		return artigo;
		
	}
	
	public void validaAutores()
	{
		
	}
	
	public String confirmar()
	{
		return null;
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
		String infoAboutFile = "<br/> Arquivo recebido: <b>" +fileNameUploaded +"</b><br/>"+ "Tamanho do Arquivo: <b>"+fileSizeUploaded+"</b>"; 
		FacesContext facesContext = FacesContext.getCurrentInstance(); 
		facesContext.addMessage(null, new FacesMessage("Sucesso", infoAboutFile)); 
	}
	
	public String addAutor()
	{
		return "";
	}
    
}
