package modelo;


	//comentario en linea

	/*
	 * comentario en bloque
	 */


	/**
	 *  Tendria que ser un javadoc pero no esta andando
	 */

public class Administrador extends Funcionario implements Autenticable {
	// Modificadores
	// public		Accesible desde todos lados
	// default		Accesible solamente desde el mismo paquete (paquete = carpeta)
	// protected	default + clases hijas
	// private		Accesible solamente desde la misma clase
	
	
	
	
	
	
	
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
