package com.uce.edu.demo.service;

import java.time.LocalDateTime;

import com.uce.edu.demo.repository.modelo.Producto;

public interface IGestorService {
	public void ingresarProductos(Producto producto, Integer stock);
	public void realizarVenta(String codigoDeBarras, Integer cantidad, String cedulaCliente, String numeroDeVenta);
	public void reporteVentas(LocalDateTime fechaVenta, String categoriaProducto, Integer cantidad);
}
