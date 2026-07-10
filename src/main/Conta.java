package main;
import java.time.LocalDate;
import java.util.Random;

public class Conta extends Usuario implements OperacoesBancarias{ 

	private int numeroConta;
	private boolean contaAtivada;
	private float corrente;
	private float poupanca;
	
	
	public Conta(String nome, String sobrenome, LocalDate DATANASCIMENTO , 
			 long CPF, float corrente, float poupanca) {
		super(nome, sobrenome, DATANASCIMENTO, CPF);
		Random gerador = new Random();
		this.numeroConta = gerador.nextInt(9000) + 1000;
		this.contaAtivada = true;
		this.setCorrente(corrente);
		this.setPoupanca(poupanca);
	}

	public void ativarConta() {
		this.setContaAtivada(true);
		System.out.println("Sua conta esta ativada!\nOperacoes estao disponiveis.");
	}
	
	public void desativarConta() {
		this.setContaAtivada(false);
		System.out.println("Sua conta esta desativada!\nOperacoes estao indisponiveis.");
	}
	
	public void depositarCorrente(float valorDeposito) {
		if(this.getContaAtivada()) {
			if(valorDeposito > 0) {
				this.setCorrente(this.getCorrente() + valorDeposito);
				System.out.println("Deposito de: R$"+valorDeposito+" realizado com sucesso!\nNovo saldo da conta "
						+ "corrente: R$"+this.getCorrente());
			}else {
				throw new IllegalArgumentException("O valor do deposito deve ser maior que zero.");
			}
		}else {
			throw new IllegalArgumentException("A conta deve estar ativada para realizar operacoes");
		}
	}
	
	public void depositarPoupanca(float valorDeposito) {
		if(this.getContaAtivada()) {
			if(valorDeposito > 0) {
				this.setPoupanca(this.getPoupanca() + valorDeposito);
				System.out.println("Depósito de: R$"+valorDeposito+" realizado com sucesso!\nNovo saldo da conta "+this.getNumeroConta()
						+ " poupança: R$"+this.getPoupanca());
			}else {
				throw new IllegalArgumentException("O valor do deposito deve ser maior que zero.");
			}
		}else {
			throw new IllegalArgumentException("A conta deve estar ativada para realizar operacoes");
		}
	}
	
	public void sacarCorrente(float valorSaque) {
		if(this.getContaAtivada()) {
			if(this.getCorrente() >= valorSaque && valorSaque > 0) {
				this.setCorrente(this.getCorrente() - valorSaque);
				System.out.println("Saque de: R$"+valorSaque+" realizado com sucesso!\nNovo saldo da conta "+this.getNumeroConta()
						+ " corrente: R$"+this.getCorrente());
			}else {
				throw new IllegalArgumentException("O valor do saque deve ser positivo e menor ou igual ao valor na conta.");
			}
		}else {
			throw new IllegalArgumentException("A conta deve estar ativada para realizar operacoes");
		}
	}
	
	public void sacarPoupanca(float valorSaque) {
		if(this.getContaAtivada()) {
			if(this.getPoupanca() >= valorSaque && valorSaque > 0) {
				this.setPoupanca(this.getPoupanca() - valorSaque);
				System.out.println("Saque de: R$"+valorSaque+" realizado com sucesso!\nNovo saldo da conta "+this.getNumeroConta()
				+ " poupança: R$"+this.getPoupanca());
			}else {
				throw new IllegalArgumentException("O valor do saque deve ser positivo e menor ou igual ao valor na conta.");
			}
		}else{
			throw new IllegalArgumentException("A conta deve estar ativada para realizar operacoes");
		}
	}
	
	public void transferirParaCorrente(float valorTransferencia) {
		this.sacarPoupanca(valorTransferencia);
		this.depositarCorrente(valorTransferencia);
		System.out.println("Tranferencia de R$"+valorTransferencia+" para conta corrente realizada com sucesso!\nSaldo conta "
				+ "corrente: R$"+this.getCorrente()+"\nSaldo conta poupanca: R$"+this.getPoupanca()); 
	}
	
	public void transferirParaPoupanca(float valorTransferencia) {
		this.sacarCorrente(valorTransferencia);
		this.depositarPoupanca(valorTransferencia);
		System.out.println("Tranferencia de R$"+valorTransferencia+" para conta poupanca realizada com sucesso!\nSaldo conta "
				+ "corrente: R$"+this.getCorrente()+"\nSaldo conta poupanca: R$"+this.getPoupanca()); 
	}
	
	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public boolean getContaAtivada() {
		return contaAtivada;
	}

	private void setContaAtivada(boolean contaAtivada) {
		this.contaAtivada = contaAtivada;
	}

	public float getCorrente() {
		return corrente;
	}

	private void setCorrente(float corrente) {
		if(corrente >= 0) {
			this.corrente = corrente;
		}else {
			throw new IllegalArgumentException("Valor precisa ser positivo ou zero.");
		}
	}

	public float getPoupanca() {
		return poupanca;
	}

	private void setPoupanca(float poupanca) {
		if(poupanca >= 0) {
			this.poupanca = poupanca;
		}else {
			throw new IllegalArgumentException("Valor precisa ser positivo ou zero.");
		}
	}
	
	//Todos os sets foram transformados em private para impedir de serem usados na classe Banco.

	@Override
	public String toString() {
		return "Conta [numeroConta=" + numeroConta + ", corrente=" + corrente + ", poupanca=" + poupanca
				+ ", toString()=" + super.toString() + "]"; 
	}

}
