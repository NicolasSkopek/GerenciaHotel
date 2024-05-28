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
    public void atualizar(Hospede hospede, Connection conexao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void excluir(Hospede hospede, Connection conexao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }

    @Override
    public void listar(Hospede hospede, Connection conexao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }
    
}
