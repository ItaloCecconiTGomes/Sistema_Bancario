package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {
	//CLASSE UTILIZADA APENAS PARA TESTAR UMA CONEXÃO INICIAL COM O BANCO, NÃO É MAIS UTILIZADA
    public static void main(String[] args) {
        
        // 1. Definicao das rotas e das credenciais
        String url = "jdbc:postgresql://localhost:5432/sistema_bancario"; 
        String usuario = "postgres"; 
        String senha = "30141670"; 
        
        // 2. Tentativa de conexao
        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexao com o PostgreSQL realizada com sucesso!");
            
            // Fecha a conexão após o teste
            conexao.close(); 
            
        } catch (SQLException e) {
            System.out.println("Err");
            e.printStackTrace(); // Isso imprime o erro 
        }
    }
}