package com.tienda.prueba;

import java.math.BigDecimal;

import com.tienda.dao.CategoriasDao;
import com.tienda.dao.ProductosDao;
import com.tienda.modelo.Categorias;
import com.tienda.modelo.Productos;
import com.tienda.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class RegistroProducto {
	public static void main(String[] args) {
		/**
		 * @aclaracion Entidad hace referencia a una instancia de la clase que a su vez hace
		 * 				referencia a una fila de la tabla
		 * 
		 * En cuanto a JPA tenemos 4 estados: Transient, Managed, Detached, Removed
		 * Transient es el estado en el que JPA no trackea a la entidad
		 * Managed es el estado en el que la JPA trackea a la entidad. Para que una entidad 
		 * pase a estado managed, hay que usar alguno de las siguientes opciones:
		 * 		<code>
		 *  			em.persist(entidad) <- agrega la entidad al estado managed y tambien agrega la fila a memoria
		 *  			Modelo entidad = em.find(modelo, codigoPK) <- recupera una entidad especifica de la base de datos
		 *  			entidad = em.merge(entidad) <- devuelve una instancia de la entidad agregada o actualizada
		 *  	</code>
		 *  Detached es el estado en el que la JPA deja de trackear una entidad o muchas a la vez. Para
		 *  hacer esto se puede usar:
		 *  	<code>
		 *  			em.detach(entidad) <- saca la entidad especifica
		 *  			em.clear() <- saca todas las entidades
		 *  			em.close() <- saca todas las entidades y cierra el objeto EntityManager
		 *  	</code>
		 *  Removed ...
		 *  
		 *  
		 *  Para poder administrar todos estos estados y las entidades necesitamos crear objetos del tipo EntityManager
		 *  que sera el encargado de administrar las entidades
		 *  
		 *  	<code>
		 *  			EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory(nombre_tabla)
		 *  			EntityManager em = FACTORY.createEntityManager()
		 *  	</code>
		 *  
		 *  Una vez que tenemos el administrador, necesitamos iniciar la comunicacion con la base de datos
		 *  	
		 *  	<code>
		 *  			em.getTransaction().begin();
		 *  	</code>
		 *  
		 *  Ahora se puede realizar cualquier tipo de manipulacion en la tabla con el administrador. Una
		 *  vez que ya se hayan realizado los cambios necesarios, hay que mandar los cambios a la base de datos
		 *  
		 *  	<code>
		 *  			em.getTransaction().commit(); <- finaliza la transacción y hace permanentes los cambios
		 *  			em.flush(); <- sincroniza los cambios en la base de datos sin finalizar la transacción
		 *  			em.getTransaction().rollback(); <- deshacer una transacción en caso de que algo salga mal o 
		 *  												ocurra un error antes de hacer un commit
		 *  			
		 *  			@aclaracion transaccion hace referencia a todas las operaciones que se realicen
		 *  	</code>
		 *  
		 *  Operaciones que se pueden hacer mientras esta en estado managed
		 *  
		 *  	<code>
		 *  			em.remove(entidad) <- eliminar una entidad de la base de datos
		 *  			em.merge(entidad); <- sincroniza los cambios en la base de datos sin finalizar la transacción
		 *  			em.getTransaction().rollback(); <- deshacer una transacción en caso de que algo salga mal o 
		 *  												ocurra un error antes de hacer un commit
		 *  			
		 *  			@aclaracion transaccion hace referencia a todas las operaciones que se realicen
		 *  	</code>
		 */	
		
		
		// ENTIDAD EN ESTADO TRANSIST
		Categorias celulares = new Categorias("CELULARES");
		Productos celular = new Productos("Samsung", "Celular Samsung A10", new BigDecimal(1800), celulares);
		
		EntityManager em = JPAUtils.getEntityManager();
		
		ProductosDao pd = new ProductosDao(em);
		CategoriasDao cd = new CategoriasDao(em);
		
		
		
		
		
	}
}
	