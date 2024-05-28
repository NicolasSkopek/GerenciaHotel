package Controller;

import Model.TipoQuarto;
import Model.DAO.TipoQuartoDAO;
import Model.DB.ConexaoBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControllTipo {
    private int id;
    private String descricao;

    public ControllTipo(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;

        TipoQuarto tipoQuarto = new TipoQuarto(id, descricao);
    
        try (Connection conexao = ConexaoBanco.obterConexao()) {
            TipoQuartoDAO tipoQuartoDAO = new TipoQuartoDAO();
            String retorno = tipoQuartoDAO.cadastrar(tipoQuarto, conexao);
            System.out.println(retorno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
