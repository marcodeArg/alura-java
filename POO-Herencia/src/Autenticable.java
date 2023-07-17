
// Las interfaces son como un sello, en donde todos los que implementen la interface (tengan el sello), deberan
// crear los metodos de la interface obligatoriamente. Las interfaces no pueden tener atributos ni constructores.
// TODA interfaz y sus metodos, son abstractos.

public interface Autenticable {
	
	public void setClave(String clave);
	
	public boolean login();
}
