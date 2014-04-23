package com.bean;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

import com.dao.DAO;
import com.modelo.Avaliacao;
import com.modelo.Participante;
import com.modelo.Submissao;

@ManagedBean
public class AvaliacaoBean {

	private Avaliacao avaliacao = new Avaliacao();

	private String comentario;

	HttpServletRequest request = (HttpServletRequest) FacesContext
			.getCurrentInstance().getExternalContext().getRequest();

	public AvaliacaoBean() {
		this.avaliacao.getId_avaliacao().setInscricao_fk(
				Integer.parseInt(request.getParameter("inscricao")));
		this.avaliacao.getId_avaliacao().setId_artigo_fk(
				Integer.parseInt(request.getParameter("id_artigo")));
	}

	public void addAvaliacao() {
		System.out.println("Gravando Avaliacao");
		new DAO<Avaliacao>(Avaliacao.class).adiciona(this.avaliacao);
	}

	public String cancelar() {
		return "index.xhtml";
	}

	public String confirma() throws MalformedURLException, EmailException {
		if ((!avaliacao.getNota().isEmpty()) && (!comentario.isEmpty())) {
			
			addAvaliacao();
			List<Participante> autores = buscaAutores();
			for (Participante a : autores){
				enviaComentario(a);
			}
			return "index.xhtml";
		}

		return "avaliacao.xhtml";// Colocar um aviso de erro

	}

	public void enviaComentario(Participante autor) throws MalformedURLException, EmailException {

		Participante avaliador = new DAO<Participante>(Participante.class)
				.buscaPorId(avaliacao.getId_avaliacao().getInscricao_fk());

		MultiPartEmail email = new MultiPartEmail();
		
		System.out.println("Autor: "+autor.getNome());
		System.out.println("Email: "+autor.getEmail());
		
		// Cria a mensagem de e-mail
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setSSLOnConnect(true);
		email.addTo(autor.getEmail(), autor.getNome());
		email.setFrom("rakemanage@gmail.com", "eCongress"); // Senha rake2014
		email.setAuthentication("rakemanage@gmail.com", "rake2014");
		email.setSubject(autor.getCongresso() + " - Avaliacao de Artigo");
		email.setMsg("Ola, " + autor.getNome()
				+ ".\nSeu artigo submetido no congresso " + autor.getCongresso()
				+ " foi avaliado por " + avaliador.getNome()
				+ " e recebeu o seguente comentario: \n" + comentario);

		email.send();// envia o e-mail

	}

	public List<Participante> buscaAutores() {
		List<Submissao> submissoes = new DAO<Submissao>(Submissao.class)
				.listaTodos();

		List<Participante> participantes = new ArrayList<Participante>();

		for (Submissao s : submissoes) {
			if (avaliacao.getId_avaliacao().getId_artigo_fk() == s
					.getId_submissao().getId_artigo_fk()) {
				Participante p = new DAO<Participante>(Participante.class)
						.buscaPorId(s.getId_submissao().getInscricao_fk());

				participantes.add(p);
			}

		}

		return participantes;
	}

	public Avaliacao getAvaliacao() {
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

	public List<Avaliacao> getListaAvaliacao() {
		return new DAO<Avaliacao>(Avaliacao.class).listaTodos();

	}

}
