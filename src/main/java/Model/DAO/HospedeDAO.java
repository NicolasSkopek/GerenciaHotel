package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Hospede;

public class HospedeDAO implements IDAO<Hospede>{

    @Override
    public String cadastrar(Hospede hospede, Connection conexao) {
            try {
                String sql = "INSERT INTO gerenciamento_de_hospedes (cpf, nome, telefone, email) VALUES (?, ?, ?, ?)";
                PreparedStatement preparedStatement = conexao.prepareStatement(sql);
                preparedStatement.setString(1, hospede.getCpf());
                preparedStatement.setString(2, hospede.getNome());
                preparedStatement.setString(3, hospede.getTelefone());
                preparedStatement.setString(4, hospede.getEmail());
                
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    return "Hospede cadastrado com sucesso!";
                } else {
                    return "Falha ao cadastrar o hospede!";
                }
            } catch (SQLException ex) {
                return "Ocorreu um erro ao cadastrar o hospede: " + ex.getMessage();
            }
        }

    @Override
    public String atualizar(Hospede hospede, Connection conexao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public String excluir(Connection conexao, String remov) {
        try {
            String sql = "DELETE FROM gerenciamento_de_hospedes WHERE cpf = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, remov);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return "Hospede removido do banco de dados com sucesso!";
            } else {
                return "Falha ao excluir o hospede do banco de dados!";
            }
        } catch (SQLException ex) {
            return "Ocorreu um erro ao excluir o hospede: " + ex.getMessage();
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
    public String listar(Hospede hospede, Connection conexao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }
    
}
