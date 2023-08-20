package com.tienda.prueba;

import java.math.BigDecimal;

import com.tienda.dao.CategoriasDao;
import com.tienda.dao.ProductosDao;
import com.tienda.modelo.Categorias;
import com.tienda.modelo.Productos;
import com.tienda.utils.JPAUtils;

import javax.persistence.EntityManager;


public class RegistroProducto {
	public static void main(String[] args) {
		Categorias celulares = new Categorias("Celular");
		
		Productos celular = new Productos("Samsung",
				"Celular Samsung modelo A10",
				new BigDecimal(1000), celulares
				);

		
		EntityManager em = JPAUtils.getEntityManager();
		
		ProductosDao pd = new ProductosDao(em);
		CategoriasDao cd = new CategoriasDao(em);
		
		em.getTransaction().begin();
		
		cd.guardar(celulares);
		pd.guardar(celular);

		em.getTransaction().commit();
		em.close();
	}
}
	