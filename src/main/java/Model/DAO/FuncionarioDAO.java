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
    public void atualizar(Funcionario funcionrio, Connection conexao) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void excluir(Funcionario funcionario, Connection conexao) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void listar(Funcionario funcionario, Connection conexao) {
        // TODO Auto-generated method stub
        
    }
    
}
