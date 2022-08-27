package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.modelo.Venta;

@Service
public interface IVentaService {
	public void insertarVenta(Venta venta);
	public Venta buscarVenta(Integer id);
	public void actualizarVenta(Venta venta);
	public List<Venta> buscarVentaPorFecha(LocalDateTime fecha);
}
