package com.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model.Produto;
import com.Repository.Repository;

@WebServlet(urlPatterns = { "/inserir", "/listar", "/home", "/add", "/delete", "/edit", "/atualizar" })
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Repository r = new Repository("jdbc:mysql://localhost:3306/jvl", "root", "");

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getMethod();
		if (method.equals("POST")) {
			doPost(request, response);
		} else if (method.equals("GET")) {
			doGet(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/home")) {
			response.sendRedirect("index.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();

		if (path.equals("/add")) {
			response.sendRedirect("cadastrar.html");
		}

		if (path.equals("/inserir")) {
			  String nome = request.getParameter("nome");
			  String categoria = request.getParameter("categoria");
			  String valor = request.getParameter("valor");
			  String quantidade = request.getParameter("quantidade");
			  double valorDouble = Double.parseDouble(valor);
			  int quantidadeInt = Integer.parseInt(quantidade);
			  Produto p = new Produto(nome, categoria, valorDouble, quantidadeInt);
			  r.cadastrarProduto(p);

			  List<Produto> listaProdutos = r.consultarProdutos();
			  
			  request.setAttribute("listaProdutos", listaProdutos);
			  RequestDispatcher rd = request.getRequestDispatcher("produtos.jsp");
			  rd.forward(request, response);
			}

		if (path.equals("/listar")) {
			request.setAttribute("listaProdutos", listarProdutos());
			RequestDispatcher rd = request.getRequestDispatcher("produtos.jsp");
			rd.forward(request, response);
		}
		
		if (path.equals("/atualizar")) {
			String productId = request.getParameter("productId");
		    int id = Integer.parseInt(productId);
		    Produto produto = r.buscarProdutoPorId(id);
		    
		    String nome = request.getParameter("nome");
		    String categoria = request.getParameter("categoria");
		    String valor = request.getParameter("valor");
		    String quantidade = request.getParameter("quantidade");
		    double valorDouble = Double.parseDouble(valor);
		    int quantidadeInt = Integer.parseInt(quantidade);

		    produto.setNome(nome);
		    produto.setCategoria(categoria);
		    produto.setValor(valorDouble);
		    produto.setQuantidade(quantidadeInt);

		    r.atualizarProduto(produto);

		    request.setAttribute("listaProdutos", listarProdutos());
		    RequestDispatcher rd = request.getRequestDispatcher("produtos.jsp");
		    rd.forward(request, response);
		}
		
		
		if (path.equals("/edit")) {
		    String productId = request.getParameter("productId_edicao");
		    int id = Integer.parseInt(productId);
		    Produto produto = r.buscarProdutoPorId(id);
		    produto.setId(id);
		    
		    request.setAttribute("produto", produto);
		    RequestDispatcher rd = request.getRequestDispatcher("edicao.jsp");
		    rd.forward(request, response);
		}

		
		if (path.equals("/delete")) {
		    String productId = request.getParameter("productId_exclusao");
		    int id = Integer.parseInt(productId);
		    r.excluirProduto(id);
		    List<Produto> listaProdutos = listarProdutos();
		    request.setAttribute("listaProdutos", listaProdutos);
		    RequestDispatcher rd = request.getRequestDispatcher("produtos.jsp");
		    rd.forward(request, response);
		}
	}
	
	protected List<Produto> listarProdutos() {
		  List<Produto> listaProdutos = new ArrayList<>();
		  listaProdutos = r.consultarProdutos();

		  return listaProdutos;
		}
}
