package main;

public interface OperacoesBancarias {
	
	public void ativarConta();
	
	public void desativarConta();
	
	public void depositarCorrente(float valorDeposito);
	
	public void depositarPoupanca(float valorDeposito);
	
	public void sacarCorrente(float valorSaque);
	
	public void sacarPoupanca(float valorSaque);
	
	public void transferirParaCorrente(float valorTransferencia);
	
	public void transferirParaPoupanca(float valorTransferencia);

}
