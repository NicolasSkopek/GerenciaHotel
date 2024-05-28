package Controller;

import Model.TipoQuarto;
import Model.DAO.FuncionarioDAO;
import Model.DAO.TipoQuartoDAO;
import Model.DB.ConexaoBanco;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class ControllTipo {
    public static void inserirTipo(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("ID do Tipo do Quarto: ");
        int id = scanner.nextInt();
        System.out.print("Descrição: ");
        scanner.nextLine();
        String descricao = scanner.nextLine();
        
        TipoQuarto novotipoQuarto = new TipoQuarto(id, descricao);
    
        try (Connection conexao = ConexaoBanco.obterConexao()) {
            TipoQuartoDAO tipoQuartoDAO = new TipoQuartoDAO();
            String retorno = tipoQuartoDAO.cadastrar(novotipoQuarto, conexao);
            System.out.println(retorno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void excluirTipo(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o Id do tipo de quarto que deseja Remover do Banco de Dados:");
        int remov = scanner.nextInt();
        try (Connection conexao = ConexaoBanco.obterConexao()) {
            TipoQuartoDAO tipoQuartoDAO = new TipoQuartoDAO();
            String retorno = tipoQuartoDAO.excluir(conexao,remov);
            System.out.println(retorno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
