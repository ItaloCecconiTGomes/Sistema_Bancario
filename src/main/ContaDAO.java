package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContaDAO {
	
	public void salvarConta(Connection conexao, int numeroAgencia, int numeroConta, boolean contaAtivada, float corrente, float poupanca, int idDono) throws SQLException {
		String sql = "INSERT INTO contas (numero_agencia, numero_conta, conta_ativada, corrente, poupanca, id_Dono) VALUES (?, ?, ?, ?, ?, ?)";

		
			PreparedStatement preparador = conexao.prepareStatement(sql);
			
			preparador.setInt(1, numeroAgencia);
			preparador.setInt(2, numeroConta);
			preparador.setBoolean(3, contaAtivada);
			preparador.setFloat(4, corrente);
			preparador.setFloat(5, poupanca);
			preparador.setInt(6, idDono);
			
			preparador.execute();
			
			preparador.close();
			
			System.out.println("Conta cadastrada no banco!");
		
	}
	

}
