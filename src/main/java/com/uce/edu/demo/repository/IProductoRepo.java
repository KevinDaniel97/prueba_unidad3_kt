package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Producto;

public interface IProductoRepo {
	public void insertarProducto(Producto producto);
	public Producto buscarProducto(Integer id);
	public void actualizarProducto(Producto producto);
	public Producto buscarProductoPorNombre(String nombre);
	public Producto buscarProductoPorCodigoBarra(String codigoDeBarra);
	    
}
