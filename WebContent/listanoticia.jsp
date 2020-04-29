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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listagem</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
	
	<!--estiloLista.css-->
<link rel="stylesheet" href="css/estilo.css" />
	
</head>
<%
	int id = Integer.parseInt(request.getParameter("id"));
	NoticiaService nts = new NoticiaService();
%>
<body>

	<div id="voltar" class="vertical-menu">
	  <a href="listagem.jsp" class="active">Voltar para not�cias</a>
	</div>
	
	  <h2 class="display-4">Wallnews</h2>
	
	<hr class="my-7">
	
		<div class="card">
	  		<div class="card-header">
				<input type="hidden" name="id" value="${noticia.id}"/>
				<h3>${noticia.titulo}</h3>
	  		</div>
			<div class="card-body">
			      <p class="lead">${noticia.texto}</p>
			</div>
		</div>
			<div class="card-body">
				<h3>Coment�rios</h3>
				<%
					for (Comentario cm : nts.listaNoticiasComentario(id)) {
				%>
				<p class="card-text"><%=cm.getNome()%></p>
				<p class="card-text"><%=cm.getTexto()%></p>
				<hr class="my-7">
				<%
					}
				%>
				<form action="addComent.do" method="GET">
					<h4>Adicionar coment�rio:</h4>
						Nome: <input type="text" class="form-control" id="nomeUser" name="nomeUser"> <br> 
						Coment�rio: <input type="text" class="form-control" id="comentarioUser" name="comentarioUser"> <br> 
						<input type='hidden' name='id' value='${noticia.id}'>
						<p class="lead">
							<input type="submit" id="enviar" class="btn btn-primary" type="submit" value="Enviar">
						</p>
				</form>
			</div>
	
	
</body>
</html>
