<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="service.NoticiaService"%>
<%@page import="model.Noticia"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<!--bootstrap.css-->
<link rel="stylesheet" href="css/bootstrap.css" />

<!--estiloLista.css-->
<link rel="stylesheet" href="css/estiloLista.css" />

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
				<a href="listanoticia.jsp" class="list-group-item list-group-item-action">
				    <div class="d-flex w-100 justify-content-between">
				      <h5 class="mb-1"><td><%=nt.getTitulo()%></td></h5>
				      <small>3 days ago</small>
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
	
	<div id="addNoticia" class="vertical-menu">
	  <a href="cadastro.html">Adicionar outra Notícia</a>
	</div>

</body>
</html>