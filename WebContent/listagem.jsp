<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="service.NoticiaService"%>
<%@page import="model.Noticia"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<!--estiloLista.css-->
<link rel="stylesheet" href="css/estilo.css" />

<title>Listagem</title>
</head>
<body>

	<div id="voltar" class="vertical-menu">
	  <a href="index.html" class="active">Voltar para o início</a>
	</div>
	
	<h2>Notícias Wallnews</h2>

		<tbody>
			<%
			NoticiaService nts = new NoticiaService();
			for (Noticia nt : nts.listagem()) {
			%>
			<tr>
				<a href="noticia.do?id=<%=nt.getId()%>" class="list-group-item list-group-item-action">
				    <div class="d-flex w-100 justify-content-between">
				      <h5 class="mb-1"><td><%=nt.getTitulo()%></td></h5>
				      <small>1 dia atrás</small>
				    </div>
				    <p class="mb-1"><td><%=nt.getDescricao()%></td>.</p>
				    <small><td><%=nt.getId()%></td></small>
			  	</a>
			  	<a href="editform.do?id=<%=nt.getId()%>">Editar</a> 
				<a href="delete.do?id=<%=nt.getId()%>">Deletar</a>
			</tr>
			<%
				}
			%>
	</tbody>

	<form method="POST" action="cadastro.html">
		<div class="form-button">
			<input id="addNoticia" type="submit" value="Adicionar outra Notícia" />
	 	</div>
	</form>

</body>
</html>