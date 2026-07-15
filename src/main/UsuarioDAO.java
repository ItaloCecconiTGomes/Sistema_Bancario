package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class UsuarioDAO { // Data Access Object

    public int salvarUsuario(Connection conexao, long cpf, String nome, String sobrenome, LocalDate dataNascimento) throws SQLException {
        
        String sql = "INSERT INTO usuarios (cpf, nome, sobrenome, data_nascimento) VALUES (?, ?, ?, ?)";
        int idGerado = -1;
        
            PreparedStatement preparador = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparador.setLong(1, cpf);
            preparador.setString(2, nome);
            preparador.setString(3, sobrenome);
            preparador.setDate(4, java.sql.Date.valueOf(dataNascimento)); 
          
            preparador.executeUpdate();
            
            ResultSet rs = preparador.getGeneratedKeys();
            if (rs.next()) {
                idGerado = rs.getInt(1); // Guarda o ID gerado
            }
            
            System.out.println("Usuário cadastrado no banco!");
            rs.close();            
            preparador.close();
            
            return idGerado;

        
    }
}
