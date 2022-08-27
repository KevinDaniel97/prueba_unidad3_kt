package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IDetalleVentaRepo;
import com.uce.edu.demo.repository.modelo.DetalleVenta;

@Service
public class DetalleVentaServiceImpl implements IDetalleVentaService {

	@Autowired
	private IDetalleVentaRepo detalleVentaRepo;
	
	@Override
	public void insertarDetalleVenta(DetalleVenta detalleVenta) {
		// TODO Auto-generated method stub
		this.detalleVentaRepo.insertarDetalle(detalleVenta);
	}

	@Override
	public DetalleVenta buscarDetalleVenta(Integer id) {
		// TODO Auto-generated method stub
		return this.detalleVentaRepo.buscarDetalle(id);
	}

	@Override
	public void actualizarDetalleVenta(DetalleVenta detalleVenta) {
		// TODO Auto-generated method stub
		this.detalleVentaRepo.actualizarDetalle(detalleVenta);
	}
}