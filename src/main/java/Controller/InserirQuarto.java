package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Quarto;
import Model.DB.ConexaoBanco;

public class InserirQuarto{
    private int id;
    private int idReserva;
    private int idTipo;

    public InserirQuarto(int id, int idReserva, int idTipo) {
        this.id = id;
        this.idReserva = idReserva;
        this.idTipo = idTipo;

        Quarto quarto = new Quarto(id, idReserva, idTipo);

    try (Connection conexao = ConexaoBanco.obterConexao()) {
            String retorno = cadastroQuarto(quarto, conexao);
            System.out.println(retorno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String cadastroQuarto(Quarto quarto, Connection conexao) {
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
    
}
