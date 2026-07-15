package main;
import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

public class Usuario {
	private int idUsuario;
	private String nome;
	private String sobrenome;
	private final LocalDate DATANASCIMENTO;
	private final long CPF;
	
	public Usuario (String nome, String sobrenome,LocalDate DATANASCIMENTO, long CPF) {
		int idade = Period.between(DATANASCIMENTO, LocalDate.now()).getYears();
        if (idade < 18) {
            throw new IllegalArgumentException("É necessário ser maior de idade para criar uma conta");
        }
        this.idUsuario = 0;
		this.nome = nome;		
		this.sobrenome = sobrenome;
		this.DATANASCIMENTO = DATANASCIMENTO;
		this.CPF = CPF;
	}

	public String getNome() {
		return nome;
	}

	private void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	private void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public LocalDate getDATANASCIMENTO() {
		return DATANASCIMENTO;
	}

	public long getCPF() {
		return CPF;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", sobrenome=" + sobrenome + ", DATANASCIMENTO="
				+ DATANASCIMENTO + ", CPF=" + CPF + "]";
	}
	
	

	
	
	

}
