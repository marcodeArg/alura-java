package com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

import com.alura.jdbc.factory.ConnectionFactory;
import com.alura.jdbc.view.VentanaControlStock;

public class ControlDeStockMain {
	
	public static void main(String[] args) {
		VentanaControlStock produtoCategoriaFrame = new VentanaControlStock();
		produtoCategoriaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
}
