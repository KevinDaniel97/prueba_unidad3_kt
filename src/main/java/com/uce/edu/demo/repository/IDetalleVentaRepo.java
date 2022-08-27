package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.DetalleVenta;

public interface IDetalleVentaRepo {
	public void insertarDetalle(DetalleVenta detalleVenta);
	public DetalleVenta buscarDetalle(Integer id);
	public void actualizarDetalle(DetalleVenta detalleVenta);
}
