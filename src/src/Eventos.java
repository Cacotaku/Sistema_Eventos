package src;

//import java.util.Scanner;
import javax.swing.JOptionPane;

public class Eventos
{

    private int id_Evento;
    private String nome;
    private String endereco;
    private String categoria;
    private int id_Categorias;
    private String descricao;
    private String horario;

    static Eventos eventos = new Eventos();

    public void setId_Evento(int id_Evento)
    {
        this.id_Evento = id_Evento;
    }

    private int getId_Evento()
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

    public void setCategoria(String categoria)
    {
        this.categoria = categoria;
    }

    public String getCategoria()
    {
        return categoria;
    }

    public void setId_Categorias(int id_Categorias)
    {
        this.id_Categorias = id_Categorias;
    }

    public int getId_Categorias()
    {
        return id_Categorias;
    }

    public void setDescricao(String descricao )
    {
        this.descricao = descricao;
    }

    public String getDescricao()
    {
        return descricao;
    }

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
       eventos.setDescricao(descricao);
       eventos.setHorario(horario);

       System.out.println("\n" + "Evento: " + nome);
       System.out.println("\n" + "Endereco: " + endereco);
       System.out.println("\n" + "Categoria: " + categoria);
       System.out.println("\n" + "Descrição do Evento: " + descricao);
       System.out.println("\n" + "Horario: " + horario);

       System.out.println("\nAtualização Efetuada");

   }

   public static void Verificar()
   {

       String nome = eventos.getNome();
       String endereco = eventos.getEndereco();
       String categoria = eventos.getCategoria();
       String descricao = eventos.getDescricao();
       String horario = eventos.getHorario();

       System.out.println("\n" + "Nome: " + nome);
       System.out.println("\n" + "Endereco: " + endereco);
       System.out.println("\n" + "Categoria: " + categoria);
       System.out.println("\n" + "Descrição do Evento: " + descricao);
       System.out.println("\n" + "Horario: " + horario);

       System.out.println("\n'Verificação' Efetuada");

   }

   public void Registro()
   {
		//					Cadastro através do JOptionPane

       String nome = JOptionPane.showInputDialog("Digite o nome do Evento:\n");
       String endereco = JOptionPane.showInputDialog("Digite o endereco:\n");
       String categoria = JOptionPane.showInputDialog("Digite a categoraia desejada:\n");
       String descricao = JOptionPane.showInputDialog("Digite a descrição do evento:\n");
       String horario = JOptionPane.showInputDialog("Digite o horário:\n");



		/*

		//			Cadastro através do método Scanner

		Scanner ler = new Scanner (System.in);  // Variável Ler com o método Scanner

		System.out.println("Digite o nome do usuário:\n");
		nome = ler.nextLine();

		System.out.println("Digite o endereco:\n");
		endereco = ler.nextLine();

		System.out.println("Digite a categoria desejada:\n");
		categoria = ler.nextLine();

		System.out.println("Acrescente uma descrição para o evento:\n");
		descricao = ler.nextLine();

		System.out.println("Digite o horário:\n");
		horario = ler.nextLine();

        */

		//               Preenchendo o objeto

       eventos.setNome(nome);
       eventos.setEndereco(endereco);
       eventos.setCategoria(categoria);
       eventos.setDescricao(descricao);
       eventos.setHorario(horario);

		System.out.println("\n" + "Nome: " + nome);
		System.out.println("\n" + "Endereco: " + endereco);
		System.out.println("\n" + "Categoria: " + categoria);
		System.out.println("\n" + "Descrição do Evento: " + descricao);
		System.out.println("\n" + "Horario: " + horario);

		System.out.println("\nCadastro Efetuado");

	}

}

