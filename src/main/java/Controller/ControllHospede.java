package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Hospede;
import Model.DAO.HospedeDAO;
import Model.DB.ConexaoBanco;

public class ControllHospede {

    private String cpf;
    private String nome;
    private String telefone;
    private String email;

    public ControllHospede(String cpf, String nome, String telefone, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        
        Hospede hospede = new Hospede(cpf, nome, telefone, email);
        
        try (Connection conexao = ConexaoBanco.obterConexao()) {
            HospedeDAO hospedeDAO = new HospedeDAO();
            String retorno = hospedeDAO.cadastrar(hospede, conexao);
            System.out.println(retorno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}