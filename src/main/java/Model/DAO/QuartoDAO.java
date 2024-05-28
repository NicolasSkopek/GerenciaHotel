package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Quarto;
public class QuartoDAO implements IDAO<Quarto> {
    
    @Override
    public String cadastrar(Quarto quarto, Connection conexao) {
        try {
            String sql = "INSERT INTO gerenciamento_de_quartos_da_reserva (num_quarto, fk_reserva, fk_tipo) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setLong(1, quarto.getIdQuarto());
            preparedStatement.setInt(2, quarto.getIdReserva());
            preparedStatement.setInt(3, quarto.getIdTipo());
            
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return "Quarto cadastrado com sucesso!";
            } else {
                return "Falha ao cadastrar o quarto!";
            }
        } catch (SQLException ex) {
            return "Ocorreu um erro ao cadastrar o quarto: " + ex.getMessage();
        }
    }

    @Override
    public void atualizar(Quarto quarto, Connection conexao) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void excluir(Quarto quarto, Connection conexao) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void listar(Quarto quarto, Connection conexao) {
        // TODO Auto-generated method stub
        
    }
    
}
