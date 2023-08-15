package com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alura.jdbc.modelo.Categorias;

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
}
