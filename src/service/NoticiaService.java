package service;

import dao.NoticiasDAO;
import model.Noticia;

public class NoticiaService {

	NoticiasDAO dao = new NoticiasDAO();

	public int criar(Noticia noticia) {
		return dao.criar(noticia);
	}

	public void atualizar(Noticia noticia) {
		dao.atualizar(noticia);
	}

	public void excluir(int id) {
		dao.excluir(id);
	}

	public Noticia carregar(int id) {
		return dao.carregar(id);
	}

}
