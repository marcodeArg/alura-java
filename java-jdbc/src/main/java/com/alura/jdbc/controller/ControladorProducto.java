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

public class ControladorProducto {
	public void modificar(String nombre, String descripcion, Integer id) {
		// TODO
	}

	public void eliminar(Integer id) {
		// TODO
	}

	public List<Map<String, String>> listar() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/control_de_stock", "postgres", "43451105Abc");
		
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

    public void guardar(Object producto) {
		// TODO
	}
}
