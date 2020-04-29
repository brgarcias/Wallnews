package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Comentario;
import model.Noticia;
import model.NoticiaComentario;
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

	private void doNoticias(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String request_URI = request.getRequestURI();
		// System.out.println(request_URI);

		RequestDispatcher requestDispatcher = null;

		if (request_URI.endsWith("addNoticia.do")) {

			String titulo = request.getParameter("titulo");
			String descricao = request.getParameter("descricao");
			String texto = request.getParameter("texto");
			response.setContentType("text/html;ISO-8859-1");

			Noticia noticia = new Noticia();
			noticia.setTitulo(titulo);
			noticia.setDescricao(descricao);
			noticia.setTexto(texto);

			NoticiaService nts = new NoticiaService();
			int status = nts.criar(noticia);

			switch (status) {
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
		if (request_URI.endsWith("editform.do")) {
			int id = Integer.parseInt(request.getParameter("id"));
			NoticiaService nts = new NoticiaService();
			Noticia noticia = nts.carregar(id);
			if (noticia == null) {
				requestDispatcher = request.getRequestDispatcher("notexisted.html");
				requestDispatcher.forward(request, response);
			} else {
				response.setContentType("text/html;ISO-8859-1");
				PrintWriter out = response.getWriter();

				out.println("<html>");
				out.println("<head>");
				
				out.println("<style type=\"text/css\">");
		        out.println("@import url(\"css/bootstrap.css\");");
		        
		        out.println("@import url(\"css/estilo.css\");");
		        out.println("</style>");
				
				out.println("<title>Editar notícia</title>");
				out.println("</head>");
				out.println("<body>");
				
				out.println("<div id='voltar' class='vertical-menu'>");
				out.println("<a href='listagem.jsp' class='active'>Voltar para notícias</a>");
				out.println("</div>");

				out.println("<h2>Editar Notícia</h2>");

				out.println("<form method='POST' action='update.do'>");
				out.println("<div class='form-group'>");
				out.println("<label for='tituloNoticia'>Noticia Id</label>" + noticia.getId());
				out.println("<input type='hidden' name='id' value='" + noticia.getId() + "' class='form-control'>");
				out.println("</div>");
				out.println(" <div class='form-group'>");
				out.println("<label for='descricaoNoticia'>Título</label>");
				out.println("<input type='text' name='titulo' id='tituloNoticia' value='" + noticia.getTitulo() + "'  class='form-control'>");
				out.println("</div>");
				out.println("<div class='form-group'>");
				out.println("<label for='textoNoticia'>Descrição</label>");
				out.println("<input class='form-control' type='text' id='descricaoNoticia' name='descricao' value='" + noticia.getDescricao() + "' rows='3'></textarea>");
				out.println("</div>");
				out.println("<div class='form-group'>");
				out.println("<label for='textoNoticia'>Texto</label>");
				out.println("<textarea type='text' class='form-control' name='texto' id='textoNoticia' rows='9'>" + noticia.getTexto() + "</textarea>");
				out.println("</div>");
				out.println("<div class='form-button'>");
				out.println("<input type='submit' value='Atualizar' />");
				out.println("</div>");
				out.println("</form>");
				out.println("</body></html>");
			}
		}

		if (request_URI.endsWith("update.do")) {

			int id = Integer.parseInt(request.getParameter("id"));
			String titulo = request.getParameter("titulo");
			String descricao = request.getParameter("descricao");
			String texto = request.getParameter("texto");
			response.setContentType("text/html;charset=ISO-8859-1");

			Noticia noticia = new Noticia();
			noticia.setId(id);
			noticia.setTitulo(titulo);
			noticia.setDescricao(descricao);
			noticia.setTexto(texto);

			NoticiaService nts = new NoticiaService();
			int status = nts.atualizar(noticia);
			if (status == 1) {
				requestDispatcher = request.getRequestDispatcher("sucesso.html");
				requestDispatcher.forward(request, response);
			} else {
				requestDispatcher = request.getRequestDispatcher("falha.html");
				requestDispatcher.forward(request, response);
			}
		}

		if (request_URI.endsWith("delete.do")) {
			int id = Integer.parseInt(request.getParameter("id"));
			NoticiaService nts = new NoticiaService();
			nts.excluirComentario(id);
			nts.excluir(id);
			requestDispatcher = request.getRequestDispatcher("sucesso.html");
			requestDispatcher.forward(request, response);
		}

		if (request_URI.endsWith("noticia.do")) {
			int id = Integer.parseInt(request.getParameter("id"));
			NoticiaService nts = new NoticiaService();
			Noticia noticia = nts.carregar(id);
			request.setAttribute("noticia", noticia);
			requestDispatcher = request.getRequestDispatcher("listanoticia.jsp");
			requestDispatcher.forward(request, response);
			response.setContentType("text/html;charset=ISO-8859-1");

		}
		
		if (request_URI.endsWith("addComent.do")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String nomeUser = request.getParameter("nomeUser");
			String comentarioUser = request.getParameter("comentarioUser");
			NoticiaService nts = new NoticiaService();

			Comentario comentario = new Comentario();
			comentario.setIdNoticia(id);
			comentario.setNome(nomeUser);
			comentario.setTexto(comentarioUser);
			
			nts.criarComentario(comentario);
			response.setContentType("text/html;charset=ISO-8859-1");
			response.sendRedirect("noticia.do?id="+id);
		}
	}

}
