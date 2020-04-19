package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;

/**
 * Servlet implementation class NoticiaController
 */
@WebServlet("*.do")
public class NoticiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doNoticias(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doNoticias(request, response);
	}

	private void doNoticias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String request_URI = request.getRequestURI();
		// System.out.println(request_URI);

		RequestDispatcher requestDispatcher = null;

		if (request_URI.endsWith("addNoticia.do")) {
			
			String titulo = request.getParameter("titulo");
			String descricao = request.getParameter("descricao");
			String texto = request.getParameter("texto");
			
			Noticia noticia = new Noticia();
			noticia.setTitulo(titulo);
			noticia.setDescricao(descricao);
			noticia.setTexto(texto);
			
			NoticiaService nts = new NoticiaService();
			int status = nts.criar(noticia);
			
			switch(status) {
			  case 1:
				  requestDispatcher = request.getRequestDispatcher("existe.html");
				  requestDispatcher.forward(request, response);
			    break;
			  case 2:
				  requestDispatcher = request.getRequestDispatcher("sucesso.html");
				  requestDispatcher.forward(request, response);
			    break;
			  case 3:
				  requestDispatcher = request.getRequestDispatcher("falho.html");
				  requestDispatcher.forward(request, response);
			    break;
			}

		}
	}

}
