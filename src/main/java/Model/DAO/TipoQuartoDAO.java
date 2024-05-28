package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.TipoQuarto;

public class TipoQuartoDAO implements IDAO<TipoQuarto>{
    
    @Override
    public String cadastrar(TipoQuarto tipoQuarto, Connection conexao) {
        try {
            String sql = "INSERT INTO gerenciamento_de_tipos_de_quarto (id_tipo, descricao) VALUES (?, ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, tipoQuarto.getId());
            preparedStatement.setString(2, tipoQuarto.getDescricao());
            
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return "Tipo de quarto cadastrado com sucesso!";
            } else {
                return "Falha ao cadastrar o tipo de quarto!";
            }
        } catch (SQLException ex) {
            return "Ocorreu um erro ao cadastrar o tipo de quarto: " + ex.getMessage();
        }
    }

    @Override
    public String atualizar(TipoQuarto tipoQuarto, Connection conexao) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String excluir(Connection conexao, String remov) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String excluir(Connection conexao, long remov) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String excluir(Connection conexao, int remov) {
        try {
            String sql = "DELETE FROM gerenciamento_de_reservas WHERE id_quarto = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, remov);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return "Tipo de quarto removido do banco de dados com sucesso!";
            } else {
                return "Falha ao excluir o tipo de quarto do banco de dados!";
            }
        } catch (SQLException ex) {
            return "Ocorreu um erro ao excluir o tipo de quarto: " + ex.getMessage();
        }
    }

    @Override
    public String listar(TipoQuarto tipoQuarto, Connection conexao) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
