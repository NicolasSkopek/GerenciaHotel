package Controll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import Model.Reservas;

import Model.DB.ConexaoBanco;

public class InserirReserva {

    private int idReserva;
    private LocalDate dataReserva;
    private LocalDate dataRetirada;
    private String cpfHospede;
    private String cpfFuncionario;
    private int status;

    public InserirReserva(int idReserva, LocalDate dataReserva, LocalDate dataRetirada, String cpfHospede, String cpfFuncionario, int status) {
        this.idReserva = idReserva;
        this.dataReserva = dataReserva;
        this.dataRetirada = dataRetirada;
        this.cpfHospede = cpfHospede;
        this.cpfFuncionario = cpfFuncionario;
        this.status = status;

        Reservas reserva = new Reservas(idReserva, dataReserva, dataRetirada, cpfHospede, cpfFuncionario, status);

        try (Connection conexao = ConexaoBanco.obterConexao()) {
            String retorno = cadastroReserva(reserva, conexao);
            System.out.println(retorno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String cadastroReserva(Reservas reserva, Connection conexao) {
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
}
