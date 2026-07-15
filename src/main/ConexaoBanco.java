package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

    
    public static Connection obterConexao() {
        
        String url = "jdbc:postgresql://localhost:5432/sistema_bancario";
        String usuario = "postgres";
        String senha = "30141670";
        
        try {
            
            return DriverManager.getConnection(url, usuario, senha);
            
        } catch (SQLException e) {
            System.out.println("Erro ao tentar conectar com o Banco de Dados!");
            throw new RuntimeException(e); 
        }
    }
}