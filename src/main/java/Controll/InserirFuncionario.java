package Controll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.DB.ConexaoBanco;
import Model.Funcionario;

public class InserirFuncionario {

    private String cpf;
    private String nome;
    private String cargo;

    public InserirFuncionario(String cpf, String nome, String cargo) {
        this.cpf = cpf;
        this.nome = nome;
        this.cargo = cargo;

        Funcionario funcionario = new Funcionario(cpf, nome, cargo);
        
    try (Connection conexao = ConexaoBanco.obterConexao()) {
            String retorno = cadastroHospede(funcionario, conexao);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String cadastroHospede(Funcionario funcionario, Connection conexao) {
        try {
            String sql = "INSERT INTO gerenciamento_de_funcionarios (cpf, nome, cargo) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, funcionario.getCpf());
            preparedStatement.setString(2, funcionario.getNome());
            preparedStatement.setString(3, funcionario.getCargo());
            
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return "Funcionário cadastrado com sucesso! ";
            } else {
                return "Falha ao cadastrar o funcionário!";
            }
        } catch (SQLException ex) {
            return "Ocorreu um erro ao cadastrar o funcionário: " + ex.getMessage();
        }
    }
}
