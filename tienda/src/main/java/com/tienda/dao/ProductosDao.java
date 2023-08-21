package com.tienda.dao;

import javax.persistence.EntityManager;

import com.tienda.modelo.Productos;

public class ProductosDao {

	private EntityManager em;
	
	public ProductosDao(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Productos producto) {
		em.persist(producto);
	}
	
	public void actualizar(Productos producto) {
		this.em.merge(producto);
	}
	
	public void eliminar(Productos producto) {
		producto = this.em.merge(producto);
		this.em.remove(producto);
	}
}
