package modelo;
public class Cliente implements Autenticable {
	private String nombre;
	private String documento;
	private String telefono;
	private String direccion;
	
	private AutenticacionUtil util;
	
	public Cliente() {
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
	
		
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}
