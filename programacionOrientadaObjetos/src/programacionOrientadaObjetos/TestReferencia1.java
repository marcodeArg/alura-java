package programacionOrientadaObjetos;

public class TestReferencia1 {
	public static void main(String[] args) {
		Cliente juan = new Cliente();
		juan.setNombre("Juan");
		juan.setDireccion("Alo svossdao Blv.");
		juan.setDocumento("452894201");
		juan.setTelefono("0929842");
		
		Cuenta cuentaJuan = new Cuenta();
		cuentaJuan.setTitular(juan);
		//cuentaJuan.saldo = 900;
		
		System.out.println("Nombre: "+cuentaJuan.getTitular().getNombre());
		System.out.println("Documento: "+cuentaJuan.getTitular().getDocumento());
		//System.out.println("Saldo: "+cuentaJuan.saldo);
		
		// Cuenta cuentaPedro = new Cuenta();
		// cuentaPedro.titular.nombre = "Pedro"; 
		// This will throw an exception cause all the objects, the default value is Null
		// and when u trie to change the "nombre" of a null objecte it will crash.
		// So first, the object need to be created to use it
		// Another way to solve this problem is creating a new object inside my class, so when my class is initialized
		// it will create the object automatically (look at Cuenta class)
	}
}
