// 20/06/2025 Adicionar query para cada chamada na variável texto antes de ser executada


package src;

import java.sql.*;
import java.sql.Statement;

public class SqlTest
{
    Statement statement;

    public String setNome_Categorias(String nome)
    {
        String texto = "insert into categorias(nome) values (" + nome +" )";
        return texto;
    }

    public String getNome_Categorias(ResultSet resultSet)
    {
        String texto = resultSet.getString("nome");
        return texto;
    }

    public String setDescricao_Categorias(String nome)
    {
        String texto = "insert into categorias(nome) values (" + nome +" )";
        return texto;
    }



    public String getDescricao_Categorias(ResultSet resultSet)
    {
        String texto = resultSet.getString("descricao");
        return texto;
    }

    public void SQLExecutar(String texto)
    {
        try
        {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/homework01",
                    "teta",
                    "1234"

            );

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(texto);  // Execução de Query

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void SQLChamada()
    {
        try
        {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/homework01",
                    "teta",
                    "1234"

            );

            System.out.println("Conectou");

            Statement statement = connection.createStatement();

            String texto = "Select * from categorias"; // variável com a query a ser executada

            ResultSet resultSet = statement.executeQuery(texto);  // Execução de Query

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    /*public static void CadCatDescricao(Connection connection, String descricao)                   // Cadastro da coluna Descricao na tabela Categorias
    {

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("Select  from categorias");



        while (resultSet.next())
        {

            System.out.println(resultSet.getString("nome"));
            System.out.println(resultSet.getString("descricao"));
        }
    }*/
}
