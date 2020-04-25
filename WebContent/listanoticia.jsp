<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="service.NoticiaService"%>
<%@page import="model.Comentario"%>
<%@page import="model.Noticia"%>
<%@page import="model.NoticiaComentario"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listagem</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<%
	NoticiaService nts = new NoticiaService();
ArrayList<Comentario> cm = nts.listaNoticiasComentario();
ArrayList<Noticia> nt = nts.listagem();
%>
<body>
	<h2>Listagem de Noticias</h2>
	<div class="container">
		<div class="jumbotron jumbotron-fluid">
			<div class="card">
				<%
					ArrayList<NoticiaComentario> nc = new ArrayList<NoticiaComentario>();
					ArrayList<NoticiaComentario> comentarioNt = new ArrayList<NoticiaComentario>();

				for (int i = 0; i < nt.size(); ++i) {
					NoticiaComentario not = new NoticiaComentario();
					not.setIdNoticia(nt.get(i).getId());
					not.setTitulo(nt.get(i).getTitulo());
					not.setDescricao(nt.get(i).getDescricao());
					not.setTexto(nt.get(i).getTexto());
					ArrayList<Comentario> lstComentario = new ArrayList<Comentario>();

					for (int n = 0; n < cm.size(); ++n) {
						Comentario coment = new Comentario();
						
                        if (nt.get(i).getId() == cm.get(n).getIdNoticia()) {
							coment.setIdComentario(i);
	                        coment.setIdNoticia(cm.get(n).getIdNoticia());
	                        coment.setNome(cm.get(n).getNome());
	                        coment.setTexto(cm.get(n).getTexto());
	                        lstComentario.add(coment);
	                        not.setComentario(lstComentario);
                        }
					}
					comentarioNt.add(i, not);

				}

				for (int d = 0; d < comentarioNt.size(); ++d) {
				%>
				<div class="card-body">
					<h5 class="card-title"><%=comentarioNt.get(d).getTitulo()%></h5>
					<p class="card-text"><%=comentarioNt.get(d).getDescricao()%></p>
					
					<%
					if(comentarioNt.get(d).getComentario() != null){
					for (int c = 0; c < comentarioNt.get(d).getComentario().size(); ++c) {
						System.out.println("Nome: "+comentarioNt.get(d).getComentario().get(c).getNome());
					%>
					<p class="card-text">Nome: <%=comentarioNt.get(d).getComentario().get(c).getNome()%></p>
					<p class="card-text">Comentario: <%=comentarioNt.get(d).getComentario().get(c).getTexto()%></p>
						
					<% } }%>
					<form action="addComent.do" method="GET">
							Nome: <input type="text" class="form-control" id="nomeUser" name="nomeUser"> <br> 
							Comentário: <input type="text" class="form-control" id="comentarioUser" name="comentarioUser"> <br> 
							<input type='hidden' name='id' value='<%=comentarioNt.get(d).getIdNoticia()%>'>
							<input type="submit" class="btn btn-primary" type="submit" value="Adicionar Comentário">
						</form>
				</div>
					<%
						}
					%>

				</div>
			</div>
</body>
</html>
