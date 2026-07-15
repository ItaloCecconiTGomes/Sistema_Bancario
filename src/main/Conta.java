package main;
import java.time.LocalDate;
import java.util.Random;

public class Conta  implements OperacoesBancarias{ 

	private int numeroAgencia;
	private int numeroConta;
	private boolean contaAtivada;
	private float corrente;
	private float poupanca;
	private int idDono;
	
	
	public Conta(float corrente, float poupanca, int idDono) {
		Random gerador = new Random();
		this.numeroAgencia = gerador.nextInt(9000) + 1000;
		this.numeroConta = gerador.nextInt(900000) + 100000;
		this.contaAtivada = true;
		this.setCorrente(corrente);
		this.setPoupanca(poupanca);
		this.idDono = idDono;
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

	public int getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(int numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
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

	public int getIdDono() {
		return this.idDono;
	}

	public void setIdDono(int idDono) {
		this.idDono = idDono;
	}
	
	//Todos os sets foram transformados em private para impedir de serem usados na classe Banco.

	@Override
	public String toString() {
		return "Conta [numeroAgencia=" + numeroAgencia + ", numeroConta=" + numeroConta + ", contaAtivada="
				+ contaAtivada + ", corrente=" + corrente + ", poupanca=" + poupanca + ", toString()="
				+ super.toString() + "]";
	}
	
}
