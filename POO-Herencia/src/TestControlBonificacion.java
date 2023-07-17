
public class TestControlBonificacion {
	public static void main(String[] args) {
		Funcionario objFunc = new Gerente();
		objFunc.setName("Pedro");
		objFunc.setSalary(15000);
		
		Gerente objGer = new Gerente();
		objGer.setName("Julia");
		objGer.setSalary(20000);
		
		ControlBonificacion objBoni = new ControlBonificacion();
		objBoni.registrarSalario(objFunc);
		objBoni.registrarSalario(objGer);
		
	}
}
