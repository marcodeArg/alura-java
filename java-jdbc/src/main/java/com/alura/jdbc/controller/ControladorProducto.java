package com.alura.jdbc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alura.jdbc.factory.ConnectionFactory;

public class ControladorProducto {
	public void modificar(String nombre, String descripcion, Integer id) {
		// TODO
	}

	public int eliminar(Integer id) throws SQLException {
		ConnectionFactory connFactory = new ConnectionFactory();
		Connection conn = connFactory.setConnection();
		
		Statement sentencia = conn.createStatement();
		sentencia.execute("DELETE FROM productos WHERE id=" + id);
					
		conn.close();
		return sentencia.getUpdateCount();
	}

	public List<Map<String, String>> listar() throws SQLException {
		
		ConnectionFactory connFactory = new ConnectionFactory();
		Connection conn = connFactory.setConnection();
		
		Statement sentencia = conn.createStatement();
		
		// Esto lo puedo guardar en una variable boleana, si se asigna un true significa que el comando devuelve algo (SELECT) y si se 
		// le asigna false (UPDATE, DELETE, ...), significa que no
		sentencia.execute("SELECT id, nombre, descripcion, cantidad FROM productos");
		
		// Tambien otra forma, es ejecutar la query y guardarla en un resulset directamente
		// El ResultSet es como un DataRow, apunta a una fila de lo que devuelve la query, y para ir a otra fila se usa el metodo next.
		// *** ResultSet set = sentencia.executeQuery("SELECT id, nombre, descripcion, cantidad FROM productos"); ***
		
		ResultSet filasRegistros = sentencia.getResultSet();
		
		List<Map<String, String>> registros = new ArrayList<>();

		while(filasRegistros.next()) {
			Map<String, String> fila = new HashMap<>();
			fila.put("ID", String.valueOf(filasRegistros.getInt("id")));
			fila.put("Nombre", filasRegistros.getString("nombre"));
			fila.put("Descripcion", filasRegistros.getString("descripcion"));
			fila.put("Cantidad", String.valueOf(filasRegistros.getInt("cantidad")));
			
			registros.add(fila);
		}
		
		conn.close();
		return registros;
	}

    public void guardar(Map<String, String> producto) throws SQLException{
    	ConnectionFactory connFactory = new ConnectionFactory();
		Connection conn = connFactory.setConnection();
		
		Statement sentencia = conn.createStatement();
		sentencia.execute("INSERT INTO productos(nombre, descripcion, cantidad) VALUES"
				+ "('" + producto.get("Nombre") +"', "
						+ "'" + producto.get("Descripcion") + "', "
								+ producto.get("Cantidad") +")", sentencia.RETURN_GENERATED_KEYS);
    	
		ResultSet pk = sentencia.getGeneratedKeys();
		
		while(pk.next()) {
			System.out.println("El id del producto nuevo es: " + pk.getInt("id"));
		}
		
		conn.close();
    	
	}
}
