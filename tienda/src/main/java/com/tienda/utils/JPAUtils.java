package com.tienda.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {

	private static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("tienda_alura");
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}	
}
