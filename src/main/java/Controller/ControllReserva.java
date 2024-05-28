package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import Model.Reservas;
import Model.DAO.ReservaDAO;
import Model.DB.ConexaoBanco;

public class ControllReserva {

    private int idReserva;
    private LocalDate dataReserva;
    private LocalDate dataRetirada;
    private String cpfHospede;
    private String cpfFuncionario;
    private int status;

    public ControllReserva(int idReserva, LocalDate dataReserva, LocalDate dataRetirada, String cpfHospede, String cpfFuncionario, int status) {
        this.idReserva = idReserva;
        this.dataReserva = dataReserva;
        this.dataRetirada = dataRetirada;
        this.cpfHospede = cpfHospede;
        this.cpfFuncionario = cpfFuncionario;
        this.status = status;

        Reservas reserva = new Reservas(idReserva, dataReserva, dataRetirada, cpfHospede, cpfFuncionario, status);

        try (Connection conexao = ConexaoBanco.obterConexao()) {
            ReservaDAO reservaDAO = new ReservaDAO();
            String retorno = reservaDAO.cadastrar(reserva, conexao);
            System.out.println(retorno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
