package com.alura.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PruebaConexion {
	
	public static void main(String[] args) throws SQLException {
		
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/control_de_stock", "postgres", "43451105Abc");
		
		
		conn.close();
		System.out.println("ASSA");
	}
}
