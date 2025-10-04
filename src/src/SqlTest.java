//Essa classe trata sobre a conexão do sistema com o banco de dados.
package src;

import java.sql.*;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SqlTest
{
    private static final String USUARIO = "test1";
    private static final String SENHA = "b123";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/Homework01";
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

    // Chamada com todos os elementos de Categorias. Teste de busca no banco de dados
    public List<Categoria> Buscar(Categoria c) throws Exception
    {

        Categoria cat = new Categoria();

        cat.setId_Categoria(c.getId_Categoria());

        String sql = "Select id_categoria, " +
                            "nome, " +
                            "descricao " +
                        "from CATEGORIAS " +
                        "where id_categoria = " + cat.getId_Categoria() + ";";

        Connection conn = SqlTest.Abrir();

        Statement comando = conn.prepareStatement(sql);

        ResultSet resultado = comando.executeQuery(sql);

        List<Categoria> lista = new ArrayList<Categoria>();

        while(resultado.next()) // Preenchendo Lista
        {
            Categoria categoria = new Categoria();

            categoria.setId_Categoria(resultado.getInt("id_Categoria"));
            categoria.setNome(resultado.getString("nome"));
            categoria.setDescricao(resultado.getString("descricao"));

            System.out.print(categoria.getNome());
            System.out.print("   ");        //Espaçamento
            System.out.println(categoria.getDescricao());

            lista.add(categoria);
        }

        resultado.close();
        comando.close();
        conn.close();

        return lista;
    }

    // Cadastro de categoria

    public static void Cadastrar(Categoria c) throws Exception
    {

        String sql = "Insert into CATEGORIAS ('nome', '" +
                                             "'descricao') " +
                                    "values (" +
                                            c.getNome() + ", " +
                                            c.getDescricao() + ")";

        Connection conn = SqlTest.Abrir();

        Statement comando = conn.prepareStatement(sql);

        ResultSet resultado = comando.executeQuery(sql);


        System.out.print(c.getNome());
        System.out.println(c.getDescricao());

        resultado.close();
        comando.close();
        conn.close();
    }
    
    //Exibir eventos que um usuário participou  
    public static void BuscaEvUs(int IdUsuario) throws Exception
    {
    	String sql = "Select  U.id_usuario, \n"
    			+ "        U.nome, \n"
    			+ "        E.id_evento, \n"
    			+ "        E.nome,\n"
    			+ "        E.data\n"
    			+ "  FROM EVENTO_USUARIO AS EU\n"
    			+ "        Inner join USUARIO as U on U.id_usuario = EU.id_usuario\n"
    			+ "        Inner join EVENTO as E on EU.id_evento = E.id_evento \n"
    			+ "  where E.id_evento = " + IdUsuario + ";";
    	
    	Connection conn = SqlTest.Abrir();
    	
    	Statement comando = conn.prepareStatement(sql);
        //comando.setString();

        ResultSet resultado = comando.executeQuery(sql);

        while(resultado.next())
        {
        	System.out.println("ID do Usuário: " + resultado.getInt("U.id_usuario") + " | " + 
        					  " ID do Evento: " + resultado.getInt("E.id_Evento") +   " | " +
        					  " Data: " + resultado.getString("E.data") + "\n");
        }
    	
        resultado.close();
        comando.close();
        conn.close();    	
    }

    //Chamada com todos os elementos de Eventos. Teste de busca no banco de dados
    public List<Eventos> Buscar(Eventos c) throws Exception
    {
        String sql = "Select * from Eventos";

        Connection conn = SqlTest.Abrir();

        Statement comando = conn.prepareStatement(sql);

        ResultSet resultado = comando.executeQuery(sql);

        List<Eventos> lista = new ArrayList<Eventos>();

        while(resultado.next()) // Preenchendo Lista
        {
            Eventos linha = new Eventos();

            linha.setId_Evento(resultado.getInt("id_Evento"));
            linha.setNome(resultado.getString("nome"));
            linha.setLocalDate(resultado.getString("Data"));
            linha.setEndereco(resultado.getString("endereco"));
            linha.setId_Categoria(resultado.getInt("id_Categorias"));
            linha.setHorario(resultado.getString("horario"));

            System.out.println(linha.getId_Evento());
            System.out.println(linha.getNome());
            System.out.println(linha.getLocalDate());
            System.out.println(linha.getEndereco());
            System.out.println(linha.getId_Categoria());
            System.out.println(linha.getHorario());

            lista.add(linha);
        }

        resultado.close();
        comando.close();
        conn.close();

        return lista;
    }

    // Chamada com todos os elementos de Usuario. Teste de busca no banco de dados

    public List<Usuario> Buscar(Usuario c) throws Exception
    {
        String sql = "Select * from Usuario";
        Connection conn = SqlTest.Abrir();

        Statement comando = conn.prepareStatement(sql);

        ResultSet resultado = comando.executeQuery(sql);

        List<Usuario> lista = new ArrayList<Usuario>();

        while(resultado.next()) // Preenchendo Lista
        {
            Usuario linha = new Usuario();

            linha.setId_Usuario(resultado.getInt("id_Usuario"));
            linha.setNome(resultado.getString("Nome"));
            linha.setIdade(resultado.getInt("Idade"));
            linha.setEndereco(resultado.getString("Endereco"));

            System.out.println(linha.getId_Usuario());
            System.out.println(linha.getNome());
            System.out.println(linha.getIdade());
            System.out.println(linha.getEndereco());

            lista.add(linha);
        }

        resultado.close();
        comando.close();
        conn.close();

        return lista;
    }

    // Chamada para buscar todos os usuários de um evento

    public List<Evento_Usuario> Buscar(Evento_Usuario eu) throws Exception
    {
        Evento_Usuario usu = new Evento_Usuario();

        usu.setId_EveUsu(eu.getId_EveUsu());

        String sql = "Select id_evento, " +
                            "id_usuario " +
                        "from EVENTO_USUARIO " +
                        "where id_evento = " + usu.getId_EveUsu() + ";";

        Connection conn = SqlTest.Abrir();

        Statement comando = conn.prepareStatement(sql);

        ResultSet resultado = comando.executeQuery(sql);

        List<Evento_Usuario> lista = new ArrayList<Evento_Usuario>();

        while(resultado.next()) // Preenchendo Lista
        {
            Evento_Usuario evento_usuario = new Evento_Usuario();

            evento_usuario.setId_EveUsu(resultado.getInt("id_Evento"));
            evento_usuario.setId_UsuEve(resultado.getInt("id_Usuario"));

            System.out.print(evento_usuario.getId_EveUsu());
            System.out.print("   ");        //Espaçamento
            System.out.println(evento_usuario.getId_UsuEve());

            lista.add(evento_usuario);
        }

        resultado.close();
        comando.close();
        conn.close();

        return lista;
    }

    public void SQLExecutar(String texto)
    {
        try
        {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/homework01",
                    "test1",
                    "b123"
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
                    "jdbc:mysql://127.0.0.1:3306/Homework01",
                    "test1",
                    "b123"
            );

            System.out.println("Conectou");

            Statement statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void CadastrarCategorias(Categoria categoria) throws SQLException, Exception
    {
        String sql = "Insert into CATEGORIAS (nome, " +
                                             "descricao)" +
                                    "values (?,?)";

        Connection conn = SqlTest.Abrir();

        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1, categoria.getNome());
        preparedStatement.setString(2,categoria.getDescricao());

        preparedStatement.executeUpdate();

        System.out.print(categoria.getNome());
        System.out.println(categoria.getDescricao());

        preparedStatement.close();
        conn.close();
    }

    public static void CadastrarEvento(Eventos evento) throws Exception, SQLException
    {
        String sql =
                "Insert into EVENTO " +
                        "(nome, " +
                        "endereco, " +
                        "data, " +
                        "categoria, " +
                        "id_CATEGORIA, " +
                        "horario) " +

                    "values (?,?,?,?,?,?)";

        Connection conn = SqlTest.Abrir();

        Date data = Date.valueOf(evento.getLocalDate());

        System.out.println(evento.getId_Categoria());

        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        /*
        preparedStatement.setString(1, "aa");
        preparedStatement.setString(2, "bb");
        preparedStatement.setDate(3, data);
        preparedStatement.setString(4, "dd");
        preparedStatement.setInt(5, 1);
        preparedStatement.setString(6, "ff");
        */

        preparedStatement.setString(1, evento.getNome());
        preparedStatement.setString(2, evento.getEndereco());
        preparedStatement.setDate(3, data);
        preparedStatement.setString(4, evento.getCategoria());
        preparedStatement.setInt(5, evento.getId_Categoria());
        preparedStatement.setString(6, evento.getHorario());

        try
        {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println(evento.getNome());
        System.out.println(evento.getEndereco());
        System.out.println(evento.getLocalDate());
        System.out.println(evento.getId_Categoria());
        System.out.println(evento.getCategoria());
        System.out.println(evento.getHorario());

        preparedStatement.close();
        conn.close();
    }

    public static void CadastrarUsuario(Usuario usuario) throws SQLException, Exception
    {
        String sql =
                "Insert into USUARIO " +
                        "(nome, " +
                        "endereco, " +
                        "idade) " +
                    "values (?,?,?);";

        Connection conn = SqlTest.Abrir();

        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1, usuario.getNome());
        preparedStatement.setString(2, usuario.getEndereco());
        preparedStatement.setInt(3, usuario.getIdade());

        preparedStatement.executeUpdate();

        System.out.print(usuario.getId_Usuario());
        System.out.print(usuario.getNome());
        System.out.println(usuario.getEndereco());
        System.out.println(usuario.getIdade());

        preparedStatement.close();
        conn.close();
    }

    public static void CadastrarEvento_Usuario(Evento_Usuario evento_usuario) throws SQLException, Exception 
    {
        String sql = "Insert into EVENTO_USUARIO (" +
                                                    "id_evento, " +
                                                    "id_usuario)" +
                                    "values (?,?)";

        Connection conn = SqlTest.Abrir();

        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setInt(1, evento_usuario.getId_EveUsu());
        preparedStatement.setInt(2, evento_usuario.getId_UsuEve());

        preparedStatement.executeUpdate();

        System.out.print(evento_usuario.getId_EveUsu());
        System.out.println(evento_usuario.getId_UsuEve());

        preparedStatement.close();
        conn.close();
    }
}
