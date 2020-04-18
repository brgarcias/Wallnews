package model;

import java.io.Serializable;

public class Comentario implements Serializable {

	private static final long serialVersionUID = 1L;
	private String texto;
	private String nome;
	private Noticia noticia;

	public Comentario() {
		// TODO Auto-generated constructor stub
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}

}
