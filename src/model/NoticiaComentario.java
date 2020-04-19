package model;

import java.io.Serializable;
import java.util.ArrayList;

public class NoticiaComentario implements Serializable {

	private static final long serialVersionUID = 1L;
	private String titulo;
	private String descricao;
	private String texto;
	private int idNoticia;
	private ArrayList<Comentario> comentario;

	public NoticiaComentario() {
		// TODO Auto-generated constructor stub
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getIdNoticia() {
		return idNoticia;
	}

	public void setIdNoticia(int idNoticia) {
		this.idNoticia = idNoticia;
	}

	public ArrayList<Comentario> getComentario() {
		return comentario;
	}

	public void setComentario(ArrayList<Comentario> comentario) {
		this.comentario = comentario;
	}

	
}
