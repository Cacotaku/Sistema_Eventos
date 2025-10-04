package src;

import javax.swing.*;
import java.sql.SQLException;

public class Categoria
{

    private int id_Categoria;
    private String nome;
    private String descricao;

    static Categoria categoria = new Categoria();

    public void setId_Categoria(int id_Categoria)
    {
        this.id_Categoria = id_Categoria;
    }

    public int getId_Categoria()
    {
        return id_Categoria;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getNome()
    {
        return nome;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public String getDescricao()
    {
        return descricao;
    }

    //Preenche o objeto categoria atualizando com os campos preenchidos

    public static void Atualizar(String nome, String descricao)
    {
        categoria = new Categoria();

        categoria.setNome(nome);
        categoria.setDescricao(descricao);

        System.out.println("\n" + "Categoria: " + nome);
        System.out.println("\n" + "Descrição: " + descricao);

        System.out.println("\nAtualização Efetuada");
    }

    //Retorna os dados da categoria

    public static void Verificar()
    {
        String nome = categoria.getNome();
        String descricao = categoria.getDescricao();

        System.out.println("\n" + "Categoria: " + nome);
        System.out.println("\n" + "Descrição: " + descricao);

        System.out.println("\n'Verificação' Efetuada");
    }

    //Cadastro de categoria
   public void Registro() throws SQLException, Exception
   {
       String nome = JOptionPane.showInputDialog("Digite o nome da Categoria:\n");
       String descricao = JOptionPane.showInputDialog("Digite a descrição da categoria:\n");

       categoria.setNome(nome);
       categoria.setDescricao(descricao);

       SqlTest.CadastrarCategorias(categoria);

       System.out.println("\nCadastro Efetuado");
   }
}
