package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Funcionario;

public class FuncionarioDAO implements IDAO<Funcionario> {

    @Override
    public String cadastrar(Funcionario funcionario, Connection conexao) {
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

    @Override
    public String atualizar(Funcionario funcionrio, Connection conexao) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String excluir(Connection conexao, String remov) {
        try {
            String sql = "DELETE FROM gerenciamento_de_funcionarios WHERE cpf = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, remov);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return "Funcionário removido do banco de dados com sucesso!";
            } else {
                return "Falha ao excluir o funcionário do banco de dados!";
            }
        } catch (SQLException ex) {
            return "Ocorreu um erro ao excluir o funcionário: " + ex.getMessage();
        }
    }

    @Override
    public String excluir(Connection conexao, long remov) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String excluir(Connection conexao, int remov) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String listar(Funcionario funcionario, Connection conexao) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
