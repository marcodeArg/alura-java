package test;

import modelo.Cuenta;
import modelo.CuentaAhorro;
import modelo.CuentaCorriente;

public class TestMain {
	public static void main(String[] args) {
		
		int edad1 = 20;
		int edad2 = 40;
		int edad3 = 36;
		
		int[] edades = new int[5];
		
		edades[0] = edad1;
		edades[1] = edad2;
		edades[2] = edad3;
		
		for(int i = 0; i < edades.length; i++) {
			System.out.println(edades[i]);
		}
		
		
		Cuenta[] cuentas = new Cuenta[5];
        CuentaCorriente cc1 = new CuentaCorriente(22, 11);
        cuentas[0] = cc1;

        // crea instancia de CuentaAhorro
        CuentaAhorro ca2 = new CuentaAhorro(22, 22);
        cuentas[1] = ca2;    

        System.out.println(cuentas[1].getNumero()  );

        // Hay que hacerle un cast, porque al ser de tipo cuenta da error al momento de compilar
        CuentaCorriente ref = (CuentaCorriente) cuentas[0];
        System.out.println(ref.getNumero());
	}
}
