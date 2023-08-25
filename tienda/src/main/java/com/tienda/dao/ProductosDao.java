package com.tienda.dao;

import java.math.BigDecimal;
import java.util.List;

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
	
	public Productos buscarPorID(int id) {
		return this.em.find(Productos.class, id);
	}
	 
	public List<Productos> buscarTodos() {
		String jpql = "SELECT P FROM Productos AS P";
		return this.em.createQuery(jpql, Productos.class).getResultList();
	}
	
	public List<Productos> buscarPorNombre(String nombre) {
		String jpql = "SELECT P FROM Productos AS P WHERE P.nombre=:nombre";
		return this.em.createQuery(jpql, Productos.class).setParameter("nombre", nombre).getResultList();
	}
	
	public List<Productos> buscarPorNombreCategoria(String nombre) {
		String jpql = "SELECT P FROM Productos AS P WHERE P.categoria.nombre=:nombre";
		return this.em.createQuery(jpql, Productos.class).setParameter("nombre", nombre).getResultList();
	}
	
	public BigDecimal buscarPrecioPorNombre(String nombre) {
		String jpql = "SELECT P.precio FROM Productos AS P WHERE P.nombre=:nombre";
		return this.em.createQuery(jpql, BigDecimal.class).setParameter("nombre", nombre).getSingleResult();
	}
}
