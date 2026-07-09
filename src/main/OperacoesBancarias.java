package main;

public interface OperacoesBancarias {
	
	public void depositarCorrente(float valorDeposito);
	
	public void depositarPoupanca(float valorDeposito);
	
	public void sacarCorrente(float valorSaque);
	
	public void sacarPoupanca(float valorSaque);

}
