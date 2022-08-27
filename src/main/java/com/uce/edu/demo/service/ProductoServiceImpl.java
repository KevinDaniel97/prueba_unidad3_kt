package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IProductoRepo;
import com.uce.edu.demo.repository.modelo.Producto;
@Service
public class ProductoServiceImpl implements IProductoService{
	@Autowired
	private IProductoRepo productoRepo;
	
	@Override
	public void insertarProducto(Producto producto) {
		// TODO Auto-generated method stub
		this.productoRepo.insertarProducto(producto);
	}

	@Override
	public Producto buscarProducto(Integer id) {
		// TODO Auto-generated method stub
		return this.productoRepo.buscarProducto(id);
	}

	@Override
	public void actualizarProducto(Producto producto) {
		// TODO Auto-generated method stub
		this.productoRepo.actualizarProducto(producto);
	}

	@Override
	public Producto buscarProductoPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.productoRepo.buscarProductoPorNombre(nombre);
	}

	@Override
	public Producto buscarProductoPorCodigoBarra(String codigoDeBarra) {
		// TODO Auto-generated method stub
		return this.productoRepo.buscarProductoPorCodigoBarra(codigoDeBarra);
	} 
	
}
