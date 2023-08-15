package com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alura.jdbc.modelo.Productos;

public class ProductosDAO {
	
	final Connection conn;
	
	public ProductosDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void guardar(Productos producto){
    	
		try(conn) {
			final PreparedStatement sentencia = conn.prepareStatement("INSERT INTO productos(nombre, descripcion, cantidad, id_categoria) VALUES(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			try (sentencia) {
				guardarItems(producto, sentencia);
			} 
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	private void guardarItems(Productos producto, PreparedStatement sentencia) throws SQLException {
		sentencia.setString(1, producto.getNombre());
		sentencia.setString(2, producto.getDescripcion());
		sentencia.setInt(3, producto.getCantidad());
		sentencia.setInt(4, producto.getIDCategoria());
		sentencia.execute();
    	
		ResultSet pk = sentencia.getGeneratedKeys();
		
		while(pk.next()) {
			producto.setId(pk.getInt("id"));
			System.out.println("El producto nuevo es: " + producto);
		}
	}

	public List<Productos> listar() {
		
		List<Productos> registros = new ArrayList<>();
		
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
					Integer id = filasRegistros.getInt("id");
					String nombre = filasRegistros.getString("nombre");
					String descripcion = filasRegistros.getString("descripcion");
					Integer cantidad = filasRegistros.getInt("cantidad");
					
					registros.add(new Productos(id, nombre, descripcion, cantidad));
				}
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return registros;
	}

	
	public List<Productos> listar(Integer idCategoria) {
		List<Productos> registros = new ArrayList<>();
		
		try(conn) {
			final PreparedStatement sentencia = conn.prepareStatement("SELECT * FROM productos WHERE id_categoria = ?");
			
			try(sentencia) {
				sentencia.setInt(1, idCategoria);
				sentencia.execute();
				
				ResultSet filasRegistros = sentencia.getResultSet();

				while(filasRegistros.next()) {
					Integer id = filasRegistros.getInt("id");
					String nombre = filasRegistros.getString("nombre");
					String descripcion = filasRegistros.getString("descripcion");
					Integer cantidad = filasRegistros.getInt("cantidad");
					
					registros.add(new Productos(id, nombre, descripcion, cantidad));
				}
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return registros;
	}
	
	public int eliminar(Integer id) {
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
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return updateCount;
	}

	
	public void modificar(String nombre, String descripcion, Integer cantidad, Integer id) {
		// Stablishing this as final, and then using it in the try sentence, work as the "using" sentence in c#
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
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} 
		
	}
	
	

}
