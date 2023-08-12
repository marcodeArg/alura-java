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

import com.alura.jdbc.factory.ConnectionFactory;

public class ControladorProducto {
	public void modificar(String nombre, String descripcion, Integer cantidad, Integer id) throws SQLException {
		
		ConnectionFactory connFactory = new ConnectionFactory();
		// Stablishing this as final, and then using it in the try sentence, work as the "using" sentence in c#
		final Connection conn = connFactory.setConnection();
		
		// Know as try with resources
		try(conn) {
			final PreparedStatement sentencia = conn.prepareStatement(""
					+ "UPDATE productos SET nombre = ?, descripcion = ?, cantidad = ? WHERE id = ?");
			
			try(sentencia) {
				sentencia.setString(1, nombre);
				sentencia.setString(2, descripcion);
				sentencia.setInt(3, cantidad);
				sentencia.setInt(4, id);
				
				sentencia.execute();
			}
		}
		
	}

	public int eliminar(Integer id) throws SQLException {
		ConnectionFactory connFactory = new ConnectionFactory();
		final Connection conn = connFactory.setConnection();
		int updateCount;
		
		try(conn) {
			// This is a wrong way to do it, because it will be open to sql inyection
			//Statement sentencia = conn.createStatement();
			//sentencia.execute("DELETE FROM productos WHERE id=" + id);
			
			// And this is the safe way
			final PreparedStatement sentencia = conn.prepareStatement("DELETE FROM productos WHERE id=?");
			
			try(sentencia) {
				sentencia.setInt(1, id);
				sentencia.execute();
				updateCount = sentencia.getUpdateCount();				
			}	
		}
		
		return updateCount;
		
	}

	public List<Map<String, String>> listar() throws SQLException {
		
		ConnectionFactory connFactory = new ConnectionFactory();
		final Connection conn = connFactory.setConnection();
		
		List<Map<String, String>> registros = new ArrayList<>();
		
		try(conn) {
			final Statement sentencia = conn.createStatement();
			
			try(sentencia) {
				// Esto lo puedo guardar en una variable boleana, si se asigna un true significa que el comando devuelve algo (SELECT) y si se 
				// le asigna false (UPDATE, DELETE, ...), significa que no
				sentencia.execute("SELECT id, nombre, descripcion, cantidad FROM productos");
				
				// Tambien otra forma, es ejecutar la query y guardarla en un resulset directamente
				// El ResultSet es como un DataRow, apunta a una fila de lo que devuelve la query, y para ir a otra fila se usa el metodo next.
				// *** ResultSet set = sentencia.executeQuery("SELECT id, nombre, descripcion, cantidad FROM productos"); ***
				
				ResultSet filasRegistros = sentencia.getResultSet();
				
				

				while(filasRegistros.next()) {
					Map<String, String> fila = new HashMap<>();
					fila.put("ID", String.valueOf(filasRegistros.getInt("id")));
					fila.put("Nombre", filasRegistros.getString("nombre"));
					fila.put("Descripcion", filasRegistros.getString("descripcion"));
					fila.put("Cantidad", String.valueOf(filasRegistros.getInt("cantidad")));
					
					registros.add(fila);
				}
			}
		}
		
		return registros;
	}

    public void guardar(Map<String, String> producto) throws SQLException{
    	String nombre = producto.get("Nombre");
    	String descripcion = producto.get("Descripcion");
    	Integer cantidad = Integer.valueOf(producto.get("Cantidad"));
    	Integer cantidadMax = 50;
    	
    	ConnectionFactory connFactory = new ConnectionFactory();
		final Connection conn = connFactory.setConnection();
		
		try(conn) {
			conn.setAutoCommit(false);
			
			final PreparedStatement sentencia = conn.prepareStatement("INSERT INTO productos(nombre, descripcion, cantidad) VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			try (sentencia) {
				do {
					Integer cantidadAGuardar = Math.min(cantidadMax, cantidad);
					
					guardarItems(nombre, descripcion, cantidadAGuardar, sentencia);
					
					cantidad -=  cantidadMax;
					
				} while (cantidad > 0);
				
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
			}
		}
		
    	
	}

	private void guardarItems(String nombre, String descripcion, Integer cantidad, PreparedStatement sentencia) throws SQLException {
		sentencia.setString(1, nombre);
		sentencia.setString(2, descripcion);
		sentencia.setInt(3, cantidad);
		sentencia.execute();
    	
		ResultSet pk = sentencia.getGeneratedKeys();
		
		while(pk.next()) {
			System.out.println("El id del producto nuevo es: " + pk.getInt("id"));
		}
	}
	
}
