package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IVentaRepo;
import com.uce.edu.demo.repository.modelo.Venta;
@Service
public class VentaServiceImpl implements IVentaService {
	@Autowired
	private IVentaRepo ventaRepo;
	
	@Override
	public void insertarVenta(Venta venta) {
		// TODO Auto-generated method stub
		this.ventaRepo.insertarVenta(venta);
	}

	@Override
	public Venta buscarVenta(Integer id) {
		// TODO Auto-generated method stub
		return this.ventaRepo.buscarVenta(id);
	}

	@Override
	public void actualizarVenta(Venta venta) {
		// TODO Auto-generated method stub
		this.ventaRepo.actualizarVenta(venta);
	}

	@Override
	public List<Venta> buscarVentaPorFecha(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		return this.ventaRepo.buscarVentaPorFecha(fecha);
	}

	
}
