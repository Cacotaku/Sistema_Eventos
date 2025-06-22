// 20/06/2025 Adicionar query para cada chamada na variável texto antes de ser executada
// 21/06/2025 Método Busca está buscando campos da tabela Categoria. Replicar lógica para outras tabelas


package src;

import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class SqlTest
{
    private static final String USUARIO = "teta";
    private static final String SENHA = "1234";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/homework01";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    // Conectar ao banco
    public static Connection Abrir() throws Exception
    {
        // Registrar o driver
        Class.forName(DRIVER);
        // Capturar a conexão
        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
        // Retorna a conexao aberta
        return conn;
    }

    public List<Categoria> Buscar(Categoria c) throws Exception
    {

        String sql = "Select * from Categorias";
        Connection conn = SqlTest.Abrir();

        Statement comando = conn.prepareStatement(sql);
        //comando.setString();

        ResultSet resultado = comando.executeQuery(sql);

        List<Categoria> lista = new ArrayList<Categoria>();

        while(resultado.next()) // Preenchendo Lista
        {
            Categoria linha = new Categoria();

            linha.setId_Categoria(resultado.getInt("id_Categoria"));
            linha.setNome(resultado.getString("nome"));
            linha.setDescricao(resultado.getString("descricao"));

            System.out.print(linha.getNome());
            System.out.println(linha.getDescricao());

            lista.add(linha);
        }

        resultado.close();
        comando.close();
        conn.close();

        return lista;

    }

    //Statement statement;

    public String setNome_Categorias(String nome)
    {
        String texto = "insert into categorias(nome) values (" + nome +" )";
        return texto;
    }

    /*public String getNome_Categorias(ResultSet resultSet)
    {
        String texto = resultSet.getString("nome");
        return texto;
    }*/

    public String setDescricao_Categorias(String nome)
    {
        String texto = "insert into categorias(nome) values (" + nome +" )";
        return texto;
    }



    /*public String getDescricao_Categorias(ResultSet resultSet)
    {
        String texto = resultSet.getString("descricao");
        return texto;
    }*/

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

    public static void CadastrarCategorias(String nome, String descricao) throws SQLException {
        String texto =
                "Insert into Categorias " +
                        "('nome', " +
                        "'descricao') " +
                    "values (" +
                        nome + "," +
                        descricao + " );";
    }

    public static void CadastrarEvento(String nome, String endereco, String data, String categoria, int id_CATEGORIA, String horario) throws SQLException
    {
        String texto =
                "Insert into Evento " +
                        "('nome', " +
                        "'endereco', " +
                        "'data', " +
                        "'categoria' " +
                        "'id_CATEGORIA', " +
                        "'horario') " +

                    "values (" +

                        nome + "," +
                        endereco + "," +
                        data + "," +
                        categoria + "," +
                        id_CATEGORIA + "," +
                        horario + " );";
    }

    public static void CadastrarUsuario(String nome, String endereco, int idade) throws SQLException
    {
        String texto =
                "Insert into Evento " +
                        "('nome', " +
                        "'endereco', " +
                        "'idade', " +
                        "'categoria' " +
                        "'id_CATEGORIA', " +
                        "'horario') " +

                    "values (" +

                        nome + "," +
                        endereco + "," +
                        idade + " );";
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
