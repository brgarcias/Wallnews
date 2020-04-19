package model;

import java.io.Serializable;

public class Comentario implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idComentario;
	private String texto;
	private String nome;
	private int idNoticia;

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
	
	public int getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	public int getIdNoticia() {
		return idNoticia;
	}

	public void setIdNoticia(int idNoticia) {
		this.idNoticia = idNoticia;
	}

}
