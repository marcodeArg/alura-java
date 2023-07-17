
public class Administrador extends Funcionario implements Autenticable {

	private AutenticacionUtil util;
	
	public Administrador() {
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
		// TODO Auto-generated method stub
		return 0;
	}
}
