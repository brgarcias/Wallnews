<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="service.NoticiaService"%>
<%@page import="model.Noticia"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listagem</title>
</head>
<body>
	<h2>Listagem de Noticias</h2>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Titulo</th>
				<th>Descrição</th>
				<th>Texto</th>
				<th>Editar/Remover</th>
			</tr>
		</thead>
		<tbody>
			<%
			NoticiaService nts = new NoticiaService();
			for (Noticia nt : nts.listagem()) {
			%>
			<tr>
				<td><%=nt.getId()%></td>
				<td><%=nt.getTitulo()%></td>
				<td><%=nt.getDescricao()%></td>
				<td><%=nt.getTexto()%></td>

				<td><a href="editform.do?id=<%=nt.getId()%>"
					>Editar</a> 
					<a href="delete.do?id=<%=nt.getId()%>"
					>Deletar</a></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>

</body>
</html>