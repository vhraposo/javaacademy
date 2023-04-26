
import java.sql.*;
import java.util.Scanner;

public class BancoDados implements InterfaceBancoDados{
    private Connection c;
    public static void main(String[] args) {
        final String db_url = "jdbc:mysql://localhost:3306/bancojdbc";
        final String db_query = "SELECT * FROM pessoa";
        final String db_user = "root";
        final String db_password = "";

        Scanner reader = new Scanner(System.in);
        int numberSelected = 0;

        System.out.print("|-----------------------------|\n");
        System.out.println("| 1 - Inserir |");
        System.out.println("| 2 - Alterar |");
        System.out.println("| 3 - Excluir |");
        System.out.println("| 4 - Consultar |");
        System.out.println("| 5 - Desconectar |");
        System.out.println("Digite 999 para encerrar o programa");
        System.out.print("|-----------------------------|\n");

        numberSelected = reader.nextInt();
        BancoDados bd = new BancoDados();
        bd.conectar(db_url, db_user, db_password);

        final String query_consulta = "SELECT * FROM pessoa";

        switch(numberSelected){

            case 1:
                String name;
                String email;
                System.out.println("Informe um nome : ");
                reader.nextLine();
                name = reader.nextLine();
                System.out.println("Informe um email : ");
                email = reader.nextLine();

                bd.inserirAlterarExcluir("INSERT INTO pessoa(nome, email) VALUES (" + "'" + name + "'" + "," + "'" + email + "'" + ")");
                return;
            case 2:
                bd.consultar(query_consulta);
                System.out.println("Selecione o id do usuário que deseja alterar :");
                int idUser = reader.nextInt();
                String nameAlt;
                String emailAlt;
                System.out.println("Informe o novo nome");
                reader.nextLine();
                nameAlt = reader.nextLine();
                System.out.println("Informe o novo email");
                emailAlt = reader.nextLine();

                bd.inserirAlterarExcluir("UPDATE pessoa SET nome = "+ "'" + nameAlt + "'" + "," + "email = " + "'" + emailAlt + "'" + " WHERE id = " + idUser);

            case 3:
                bd.consultar(query_consulta);
                System.out.println("Selecione o id do usuário que você deseja deletar");
                int idUserDel = reader.nextInt();

                bd.inserirAlterarExcluir("DELETE FROM pessoa WHERE id = " + idUserDel);

            case 4:
                bd.consultar(query_consulta);

            case 5:
                bd.desconectar();

        }

        reader.close();

    }
    @Override
    public void conectar(String db_url, String db_user, String db_password){

        try {
            c = DriverManager.getConnection(db_url, db_user, db_password);
            System.out.println("Conectado ao DB");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Não Foi possivel conectar ao DB");
        }
    }

   @Override
    public void desconectar() {
        try {
            c.close();
            System.out.println("Você fez logout com sucesso!");
        } catch (SQLException e) {
            System.out.println("Não foi possível desconectar do banco de dados.");
            e.printStackTrace();
        }
    }

    @Override
    public void consultar(String db_query) {
        try {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(db_query);
            while(rs.next()) {
             System.out.println(rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3));
        }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Não foi possível consultar o banco de dados.");
            e.printStackTrace();
        }
    }

    @Override
    public int inserirAlterarExcluir(String db_query) {
        int rowsAffected = 0;
        try {
            Statement stmt = c.createStatement();
            rowsAffected = stmt.executeUpdate(db_query);
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Não foi possível executar a operação de inserção/alteração/exclusão no banco de dados.");
            e.printStackTrace();
        }
        System.out.println(rowsAffected + " linhas foram afetadas.");
        return rowsAffected;
    }
    }






