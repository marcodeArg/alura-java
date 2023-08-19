package com.tienda.prueba;

import java.math.BigDecimal;

import com.tienda.modelo.Productos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RegistroProducto {
	public static void main(String[] args) {
		
		Productos celular = new Productos();
		celular.setNombre("Samsung");
		celular.setDescripcion("Celular Samsung modelo A10");
		celular.setPrecio(new BigDecimal(1000));
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tienda");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(celular);
		em.getTransaction().commit();
		em.close();
	}
}
	