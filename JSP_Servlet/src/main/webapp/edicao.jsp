<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="com.Model.Produto" %>
<%@ page import="java.util.ArrayList" %>

<%
Produto produto = (Produto) request.getAttribute("produto");
%>

<!DOCTYPE html>
<html>
<head lang="pt-br">
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <meta charset="utf-8">
    <title>Cadastro de Pessoas</title>
    <link rel="stylesheet" href="./style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous"/>
    <link rel="stylesheet" href="./style.css"/>
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet"/>
</head>
<body>
<header>
    <div class="cabecalho" style ="display: flex; align-items: center;">
        <img class="logoheader" src="./a1.png" alt="" />
        <h1>LVJ Produtos</h1>
    </div>
</header>
    <div class="container container-cadastro">
    	<div class="row">
            <form class="" method="POST" action="atualizar">
  				<input type="hidden" name="productId" value="<%= produto.getId() %>">
  				<div class="form-group mb-3">
    				<label for="name-product">Nome</label>
    				<input type="text" class="form-control" name="nome" placeholder="Nome do produto" required value="<%= produto.getNome() %>">
  				</div>
  				<div class="form-group mb-3">
              		<label for="name-product">Categoria</label>
            		<input type="text" class="form-control" name="categoria" placeholder="Categoria do produto" value="<%= produto.getCategoria() %>">
           		</div>    
            	<div class="form-group mb-3">
               		<div class="input-group-prepend">Valor</div>
               		<input type="text" class="form-control" name="valor" placeholder="Valor do produto" required value="<%= produto.getValor() %>">
            	</div>
            	<div class="form-group mb-3">
                	<div class="input-group-prepend">Quantidade</div>
                	<input type="text" class="form-control" name="quantidade" placeholder="Quantidade do produto" required value="<%= produto.getQuantidade() %>">
            	</div>
            	<div class = btns-edits style="display:flex; gap:10px; justify-content:center;">
  			<button type="submit" class="btn btn-outline-success mt-3">Gravar</button>
</form>
             
            
            <form class="" method="POST" action="listar">
            	<button type="submit" class="btn btn-outline-info mt-3">Voltar</button>
            </form>
            </div>
      	</div>
      </div>
    <footer>
        <div class="footer-container">
          <h2>Design by Lucas, Victor & João Victor</h2>
        </div>
      </footer>
    </body>
</html>