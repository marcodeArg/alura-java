// Las clases abstractas no pueden ser instanciadas, pero si heredadas. Pero si se puede declarar una variable del tipo abstracto
// Y para poder instanciar un tipo de dato abstracto, es a travez de alguna clase hija que no sea abstracta.
// Las clases abstractas es como en la realidad. Por ejemplo en este caso seria Funcionario (trabajador) es algo abstracto,un concepto.
// Ahora de esta clase herda Gerente (no abstracto), y tambien cualquier otro puesto (Contador, diseñador, analista)

// Ademas dentro de la clases abstractas puedo crear metodos abstractos a los cuales no les tengo que colocar nada en el cuerpo 
// (ni inclusive los corchetes. Esto obliga a que en todas las clases que hereden de la clase con metodo abstracto, tengan que crear
// el metodo obligatoriamente.

public abstract class Funcionario {
	private String name;
	private String id;
	private double salary;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public abstract double getBonification();
	
}
