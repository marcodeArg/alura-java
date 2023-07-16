package programacionOrientadaObjetos;

public class PruebaMetodos {
	public static void main(String[] args) {
		
		Cuenta cuentaDiego = new Cuenta();
		Cuenta cuentaMarco = new Cuenta();
		cuentaDiego.depositar(150.4);
		cuentaMarco.depositar(800);
		
		//System.out.println("Saldo actual " + cuentaDiego.saldo);
		
		cuentaDiego.retirar(50);
		//System.out.println("Saldo actual " + cuentaDiego.saldo);
		
		if(cuentaDiego.retirar(75.8)) 
		{
			//System.out.println("Retiraste $75.8\nSaldo actual: " + cuentaDiego.saldo);
		}
		else 
		{
			//System.out.println("No pudiste retirar $75.8, porque tienes: " + cuentaDiego.saldo);
		}
		
		if(cuentaDiego.retirar(90)) 
		{
			//System.out.println("Retiraste $90\nSaldo actual: " + cuentaDiego.saldo);
		}
		else 
		{
			//System.out.println("No pudiste retirar $90, porque tienes: " + cuentaDiego.saldo);
		}
		
		if(cuentaDiego.transferir(10.15, cuentaMarco)) 
		{
			//System.out.println("Transferiste $10.15 a Marco.\nSaldo actual: " + cuentaDiego.saldo);
		}
		else 
		{
			//System.out.println("No pudiste transferir, porque tienes: " + cuentaDiego.saldo);
		}
		
		
		
	}
}
