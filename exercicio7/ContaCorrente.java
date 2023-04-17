package exercicio7;

public class ContaCorrente {
	private float saldo; 
	
	public  void  depositar(float valor) {
		saldo += valor;
	};
	
	public  void sacar(float valor) {
		saldo -= valor;
	};
	
	public float getSaldo() {
		return saldo; 
	}
	
}
