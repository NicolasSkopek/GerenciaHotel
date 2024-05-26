package Controll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import Model.DB.ConexaoBanco;
import Model.Reservas;

public class InserirReserva {

    private int idReserva;
    private LocalDate dataReserva;
    private LocalDate dataRetirada;
    private long cpfHospede;
    private long cpfFuncionario;

    public InserirReserva(int idReserva, LocalDate dataReserva, LocalDate dataRetirada, long cpfHospede, long cpfFuncionario) {
        this.idReserva = idReserva;
        this.dataReserva = dataReserva;
        this.dataRetirada = dataRetirada;
        this.cpfHospede = cpfHospede;
        this.cpfFuncionario = cpfFuncionario;

        Reservas reserva = new Reservas(idReserva, dataReserva, dataRetirada, cpfHospede, cpfFuncionario);

        try (Connection conexao = ConexaoBanco.obterConexao()) {
            String retorno = cadastroReserva(reserva, conexao);
            System.out.println(retorno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String cadastroReserva(Reservas reserva, Connection conexao) {
        String sql = "INSERT INTO gerencimento_de_reservas(id_reserva, data_reserva, data_retirada, fk_hospede, fk_funcionario) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setInt(1, reserva.getIdReserva());
            preparedStatement.setObject(2, reserva.getDataReserva());
            preparedStatement.setObject(3, reserva.getDataRetirada());
            preparedStatement.setLong(4, reserva.getCpfHospede());
            preparedStatement.setLong(5, reserva.getCpfFuncionario());

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
}
