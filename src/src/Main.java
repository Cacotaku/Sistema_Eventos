//Proposta da página
//Criar uma chamada de opções
			/*
			 	 * Busca de Eventos que o usuário Participou
				 * Busca de Eventos de uma categoria
				 * Buscar usuários de um evento
				 *
				 * Cadastrar um evento
				 * Cadastrar um usuário
				 *
				 * Cadastrar Categorias
				 * Cadastrar inscrição num evento
				 *
				 *
				 * Sair
			 */
/*
		Sistema de cadastros Baco\n
		Digite a opção desejada:\n

				 1 - * Busca de Eventos que o usuário Participou
				 2 - * Busca de Eventos de uma categoria
				 3 - * Buscar usuários de um evento
				 *
				 4 - * Cadastrar um evento
				 5 - * Cadastrar um usuário
				 *
				 6 - * Cadastrar Categorias
				 7 - * Cadastrar inscrição num evento
				 *
				 *
				 0 - * Sair
*/

package src;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static String Opcoes()
    {
        return "Sistema de cadastros Baco\\n\n" +
            "\t\tDigite a opção desejada:\\n\n" +
            "\n" +
            "\t\t\t\t 1 - * Busca de Eventos que o usuário Participou\n" +
            "\t\t\t\t 2 - * Busca de Eventos de uma categoria\n" +
            "\t\t\t\t 3 - * Buscar usuários de um evento\n" +
            "\t\t\t\t *\n" +
            "\t\t\t\t 4 - * Cadastrar um evento\n" +
            "\t\t\t\t 5 - * Cadastrar um usuário\n" +
            "\t\t\t\t *\n" +
            "\t\t\t\t 6 - * Cadastrar Categorias\n" +
            "\t\t\t\t 7 - * Cadastrar inscrição num evento\n" +
            "\t\t\t\t *\n" +
            "\t\t\t\t 0 - * Sair\n";
    }

    public static void main(String [] args) throws SQLException, Exception 
    {
       SqlTest sqlChamada = new SqlTest();
       SqlTest.SQLChamada();

       String mensagem = Opcoes();

	   int opt = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
       while(opt > 1 || opt < 7)
       {
           switch(opt)
		   {
               case 1: //  1 - * Busca de Eventos que o usuário Participou
                	             	
                	int buscaUsuario = Integer.parseInt(
                			JOptionPane.showInputDialog(null, "Digite o id do usuário buscado: "));
                	SqlTest.BuscaEvUs(buscaUsuario);
                	mensagem = "Deseja realizar mais alguma operação?\n" + Opcoes();
                    opt = Integer.parseInt(
                    		JOptionPane.showInputDialog(mensagem));                 	
                    break;

               case 2: //  2 - * Busca de Eventos de uma categoria

            	   int id_Categoria = Integer.parseInt(
            			   JOptionPane.showInputDialog(null,"Digite o id da categoria: "));
                   Categoria buscaEventoCategoria = new Categoria();
	               buscaEventoCategoria.setId_Categoria(id_Categoria);	
	               List<Categoria> listaEventos = new ArrayList<Categoria>();	
	               listaEventos = sqlChamada.Buscar(buscaEventoCategoria);
	               mensagem = "Deseja realizar mais alguma operação?\n" + Opcoes();
	               opt = Integer.parseInt(
	            		   JOptionPane.showInputDialog(mensagem));	
	               break;

               case 3: //  3 - * Buscar usuários de um evento                    

                    int id_Evento = Integer.parseInt(
                    		JOptionPane.showInputDialog(null,"Digite o id do evento: "));
                    Evento_Usuario evento_usuario = new Evento_Usuario();
                    evento_usuario.setId_EveUsu(id_Evento);
                    List<Evento_Usuario> listaEvento_Usuario = new ArrayList<Evento_Usuario>();
                    listaEvento_Usuario = sqlChamada.Buscar(evento_usuario);
                    mensagem = "Deseja realizar mais alguma operação?\n" + Opcoes();
                    opt = Integer.parseInt(
                    		JOptionPane.showInputDialog(mensagem));
                    break;

               case 4: //  4 - * Cadastrar um evento
            	   
                    Eventos eventos = new Eventos();
                    eventos.Registro();
                    mensagem = "Deseja realizar mais alguma operação?\n" + Opcoes();
                    opt = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
                    break;

               case 5: //  5 - * Cadastrar um usuário
                    
                    Usuario usuario = new Usuario();
                    usuario.Registro();
                    mensagem = "Deseja realizar mais alguma operação?\n" + Opcoes();
                    opt = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
                    break;

                case 6: //  6 - * Cadastrar Categorias                    

                    Categoria categoria = new Categoria();
                    categoria.Registro();
                    mensagem = "Deseja realizar mais alguma operação?\n" + Opcoes();
                    opt = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
                    break;

                case 7: //  7 - * Cadastrar inscrição num evento                    

                    Evento_Usuario.Registro();
                    mensagem = "Deseja realizar mais alguma operação?\n" + Opcoes();
                    opt = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
                    break;

                case 0: //  0 - * Sair
                    break;

                default:       //Opção inválida

                    JOptionPane.showMessageDialog(null,"Opção Inválida\n");
                    mensagem = "Deseja realizar mais alguma operação?\n" + Opcoes();
                    opt = Integer.parseInt(
                    		JOptionPane.showInputDialog(mensagem));
                    break;
		    }
        }
	}
}
