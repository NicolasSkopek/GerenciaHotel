package Controll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Hospede;
import Model.DB.ConexaoBanco;

public class InserirHospede {

    private String cpf;
    private String nome;
    private String telefone;
    private String email;

    public InserirHospede(String cpf, String nome, String telefone, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        
        Hospede hospede = new Hospede(cpf, nome, telefone, email);
        
        try (Connection conexao = ConexaoBanco.obterConexao()) {
            String retorno = cadastroHospede(hospede, conexao);
            System.out.println(retorno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String cadastroHospede(Hospede hospede, Connection conexao) {
        try {
            String sql = "INSERT INTO gerenciamento_de_hospedes (cpf, nome, telefone, email) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, hospede.getCpf());
            preparedStatement.setString(2, hospede.getNome());
            preparedStatement.setString(3, hospede.getTelefone());
            preparedStatement.setString(4, hospede.getEmail());
            
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