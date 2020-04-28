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
	
	<!--estiloLista.css-->
<link rel="stylesheet" href="css/estiloLista.css" />
	
</head>
<%
	int id = Integer.parseInt(request.getParameter("id"));
	NoticiaService nts = new NoticiaService();
	Noticia noticia = nts.carregar(id);

	ArrayList<Comentario> cm = nts.listaNoticiasComentario();
	ArrayList<Noticia> nt = nts.listagem();

%>
<body>

	<div id="voltar" class="vertical-menu">
	  <a href="listagem.jsp" class="active">Voltar para notícias</a>
	</div>
	
	  <h2 class="display-4">Wallnews</h2>
	
	<hr class="my-7">
	
		<div class="card">
	  		<div class="card-header">
	    		
				<input type="hidden" name="id" value="<%=noticia.getId()%>"/>
				<h3><%=noticia.getTitulo()%></h3>
	  		</div>
		  <div class="card-body">
		    <blockquote class="blockquote mb-0">
		      <h6 class="lead"><%=noticia.getTexto()%></h6>
		    </blockquote>
		  </div>
		</div>
		
		<%
		
		
		ArrayList<NoticiaComentario> nc = new ArrayList<NoticiaComentario>();
		ArrayList<NoticiaComentario> comentarioNt = new ArrayList<NoticiaComentario>();
		
	for (int i = 0; i < nt.size(); ++i) {
		NoticiaComentario not = new NoticiaComentario();
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
					<h4>Comentários</h4>
					<%
					if(comentarioNt.get(d).getComentario() != null){
					for (int c = 0; c < comentarioNt.get(d).getComentario().size(); ++c) {
						System.out.println("Nome: "+comentarioNt.get(d).getComentario().get(c).getNome());
					%>
					<p class="card-text"><%=comentarioNt.get(d).getComentario().get(c).getNome()%></p>
					<p class="card-text"><%=comentarioNt.get(d).getComentario().get(c).getTexto()%></p>
					<hr class="my-7">
						
					<% } }%>
					<form action="addComent.do" method="GET">
						<h6>Adicionar comentário:</h6>
							Nome: <input type="text" class="form-control" id="nomeUser" name="nomeUser"> <br> 
							Comentário: <input type="text" class="form-control" id="comentarioUser" name="comentarioUser"> <br> 
							<input type='hidden' name='id' value='<%=comentarioNt.get(d).getIdNoticia()%>'>
							<input type="submit" class="btn btn-primary" type="submit" value="Enviar">
					</form>
				</div>
					<%
						}
					%>
	
	
</body>
</html>
