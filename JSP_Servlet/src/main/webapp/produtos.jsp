<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="com.Model.Produto" %>
    <%@page import="java.util.ArrayList" %>
    
    <%
        @ SuppressWarnings("unchecked")
            	ArrayList<Produto> lista = (ArrayList<Produto>) request.getAttribute("listaProdutos");
        %>
<!DOCTYPE html>
<html>
<head>
<link rel="preconnect" href="https://fonts.googleapis.com" />
 <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous" />
<meta charset="utf-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<title >Listagem de Produtos</title>
<link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet"/>
	<link rel="stylesheet" href = "style.css">

</head>
<body>
 <header>
        <div class="cabecalho" style ="display: flex; align-items: center;">
          <img class="logoheader" src="./a1.png" alt="" />
          <h1>LVJ Produtos</h1>
        </div>
    </header>
    
    <div class ="container">
	<h1 class="text-center mt-3 mb-5">Lista de Produtos Cadastrados</h1>
	<table class="table table-striped table-hover table-borderless align-middle">
		<thead>
			<tr>
              <th>Id</th>
              <th>Nome</th>
              <th>Categoria</th>
              <th>Valor</th>
              <th>Quantidade</th>
              <th colspan="2">Ações</th>
			</tr>
		</thead>
		<tbody>
			<% for(int i = 0; i < lista.size(); i++) { %>
    	<tr>
        	<td><%= lista.get(i).getId() %></td>
        	<td><%= lista.get(i).getNome() %></td>
        	<td><%= lista.get(i).getCategoria() %></td>
        	<td><%= lista.get(i).getValor() %></td>
        	<td><%= lista.get(i).getQuantidade() %></td>
        	<td>
            <form class="d-inline" method="post" action="edit">
                <button type="submit" name="productId_edicao" value="<%= lista.get(i).getId() %>" class="btn btn-outline-info text-dark">
                    <i class='bi bi-pencil-square'></i>
                </button>
            </form>
            <form class="d-inline" method="post" action="delete">
                <button type="submit" name="productId_exclusao" value="<%= lista.get(i).getId() %>" class="btn btn-outline-danger text-dark d-inline">
                    <i class='bi bi-trash'></i>
                </button>
            </form>
        </td>
    </tr>
<% } %>
		</tbody>
	</table>
	<button type="button" class="btn btn-outline-info backToHome text-dark"><a href="home">Voltar</a></button>
	</div>
	<footer>
        <div class="footer-container">
          <h2>Design by Lucas, Victor & João Victor</h2>
        </div>
      </footer>
</body>
</html>