package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.DetalleVenta;

public interface IDetalleVentaService {
	
	public void insertarDetalleVenta(DetalleVenta detalleVenta);
	public DetalleVenta buscarDetalleVenta(Integer id);
	public void actualizarDetalleVenta(DetalleVenta detalleVenta);
}
