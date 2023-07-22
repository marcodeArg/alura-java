package modelo;

public class GuardaCuentas {
	Cuenta[] cuenta;
	private int i;
	
	
	public GuardaCuentas() {
		this.cuenta = new Cuenta[10];
		this.i = 0;
	}
	
	public void Agregar(Cuenta c) {
		cuenta[this.i] = c;
		this.i++;
	}
	
	public Cuenta obtener(int indice) {
		return cuenta[this.i];
	}
	
	
}

