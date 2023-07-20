package modelo;

public class SistemaInterno {
	
	private String clave = "Password123";
	
	public void autentica(Autenticable autenticable) {
		autenticable.setClave(clave);
		boolean puedeIniciarSesion = autenticable.login();
		
		if (puedeIniciarSesion) {
			System.out.println("Bienvenido");
	
		} else {
			System.out.println("Acceso denegado");
			
		}
	}
}
