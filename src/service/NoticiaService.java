package service;

import java.util.ArrayList;

import dao.NoticiasDAO;
import model.Comentario;
import model.Noticia;

public class NoticiaService {

	NoticiasDAO dao = new NoticiasDAO();

	public int criar(Noticia noticia) {
		return dao.criar(noticia);
	}
	
	public int criarComentario(Comentario comentario) {
		return dao.criarComentario(comentario);
	}

	public int atualizar(Noticia noticia) {
		return dao.atualizar(noticia);
	}

	public void excluir(int id) {
		dao.excluir(id);
	}

	public Noticia carregar(int id) {
		return dao.carregar(id);
	}
	
	public ArrayList<Noticia> listagem() {
		return dao.listagem();
	}

	public ArrayList<Comentario> listaNoticiasComentario() {
		return dao.listagemComentario();
	}
	
}
