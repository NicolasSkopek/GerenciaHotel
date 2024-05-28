package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Reservas;

public class ReservaDAO implements IDAO<Reservas> {

    @Override
    public String cadastrar(Reservas reserva, Connection conexao) {
        String sql = "INSERT INTO gerenciamento_de_reservas(id_reserva, data_reserva, data_retirada, fk_hospede, fk_funcionario, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setInt(1, reserva.getIdReserva());
            preparedStatement.setObject(2, reserva.getDataReserva());
            preparedStatement.setObject(3, reserva.getDataRetirada());
            preparedStatement.setString(4, reserva.getCpfHospede());
            preparedStatement.setString(5, reserva.getCpfFuncionario());
            preparedStatement.setInt(6, reserva.getStatus());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return "Reserva cadastrada com sucesso!";
            } else {
                return "Falha ao cadastrar a reserva!";
            }
        } catch (SQLException ex) {
            return "Ocorreu um erro ao cadastrar a reserva: " + ex.getMessage();
        }
    }

    @Override
    public void atualizar(Reservas reserva, Connection conexao) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void excluir(Reservas reserva, Connection conexao) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void listar(Reservas reserva, Connection conexao) {
        // TODO Auto-generated method stub
        
    }
    
}
