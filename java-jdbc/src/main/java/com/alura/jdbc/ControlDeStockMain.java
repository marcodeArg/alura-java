package com.alura.jdbc;

import javax.swing.JFrame;

import com.alura.jdbc.view.VentanaControlStock;

public class ControlDeStockMain {
	
	public static void main(String[] args) {
		VentanaControlStock produtoCategoriaFrame = new VentanaControlStock();
		produtoCategoriaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
