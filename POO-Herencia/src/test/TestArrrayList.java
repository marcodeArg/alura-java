package test;

import java.util.ArrayList;

import modelo.Cuenta;
import modelo.CuentaCorriente;

public class TestArrrayList {
	public static void main(String[] args) {
		
		// Agregando los <>, permite especificar de que tipo van a ser los elementos. En caso de que se quiera cargar otro tipo,
		// lanzara un error el compilador
		ArrayList<Cuenta> lista = new ArrayList<Cuenta>();

		// Opciones alternativas para crear arrays
		// ArrayList lista = new ArrayList(24); // Con el tamaño que se desee
		// ArrayList lista = new ArrayList(lista); // A partir de otra lista
		
        Cuenta cc = new CuentaCorriente(22, 11);
        lista.add(cc);

        Cuenta cc2 = new CuentaCorriente(22, 22);
        lista.add(cc2);

        System.out.println("Tamaño: " + lista.size());

        Cuenta ref = (Cuenta) lista.get(0);
        System.out.println(ref.getNumero());

        lista.remove(0);
        System.out.println("Tamanho: " + lista.size());

        Cuenta cc3 = new CuentaCorriente(33, 311);
        lista.add(cc3);

        Cuenta cc4 = new CuentaCorriente(33, 322);
        lista.add(cc4);

        for(int i = 0; i < lista.size(); i++) {
            Object oRef = lista.get(i);
            System.out.println(oRef);
        }

        System.out.println("----------");

        // Foreach
        for(Object oRef : lista) {
            System.out.println(oRef);
        }
	}
}
