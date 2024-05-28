package Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import Model.Funcionario;
import Model.DAO.FuncionarioDAO;
import Model.DB.ConexaoBanco;

public class ControllFuncionario {
    public static void inserirFuncionario() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("CPF do Funcionário: ");
        String cpf = scanner.nextLine();
        System.out.print("Nome do Funcionário: ");
        String nome = scanner.nextLine();
        System.out.print("Cargo do Funcionário: ");
        String cargo = scanner.nextLine();
        
        Funcionario novofuncionario = new Funcionario(cpf, nome, cargo);
        
        try (Connection conexao = ConexaoBanco.obterConexao()) {
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            String retorno = funcionarioDAO.cadastrar(novofuncionario, conexao);
            System.out.println(retorno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void excluirFuncionario(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o CPF do funcionário que deseja Remover do Banco de Dados:");
        String remov = scanner.nextLine();
        try (Connection conexao = ConexaoBanco.obterConexao()) {
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            String retorno = funcionarioDAO.excluir(conexao,remov);
            System.out.println(retorno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
