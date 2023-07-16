package javaPrimerosPasos;

public class condicionales {
	
	public static void main(String[] args) 
	{
		int edad = 21;
		
		if(edad >= 18) {
			System.out.println("Puedes entrar");
		} else {
			System.out.println("Debes ser mayor para ingresar");
		}
		
		if(edad >= 100) // If we don't add brackets and the condition is evaluated as true, 
						// the first thing that comes after the if, will be executed (work fine with if and else)
			System.out.println("Como seguis vivo?");
		
		// || or
		// && and
		
		boolean condicionFalsa; // All boolean when it's declared, it will be initialize with false. But if latter on u want to print it, it must be explicitly initialized
		boolean condicion = true;
		condicion = edad > 10;
	}
}
