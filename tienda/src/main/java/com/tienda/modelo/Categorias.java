package com.tienda.modelo;

import javax.persistence.*;

@Entity
@Table(name="categorias")
public class Categorias {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nombre;
	
	public Categorias(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
}
