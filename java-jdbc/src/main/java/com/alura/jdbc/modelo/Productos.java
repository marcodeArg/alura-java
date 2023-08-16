package com.alura.jdbc.modelo;

public class Productos {
	private Integer id;
	private String nombre;
	private String descripcion;
	private Integer cantidad;
	private Integer idCategoria;
	
	
	public Productos(String nombre, String descripcion, Integer cantidad) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
	}
	
	public Productos(Integer id, String nombre, String descripcion, Integer cantidad) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
	}



	public Productos(int id, String nombre, int cantidad) {
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setIDCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	public Integer getIDCategoria() {
		return this.idCategoria;
	}
	
	@Override
	public String toString() {
		return "Id: " + this.id + " | Nombre del producto: " + this.nombre;
	}

	

	
	
}
