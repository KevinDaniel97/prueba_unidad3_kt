package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.DetalleVenta;
@Repository
@Transactional
public class DetalleVentaRepoImpl implements IDetalleVentaRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarDetalle(DetalleVenta detalleVenta) {
		// TODO Auto-generated method stub
		this.entityManager.persist(detalleVenta);
	}

	@Override
	public DetalleVenta buscarDetalle(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(DetalleVenta.class, id);
	}

	@Override
	public void actualizarDetalle(DetalleVenta detalleVenta) {
		// TODO Auto-generated method stub
		this.entityManager.merge(detalleVenta);
	}

}