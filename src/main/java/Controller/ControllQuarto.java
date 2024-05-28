package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Quarto;
import Model.DAO.QuartoDAO;
import Model.DB.ConexaoBanco;

public class ControllQuarto{

    private int id;
    private int idReserva;
    private int idTipo;

    public ControllQuarto(int id, int idReserva, int idTipo) {
        this.id = id;
        this.idReserva = idReserva;
        this.idTipo = idTipo;

        Quarto quarto = new Quarto(id, idReserva, idTipo);

    try (Connection conexao = ConexaoBanco.obterConexao()) {
            QuartoDAO quartoDAO = new QuartoDAO();
            String retorno = quartoDAO.cadastrar(quarto, conexao);
            System.out.println(retorno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
