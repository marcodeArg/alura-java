package com.alura.jdbc.controller;

import java.util.ArrayList;
import java.util.List;

import com.alura.jdbc.dao.CategoriasDAO;
import com.alura.jdbc.factory.ConnectionFactory;
import com.alura.jdbc.modelo.Categorias;

public class ControladorCategoria {
	
	private CategoriasDAO dao;
	
	public ControladorCategoria() {
		dao = new CategoriasDAO(new ConnectionFactory().setConnection());
	}
	
	public List<Categorias> listar() {
		return dao.listar();
	}
	
	public List<Categorias> cargarReporte() {
		return this.dao.listarConProductos();
	}
}
