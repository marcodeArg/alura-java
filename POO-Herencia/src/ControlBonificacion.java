
public class ControlBonificacion {
	private double suma;
	
	public double registrarSalario(Funcionario funcionario) {
		this.suma += funcionario.getBonification();
		System.out.println("Calculado: " + this.suma);
		return this.suma;
	}
}
