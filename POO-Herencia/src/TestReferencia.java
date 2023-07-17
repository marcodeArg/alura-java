
public class TestReferencia {
	public static void main(String[] args) {
		
		// The element most generic can be adapt to the element
		// most specific. E.g.
		// Funcionario objFunc = new Gerente(); (work)
		// Gerente objGer = new Funcionario(); (doesn't work)
		
		// Todos los gerentes son funcionarios
		// Pero no todos los funcionarios son gerentes
		
		Funcionario objFunc = new Gerente();
		objFunc.setName("Pedro");
		
		Gerente objGer = new Gerente();
		objGer.setName("Julia");
		
		objFunc.setSalary(15000);
		objGer.setSalary(20000);
	}
}
