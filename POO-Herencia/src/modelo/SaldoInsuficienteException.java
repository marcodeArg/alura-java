// Si heredo de exception, en todos los methodos que se que me va a largar la excepcion tengo que colocar, despues de los parametros,
// throws NombreException y despues en algun metodo tengo que usar try... catch si o si. (CHECKED, el compilador verifica que se maneje la exception)
// Si me quiero ahorrar todo esto, hay que heredar de RuntimeException, y despues puedo usar un try... catch solamente si quiero o creo
// conveniente. (UNCHECKED, el compilador no verifica que se maneje la exception)
package modelo;

public class SaldoInsuficienteException extends Exception {
	
	public SaldoInsuficienteException(String mensaje) {
		super(mensaje);
	}
	
}
