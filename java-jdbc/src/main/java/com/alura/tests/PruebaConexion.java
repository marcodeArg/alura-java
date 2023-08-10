package com.alura.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.alura.jdbc.factory.ConnectionFactory;

public class PruebaConexion {
	
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connFactory = new ConnectionFactory();
		Connection conn = connFactory.setConnection();
		
		conn.close();
	}
}
