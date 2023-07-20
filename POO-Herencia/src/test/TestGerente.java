package test;
import modelo.Gerente;

public class TestGerente {
	public static void main(String[] args) {
		
		Gerente pedro = new Gerente();
		pedro.setClave("Password123");
		pedro.setSalary(200000);
		
		if (pedro.login()) {			
			System.out.println("Logged In");
		}
		
		System.out.println("Bonification: " + pedro.getSalary());
		System.out.println("Bonification: " + pedro.getBonification());
	}
}
