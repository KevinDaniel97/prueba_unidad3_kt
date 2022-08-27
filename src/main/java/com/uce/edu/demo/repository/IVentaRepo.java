package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Venta;

public interface IVentaRepo {
	public void insertarVenta(Venta venta);
	public Venta buscarVenta(Integer id);
	public void actualizarVenta(Venta venta);	
	public List<Venta> buscarVentaPorFecha(LocalDateTime fecha);
}
