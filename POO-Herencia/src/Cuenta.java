

public class Cuenta {
	private double saldo; //this depend of the instance
	private int agencia; //this depend of the instance
	private int numero; //this depend of the instance
	private Cliente titular = new Cliente(); //this depend of the instance
	
	public static int total = 0; // this depend of the class, because of STATIC.
	// I can make setters and getter of this total. But it need to point to the class, not to this
	
	
	public Cuenta(int agencia, int numero) {
		this.agencia = agencia;
		this.numero = numero;
		
		Cuenta.total++;
	}
	
	//public int getTotal() {
	//	return Cuenta.total;
	//} 
	// and now, having this, latter on my code I will need to use the instance, because it's a method. So to solve this
	// problem, I should turn this method, static. 
	
	public static int getTotal() {
		return Cuenta.total;
	}
	
	
	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Cliente getTitular() {
		return this.titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public int getAgencia() {
		return this.agencia;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	

	public double getSaldo() { //getter
		return this.saldo;
	}
	
	public void setAgencia(int valor) { //setter
		
		if (valor >= 1) {
			this.agencia = valor;
		} else {
			System.out.println("No se aceptan valores negativos!");
		}
	}
	
	
	public boolean transferir(double valor, Cuenta cuenta) throws SaldoInsuficienteException {
		if (this.saldo >= valor) {
			this.retirar(valor);
			cuenta.depositar(valor);;
			return true;
		} else {
			return false;
		}
	}
	
	public void retirar(double valor) throws SaldoInsuficienteException {
		if (this.saldo < valor) 
		{
			throw new SaldoInsuficienteException("No tiene saldo suficiente");
		}
		
		this.saldo -= valor;
	}
	
	public void depositar(double valor) {
		this.saldo += valor;
	}
}
