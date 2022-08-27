package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Producto;

@Repository
@Transactional
public class ProductoRepoImpl implements IProductoRepo {

	private static final Logger log = Logger.getLogger(ProductoRepoImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarProducto(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(producto);
	}

	@Override
	public Producto buscarProducto(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Producto.class, id);
	}

	@Override
	public void actualizarProducto(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);
	}


	@Override
	public Producto buscarProductoPorNombre(String nombre) {
		try {
		
			TypedQuery<Producto> myQuery = this.entityManager.createQuery("SELECT c FROM Producto c WHERE c.nombre =:nombre", Producto.class);
			myQuery.setParameter("nombre", nombre);
			return myQuery.getSingleResult();
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("No existe el producto");
		}
		return null;
	}

	@Override
	public Producto buscarProductoPorCodigoBarra(String codigoBarra) {		
		CriteriaBuilder myBuilder= this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Producto> myQuery = myBuilder.createQuery(Producto.class);
		Root<Producto> prod1=myQuery.from(Producto.class);
		Predicate p1= myBuilder.equal(prod1.get("codigoBarra"), codigoBarra);
		CriteriaQuery<Producto> myQueryCompleto=myQuery.select(prod1).where(p1);			
		TypedQuery<Producto> myQueryFinal=this.entityManager.createQuery(myQueryCompleto);
		return myQueryFinal.getSingleResult();
		
//		TypedQuery<Producto> myQuery = this.entityManager.createQuery("SELECT c FROM Producto c WHERE c.codigoDeBarras =:codigo", Producto.class);
//		myQuery.setParameter("codigo", codigoDeBarra);
//		return myQuery.getSingleResult();
	} 

}