package com.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Model.Produto;

public class Repository {

    private String db_url;
    private String db_user;
    private String db_password;

    public Repository(String db_url, String db_user, String db_password) {
        this.db_url = db_url;
        this.db_user = db_user;
        this.db_password = db_password;
    }

    public void cadastrarProduto(Produto p) {
        String create = "INSERT INTO produtos (nome, categoria, valor, quantidade) values (?, ?, ?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection(db_url, db_user, db_password);
            PreparedStatement pst = c.prepareStatement(create);
            pst.setString(1, p.getNome());
            pst.setString(2, p.getCategoria());
            pst.setDouble(3, p.getValor());
            pst.setInt(4, p.getQuantidade());
            pst.executeUpdate();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Produto> consultarProdutos() {
        List<Produto> listaProdutos = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection(db_url, db_user, db_password);
            PreparedStatement ps = c.prepareStatement("SELECT * FROM produtos");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Produto pAux = new Produto();
                pAux.setId(resultSet.getInt("id"));
                pAux.setNome(resultSet.getString("nome"));
                pAux.setCategoria(resultSet.getString("categoria"));
                pAux.setValor(resultSet.getDouble("valor"));
                pAux.setQuantidade(resultSet.getInt("quantidade"));
                listaProdutos.add(pAux);
            }
            c.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Falha ao conectar ao MySql" + e.getMessage());
        }
        return listaProdutos;
    }
    
    public void excluirProduto(int id) {
	    String query_delete = "DELETE FROM produtos WHERE id = ?";

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection c = DriverManager.getConnection(db_url, db_user, db_password);
	        PreparedStatement ps = c.prepareStatement(query_delete);
	        ps.setInt(1, id);
	        ps.executeUpdate();
	        ps.close();
	        c.close();
	    } catch (SQLException | ClassNotFoundException e) {
	        System.out.println("Falha ao excluir o produto: " + e.getMessage());
	    }
	}
    
    public Produto buscarProdutoPorId(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Produto produto = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jvl", "root", "");
            String query = "SELECT * FROM produtos WHERE id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String categoria = resultSet.getString("categoria");
                double valor = resultSet.getDouble("valor");
                int quantidade = resultSet.getInt("quantidade");
                produto = new Produto(nome, categoria, valor, quantidade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        produto.setId(id);
        return produto;
    }

    public void atualizarProduto(Produto produto) {
        try (Connection connection = DriverManager.getConnection(db_url, db_user, db_password)) {
            String sql = "UPDATE produtos SET nome = ?, categoria = ?, valor = ?, quantidade = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, produto.getNome());
            statement.setString(2, produto.getCategoria());
            statement.setDouble(3, produto.getValor());
            statement.setInt(4, produto.getQuantidade());
            statement.setInt(5, produto.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
