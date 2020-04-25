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
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();

				out.println("<html>");
				out.println("<head>");
				out.println("<!--estiloLista.css-->");
				out.println("<link rel='stylesheet'  href='<%=request.getContextPath()%>/css/estiloLista.css' type='text/css' />"); 
				out.println("<link rel='stylesheet'  href='<%=request.getContextPath()%>/css/bootstrap.css' type='text/css' />");
				out.println("<title>Editar notícia</title>");
				out.println("</head>");
				out.println("<body bgcolor='lightblue'>");
				out.println("<br><br><br>");
				out.println("<form method='POST' action='update.do'>");

				out.println("<table align='center'>");
				out.println("<tr><td>Noticia Id </td><td>" + noticia.getId() + "</td></tr>");
				out.println("<input type='hidden' name='id' value='" + noticia.getId() + "'/>");
				out.println("<tr><td>Titulo</td><td><input type='text' name='titulo' value='" + noticia.getTitulo()
						+ "'</td></tr>");
				out.println("<tr><td>Descrição</td><td><input type='text' name='descricao' value='"
						+ noticia.getDescricao() + "'</td></tr>");
				out.println("<tr><td>Texto</td><td><input type='text' name='texto' value='" + noticia.getTexto()
						+ "'</td></tr>");
				out.println("<tr><td><input type='submit' value='Atualizar'/></td></tr>");
				out.println("</table></form></body></html>");
			}
		}

		if (request_URI.endsWith("update.do")) {

			int id = Integer.parseInt(request.getParameter("id"));
			String titulo = request.getParameter("titulo");
			String descricao = request.getParameter("descricao");
			String texto = request.getParameter("texto");

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
			nts.excluir(id);
			requestDispatcher = request.getRequestDispatcher("sucesso.html");
			requestDispatcher.forward(request, response);
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
			requestDispatcher = request.getRequestDispatcher("listanoticia.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
