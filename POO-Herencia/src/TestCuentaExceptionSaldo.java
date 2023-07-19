
public class TestCuentaExceptionSaldo {
	
	
	public static void main(String[] args) {
		Cuenta cuenta = new CuentaCorriente(22, 1);
		
		cuenta.depositar(100);
		
		try {
			cuenta.retirar(500);
		} catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
		}
	}
}
