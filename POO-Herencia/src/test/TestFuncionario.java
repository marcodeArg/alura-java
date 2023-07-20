package test;
import modelo.Funcionario;
import modelo.Gerente;


public class TestFuncionario {
	public static void main(String[] args) {
		Funcionario mrc = new Gerente();
		
		mrc.setId("42345678");
		mrc.setName("Mrc");
		mrc.setSalary(150000);
		
		System.out.println("Bonification: " + mrc.getSalary());
		System.out.println("Bonification: " + mrc.getBonification());
	}
}
