package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Funcionario;
import Model.DAO.FuncionarioDAO;
import Model.DB.ConexaoBanco;

public class ControllFuncionario {

    private String cpf;
    private String nome;
    private String cargo;

    public ControllFuncionario(String cpf, String nome, String cargo) {
        this.cpf = cpf;
        this.nome = nome;
        this.cargo = cargo;

        Funcionario funcionario = new Funcionario(cpf, nome, cargo);
        
    try (Connection conexao = ConexaoBanco.obterConexao()) {
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            String retorno = funcionarioDAO.cadastrar(funcionario, conexao);
            System.out.println(retorno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
