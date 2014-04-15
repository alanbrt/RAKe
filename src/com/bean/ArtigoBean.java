package com.bean;

//import javax.faces.application.FacesMessage;
//import javax.faces.context.FacesContext;
//import org.primefaces.event.FileUploadEvent;  
//import org.primefaces.model.UploadedFile; 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import com.modelo.Congresso;
import com.modelo.Participante;
import com.modelo.Submissao;

@ManagedBean
@ApplicationScoped
public class ArtigoBean {

	private Artigo artigo = new Artigo();
	
	private List<Integer> inscricoes;
	
	private int inscricao;
	
	private String congresso;
	
	public String getCongresso() {
		return congresso;
	}
	public void setCongresso(String congresso) {
		this.congresso = congresso;
	}
	public ArtigoBean()
	{
		inscricoes = new ArrayList<Integer>();
		
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

		Participante p = new DAO<Participante>(Participante.class).buscaPorId(inscricao);
			
		if(p == null) return false;
		
		return true;
		
	}
	
	
	public String confirmar()
	{
		if(validaAutores())
		{
			
			System.out.println("Autores validados!");
			System.out.println("Art "+artigo.getResumo() +" Art "+ artigo.getTitulo()+" url "+ artigo.getUrl());
			if((!artigo.getResumo().isEmpty()) && (!artigo.getTitulo().isEmpty()) && (!artigo.getUrl().isEmpty()))
			{
				System.out.println("Salvando no banco!");

				buscaCongresso();
				
				new DAO<Artigo>(Artigo.class).adiciona(this.artigo);
				
				int id = new DAO<Artigo>(Artigo.class).contaTodos("artigo");

				Submissao submissao = new Submissao();
					
				submissao.getId_submissao().setInscricao_fk(inscricao);
				submissao.getId_submissao().setId_artigo_fk(id);
					
				new DAO<Submissao>(Submissao.class).adiciona(submissao);

				
				return "index.xhtml";
			}
		}
		
		
		return "submissao.xhtml";
	}
	
	public String cancelar()
	{
		return "menu.xhtml";
	}
	
	
	public void doUpload(FileUploadEvent fileUploadEvent)
	{ 
		
		UploadedFile uf = fileUploadEvent.getFile(); 
        String nomeArquivo = uf.getFileName();  
        String url = "//Users//alan_curtindoafesta//Desktop//" + nomeArquivo;
        File f = new File(url);
        OutputStream os = null;  
        InputStream is = null;  
        try {  
            is = uf.getInputstream();  
            byte[] b = new byte[is.available()];  
            os = new FileOutputStream(f);  
            while (is.read(b) > 0) {  
                os.write(b);  
            }  
              
            FacesMessage msg = new FacesMessage("Upload realizado com Sucesso!", fileUploadEvent.getFile().getFileName());  
            FacesContext.getCurrentInstance().addMessage(null, msg);  
        } catch (IOException ex) {  
           // Logger.getLogger(MbUpload.class.getName()).log(Level.SEVERE, null, ex); 
        	System.out.println("Erro: SERVER NULL");
        } finally {  
            try {  
                os.flush();  
                os.close();  
                is.close();  
            } catch (IOException ex) {  
               // Logger.getLogger(MbUpload.class.getName()).log(Level.SEVERE, null, ex);  
            	System.out.println("Erro: SERVER NULL");
            }  
        }  
        
        artigo.setUrl(url);
	}
	
	public void addAutor()
	{
		inscricoes.add(inscricao);
		
		System.out.println(inscricoes);
	}
 
	public List<Artigo> getListaArtigos()
	{
		return new DAO<Artigo>(Artigo.class).listaTodos();
		
	}
	
	
	public void buscaCongresso()
	{
		List<Congresso> congressos = new DAO<Congresso>(Congresso.class).listaTodos();
		
		for(Congresso c : congressos)
		{
			if(c.getNome().equals(congresso))
			{
				artigo.setId_congresso(c.getId());
			}
		}
	}
}
