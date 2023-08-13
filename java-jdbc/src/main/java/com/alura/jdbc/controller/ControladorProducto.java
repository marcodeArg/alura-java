package com.alura.jdbc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alura.jdbc.dao.ProductosDAO;
import com.alura.jdbc.factory.ConnectionFactory;
import com.alura.jdbc.modelo.Productos;

public class ControladorProducto {
	
	ProductosDAO dao;
	
	public ControladorProducto() {
		this.dao = new ProductosDAO(new ConnectionFactory().setConnection());
	}
	
	public void modificar(String nombre, String descripcion, Integer cantidad, Integer id) {
		dao.modificar(nombre, descripcion, cantidad, id);
	}

	public int eliminar(Integer id) {
		return dao.eliminar(id);
		
	}

	public List<Productos> listar() {
		return dao.listar();
	}

    public void guardar(Productos producto){
		dao.guardar(producto);
	}
	
}
