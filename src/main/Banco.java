package main;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Banco {

	public static void main(String[] args) {
		
Connection conexao = null;

        try {
            
            conexao = ConexaoBanco.obterConexao();
            conexao.setAutoCommit(false); 

            
            Usuario novoUtilizador = new Usuario("Mauricio","Gabriel",LocalDate.of(2000, 1, 15), 98765432165L);

            
            UsuarioDAO usuarioDao = new UsuarioDAO();
            int idDoDono = usuarioDao.salvarUsuario(
                conexao, 
                novoUtilizador.getCPF(), 
                novoUtilizador.getNome(), 
                novoUtilizador.getSobrenome(), 
                novoUtilizador.getDATANASCIMENTO()
            );

            
            Conta novaConta = new Conta(100.00f, 250.00f, idDoDono);

            
            ContaDAO contaDao = new ContaDAO();
            contaDao.salvarConta(
                conexao, 
                novaConta.getNumeroAgencia(), 
                novaConta.getNumeroConta(), 
                novaConta.getContaAtivada(), 
                novaConta.getCorrente(), 
                novaConta.getPoupanca(), 
                novaConta.getIdDono()
            );

            
            conexao.commit();
            System.out.println("Cadastros bem-sucedidos");

        } catch (SQLException e) {
            
            System.out.println("Ocorreu um erro no cadastro. A reverter operações (Rollback)...");
            if (conexao != null) {
                try {
                    conexao.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

		
		
		
		
		
	}

}
}



//conta1.setContaAtivada(false);

//conta1.transferirParaCorrente(450.6f);
//
//conta1.transferirParaPoupanca(200.58f);

//conta1.depositarCorrente(550.6f);
//conta1.depositarPoupanca(200.1f);
//
//conta1.sacarCorrente(1000.8f);
//
//conta1.statusConta(false);
//
//conta1.sacarCorrente(1000.8f);