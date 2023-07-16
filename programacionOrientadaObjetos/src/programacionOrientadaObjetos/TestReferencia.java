package programacionOrientadaObjetos;

public class TestReferencia {
	
	
	public static void main(String[] args) {
		Cuenta primeraCuenta = new Cuenta();
		//primeraCuenta.saldo = 1500.56;
		
		//System.out.println("Primera cuenta: " + primeraCuenta.saldo);
		
		Cuenta cuentaReferencia = primeraCuenta;
		//cuentaReferencia.saldo = 100;
		
		System.out.println("Modificado cuentaReferencia");
		
		//System.out.println("Primera cuenta: " + primeraCuenta.saldo);
		//System.out.println("Segunda cuenta: " + cuentaReferencia.saldo);
		
		//primeraCuenta.saldo += 300;
		
		System.out.println("Modificado cuentaReferencia otra vez");
		
		//System.out.println("Primera cuenta: " + primeraCuenta.saldo);
		//System.out.println("Segunda cuenta: " + cuentaReferencia.saldo);
		
		// Both of the objects points to the same memory space
		
		System.out.println("\n"+primeraCuenta);
		System.out.println(cuentaReferencia);
	}
	
}
