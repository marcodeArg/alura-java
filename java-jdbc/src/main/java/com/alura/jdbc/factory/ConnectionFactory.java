package com.alura.jdbc.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection setConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:postgresql://localhost/control_de_stock", "postgres", "43451105Abc");
	}
 
}
