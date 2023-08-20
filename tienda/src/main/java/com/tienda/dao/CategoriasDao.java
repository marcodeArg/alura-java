package com.tienda.dao;

import javax.persistence.EntityManager;

import com.tienda.modelo.Categorias;

public class CategoriasDao {

	private EntityManager em;
	
	public CategoriasDao(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Categorias categoria) {
		em.persist(categoria);
	}
}
