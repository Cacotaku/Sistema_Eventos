//09/07/2025 Cadastro de

package src;

import javax.swing.*;
import java.sql.SQLException;

public class Evento_Usuario
{
    private int id_EveUsu;
    private int id_UsuEve;

    static Evento_Usuario evento_usuario = new Evento_Usuario();

    public void setId_EveUsu(int id_EveUsu)
    {
        this.id_EveUsu = id_EveUsu;
    }

    public int getId_EveUsu()
    {
        return id_EveUsu;
    }

    public void setId_UsuEve(int id_UsuEve)
    {
        this.id_UsuEve = id_UsuEve;
    }

    public int getId_UsuEve()
    {
        return id_UsuEve;
    }

    //Preenche o objeto de tabela relacional atualizando com os campos preenchidos (apenas para testes)

    public static void Atualizar(int id_EveUsu, int id_UsuEve)
    {
        Evento_Usuario e = new Evento_Usuario();

        e.setId_EveUsu(id_EveUsu);
        e.setId_UsuEve(id_UsuEve);

        System.out.println("\n" + "Id do Evento: " + id_EveUsu);
        System.out.println("\n" + "Id do Usuario: " + id_UsuEve);

        System.out.println("\nAtualização Efetuada");
    }

    //Retorna os dados da tabela relacional

    public static void Verificar()
    {
        int id_EveUsu = evento_usuario.getId_EveUsu();
        int descricao = evento_usuario.getId_UsuEve();


        System.out.println("\n" + "Id do Evento: " + id_EveUsu);
        System.out.println("\n" + "Id do Usuario: " + id_EveUsu);

        System.out.println("\n'Verificação' Efetuada");

    }

    //Cadastrar uma pessoa em um evento

   public static void Registro() throws SQLException, Exception
   {
       int id_EveUsu = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do evento:\n"));
       int id_UsuEve = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do usuário:\n"));

       evento_usuario.setId_EveUsu(id_EveUsu);
       evento_usuario.setId_UsuEve(id_UsuEve);

       SqlTest.CadastrarEvento_Usuario(evento_usuario);

       System.out.println("\nCadastro Efetuado");



   }
}
