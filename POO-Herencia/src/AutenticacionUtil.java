
public class AutenticacionUtil {

	private String clave;
	

	public void setClave(String clave) {
		this.clave = clave;
	}

	public boolean login() {
		return this.clave == "Password123";
	}
	
}
