package com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alura.jdbc.modelo.Categorias;
import com.alura.jdbc.modelo.Productos;

public class CategoriasDAO {
	final Connection conn;
	
	public CategoriasDAO(Connection conn) {
		this.conn = conn;
	}
	
	public List<Categorias> listar() {
		try(conn) {
			final PreparedStatement sentencia = conn.prepareStatement("SELECT * FROM categorias");;
			
			try(sentencia) {
				List<Categorias> registros = new ArrayList<>();
				
				sentencia.execute();
				ResultSet filasRegistros = sentencia.getResultSet();
				
				while(filasRegistros.next()) {
					registros.add(new Categorias(filasRegistros.getInt("id"), filasRegistros.getString("nombre")));
				}
				
				return registros;
				
			}
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Categorias> listarConProductos() {
		try(conn) {
			final PreparedStatement sentencia = conn.prepareStatement("SELECT c.id, c.nombre, p.id, p.nombre, p.cantidad FROM categorias c"
					+ "INNER JOIN productos p ON c.id = p.id_categoria");
			
			try(sentencia) {
				List<Categorias> registros = new ArrayList<>();
				
				sentencia.execute();
				ResultSet filasRegistros = sentencia.getResultSet();
				
				while(filasRegistros.next()) {
					Integer categoriaID = filasRegistros.getInt("c.id");
					String categoriaNombre = filasRegistros.getString("c.nombre");
					
					var categoria = registros.stream().filter(cat -> cat.getId().equals(categoriaID)).findAny().orElseGet(() -> {
						Categorias cat = new Categorias(categoriaID, categoriaNombre);
						
						registros.add(cat);
						
						return cat;
					});
					
					Productos producto = new Productos(filasRegistros.getInt("p.id"), filasRegistros.getString("p.nombre"), filasRegistros.getInt("p.cantidad"));
				}
				
				return registros;
				
			}
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
