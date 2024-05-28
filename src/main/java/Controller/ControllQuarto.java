package Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import Model.Quarto;
import Model.DAO.QuartoDAO;
import Model.DB.ConexaoBanco;

public class ControllQuarto{
    public static void inserirQuarto() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID do Quarto: ");
        int id = scanner.nextInt();
        System.out.print("ID da Reserva: ");
        int idReserva = scanner.nextInt();
        System.out.print("ID do Tipo do Quarto: ");
        int idTipo = scanner.nextInt();

        Quarto novoquarto = new Quarto(id, idReserva, idTipo);

        try (Connection conexao = ConexaoBanco.obterConexao()) {
            QuartoDAO quartoDAO = new QuartoDAO();
            String retorno = quartoDAO.cadastrar(novoquarto, conexao);
            System.out.println(retorno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
