package modelo;

public class Gerente extends Funcionario implements Autenticable {
	
	private AutenticacionUtil util;
	
	public Gerente() {
		util = new AutenticacionUtil();
	}
	
	@Override
	public void setClave(String clave) {
		this.util.setClave(clave);
	}

	@Override
	public boolean login() {
		return this.util.login();
	}


	@Override
	public double getBonification() {
		return super.getSalary();
	}
}
