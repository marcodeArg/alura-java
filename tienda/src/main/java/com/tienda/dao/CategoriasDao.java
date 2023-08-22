package com.tienda.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.tienda.modelo.Categorias;

public class CategoriasDao {

	private EntityManager em;
	
	public CategoriasDao(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Categorias categoria) {
		this.em.persist(categoria);
	}
	
	public void actualizar(Categorias categoria) {
		this.em.merge(categoria);
	}
	
	public void eliminar(Categorias categoria) {
		categoria = this.em.merge(categoria);
		this.em.remove(categoria);
	}
	
	public Categorias buscarPorID(int id) {
		return this.em.find(Categorias.class, id);
	}
	 
	public List<Categorias> buscarTodos() {
		String jpql = "SELECT C FROM categorias C";
		return this.em.createQuery(jpql, Categorias.class).getResultList();
	}
}
