
public class Gerente extends Funcionario {
	private String clave;

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public boolean login() {
		return this.clave == "Password123";
	}
	
	// Method overwrite
	public double getBonification() {
		return super.getSalary();
	}
}
