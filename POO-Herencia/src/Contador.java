
public class Contador extends Funcionario{
	
	@Override
	public double getBonification() {
		return super.getSalary() * 0.05; 
	}
}
