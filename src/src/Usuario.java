package src;

import javax.swing.*;

public class Usuario
{
    private int id_Usuario;
    private String nome;
    private int idade;
    private String endereco;

    static Usuario usuario = new Usuario();

    public void setId_Usuario(int id_usuario)
    {
        this.id_Usuario = id_Usuario;
    }

    public int getId_Usuario()
    {
        return id_Usuario;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getNome()
    {
        return nome;
    }

    public void setIdade(int idade)
    {
        this.idade = this.idade;
    }

    public int getIdade()
    {
        return idade;
    }

    public void setEndereco(String endereco)
    {
        this.endereco = endereco;
    }

    public String getEndereco()
    {
        return endereco;
    }

    public static void Atualizar(int id_Usuario, String nome, int idade, String endereco )
    {
        usuario = new Usuario();

        usuario.setId_Usuario(id_Usuario);
        usuario.setNome(nome);
        usuario.setIdade(idade);
        usuario.setEndereco(endereco);

        System.out.println("\n" + "ID: " + id_Usuario);
        System.out.println("\n" + "Nome: " + nome);
        System.out.println("\n" + "Idade: " + idade);
        System.out.println("\n" + "Endereço: " + endereco);

        System.out.println("\nAtualização Efetuada");

    }

    public static void Verificar()
   {
       int id_Usuario = usuario.getId_Usuario();
       String nome = usuario.getNome();
       int idade = usuario.getIdade();
       String endereco = usuario.getEndereco();

       System.out.println("\n" + "ID: " + id_Usuario);
       System.out.println("\n" + "Nome: " + nome);
       System.out.println("\n" + "Idade: " + idade);
       System.out.println("\n" + "Endereço: " + endereco);

       System.out.println("\n'Verificação' Efetuada");

   }

   public void Registro()
  {
    String nome = JOptionPane.showInputDialog("Digite o nome do usuário:\n");
    int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do usuário:\n"));
    String endereco = JOptionPane.showInputDialog("Digite o endereco:\n");

    usuario.setNome(nome);
    usuario.setIdade(idade);
    usuario.setEndereco(endereco);

    System.out.println("\n" + "Nome: " + nome);
    System.out.println("\n" + "Idade: " + idade);
    System.out.println("\n" + "Endereço: " + endereco);

    System.out.println("\nCadastro Efetuado");
  }

}
