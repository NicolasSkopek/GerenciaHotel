package Model.DAO;

import java.sql.Connection;

public interface IDAO<T> {
    
    String cadastrar(T entidade, Connection conexao);

    void atualizar(T entidade, Connection conexao);

    void excluir(T entidade, Connection conexao);
    
    void listar(T entidade, Connection conexao);
}
