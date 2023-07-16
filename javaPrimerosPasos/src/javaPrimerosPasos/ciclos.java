package javaPrimerosPasos;

public class ciclos {
	public static void main(String[] args) {
		
		System.out.println("While");
		int contador = 1;
		
		while(contador<=10) {
			System.out.println(contador);
			contador++;
		}
		
		System.out.println("-----");
		System.out.println("For");
		
		for (int contadorFor = 1; contadorFor <= 10; contadorFor++) {
			
			System.out.println(contadorFor);
			break;
		}
		
		int factorial = 5;
		int result = 1;
		
		while(factorial >= 1) {
			result *= factorial;
			factorial--;
		}
		
		System.out.println(result);
	}
}
