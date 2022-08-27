package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Producto;

public interface IProductoService {
	public void insertarProducto(Producto producto);
	public Producto buscarProducto(Integer id);
	public void actualizarProducto(Producto producto);
	public Producto buscarProductoPorNombre(String nombre);
	public Producto buscarProductoPorCodigoBarra(String codigoDeBarra);
}
