package Controller;

import Model.TipoQuarto;
import Model.DB.ConexaoBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirTipo {
    private int id;
    private String descricao;

    public InserirTipo(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;

        TipoQuarto tipoQuarto = new TipoQuarto(id, descricao);
    
        try (Connection conexao = ConexaoBanco.obterConexao()) {
            String retorno = cadastroTipoQuarto(tipoQuarto, conexao);
            System.out.println(retorno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String cadastroTipoQuarto(TipoQuarto tipoQuarto, Connection conexao) {
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
    

    
}
