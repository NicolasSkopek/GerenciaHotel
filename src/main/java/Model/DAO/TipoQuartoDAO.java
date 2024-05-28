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
    public void atualizar(TipoQuarto tipoQuarto, Connection conexao) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void excluir(TipoQuarto tipoQuarto, Connection conexao) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void listar(TipoQuarto tipoQuarto, Connection conexao) {
        // TODO Auto-generated method stub
        
    }
    
}
