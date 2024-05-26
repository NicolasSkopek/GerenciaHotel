package Controll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.DB.ConexaoBanco;
import Model.Hospede;

public class InserirHospede {

    private long cpf;
    private String nome;
    private String telefone;
    private String email;
    private int status;

    public InserirHospede(long cpf, String nome, String telefone, String email, int status) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.status = status;
        
        Hospede hospede = new Hospede(cpf, nome, telefone, email, status);
        
        try (Connection conexao = ConexaoBanco.obterConexao()) {
            String retorno = cadastroHospede(hospede, conexao);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String cadastroHospede(Hospede hospede, Connection conexao) {
        try {
            String sql = "INSERT INTO cadastrar_livro (cpf, nome, telefone, email, status) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setLong(1, hospede.getCpf());
            preparedStatement.setString(2, hospede.getNome());
            preparedStatement.setString(3, hospede.getTelefone());
            preparedStatement.setString(4, hospede.getEmail());
            preparedStatement.setInt(5, hospede.getStatus());
            
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return "Hospede cadastrado com sucesso!";
            } else {
                return "Falha ao cadastrar o hospede!";
            }
        } catch (SQLException ex) {
            return "Ocorreu um erro ao cadastrar o hospede: " + ex.getMessage();
        }
    }
    
}