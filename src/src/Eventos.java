// 22/06/2025 Adicionado o cadastro de Eventos no SQL, entretanto necessita do tratamento de valores data
// 24/06/2025 Cadastro de evento concluído
// 24/06/2025 Tratamento de campo do tipo date em progresso. Resta apenas retorno da informação do banco de dados. sql.Date para LocalDate para String

package src;

//import java.util.Scanner;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.sql.SQLException;
import java.time.*;

public class Eventos
{

    private int id_Evento;
    private String nome;
    private String endereco;
    private String categoria;
    private int id_Categoria;
    /*private String descricao;*/
    private String horario;
    private String localDate;

    static Eventos eventos = new Eventos();

    public void setId_Evento(int id_Evento)
    {
        this.id_Evento = id_Evento;
    }

    public int getId_Evento()
    {
        return id_Evento;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getNome()
    {
        return nome;
    }

    public void setEndereco(String endereco)
    {
        this.endereco = endereco;
    }

    public String getEndereco()
    {
        return endereco;
    }

    public void setLocalDate(String localDate)
    {
        this.localDate = localDate;
    }

    public String getLocalDate()
    {
        return localDate;
    }

    public void setCategoria(String categoria)
    {
        this.categoria = categoria;
    }

    public String getCategoria()
    {
        return categoria;
    }

    public void setId_Categoria(int id_Categoria)
    {
        this.id_Categoria = id_Categoria;
    }

    public int getId_Categoria()
    {
        return id_Categoria;
    }
/*
    public void setDescricao(String descricao )
    {
        this.descricao = descricao;
    }

    public String getDescricao()
    {
        return descricao;
    }
*/
    public void setHorario(String horario)
    {
        this.horario = horario;
    }

    public String getHorario()
    {
        return horario;
    }

   public static void Atualizar(String nome, String endereco, String categoria, String descricao, String horario)
   {
       eventos = new Eventos();

       eventos.setNome(nome);
       eventos.setEndereco(endereco);
       eventos.setCategoria(categoria);
       //eventos.setDescricao(descricao);
       eventos.setHorario(horario);

       System.out.println("\n" + "Evento: " + nome);
       System.out.println("\n" + "Endereco: " + endereco);
       System.out.println("\n" + "Categoria: " + categoria);
       //System.out.println("\n" + "Descrição do Evento: " + descricao);
       System.out.println("\n" + "Horario: " + horario);

       System.out.println("\nAtualização Efetuada");

   }

   public static void Verificar()
   {

       String nome = eventos.getNome();
       String endereco = eventos.getEndereco();
       String categoria = eventos.getCategoria();
       //String descricao = eventos.getDescricao();
       String horario = eventos.getHorario();

       System.out.println("\n" + "Nome: " + nome);
       System.out.println("\n" + "Endereco: " + endereco);
       System.out.println("\n" + "Categoria: " + categoria);
      // System.out.println("\n" + "Descrição do Evento: " + descricao);
       System.out.println("\n" + "Horario: " + horario);

       System.out.println("\n'Verificação' Efetuada");

   }

   public void Registro() throws Exception, SQLException
   {

       eventos = new Eventos();

		//					Cadastro através do JOptionPane

       String nome = JOptionPane.showInputDialog("Digite o nome do Evento:\n");
       String endereco = JOptionPane.showInputDialog("Digite o endereco:\n");
       String auxLocalDate = JOptionPane.showInputDialog("Digite a data (YYYY-MM-DD):\n");
       String categoria = JOptionPane.showInputDialog("Digite a categoria desejada:\n");
       int id_Categoria = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da categoria desejada:\n"));
       //String descricao = JOptionPane.showInputDialog("Digite a descrição do evento:\n");
       String horario = JOptionPane.showInputDialog("Digite o horário:\n");

       //LocalDate localDate = LocalDate.parse(auxLocalDate); // Converter String para LocalDate para sql.Date




		//               Preenchendo o objeto

       eventos.setNome(nome);
       eventos.setEndereco(endereco);
       eventos.setLocalDate(auxLocalDate);
       eventos.setCategoria(categoria);
       eventos.setId_Categoria(id_Categoria);
       //eventos.setDescricao(descricao);
       eventos.setHorario(horario);

		System.out.println("\n" + "Nome: " + eventos.getNome());
		System.out.println("\n" + "Endereco: " + eventos.getEndereco());
		System.out.println("\n" + "Data: " + eventos.getLocalDate());
        System.out.println("\n" + "Categoria: " + eventos.getCategoria());
        System.out.println("\n" + "ID da Categoria: " + eventos.getId_Categoria());
		//System.out.println("\n" + "Descrição do Evento: " + descricao);
		System.out.println("\n" + "Horario: " + eventos.getHorario());

        SqlTest.CadastrarEvento(eventos);

		System.out.println("\nCadastro Efetuado");

	}

}

