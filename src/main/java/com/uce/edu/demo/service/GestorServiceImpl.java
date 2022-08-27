package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.modelo.DetalleVenta;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.Venta;
@Service
public class GestorServiceImpl implements IGestorService {
	
	private static Logger log = Logger.getLogger(GestorServiceImpl.class);
	
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private IVentaService ventaService;
	
	@Autowired
	private IDetalleVentaService detalleVentaService;
	
	@Override
	@Transactional
	public void ingresarProductos(Producto producto, Integer stock) {
		Producto insertar = this.productoService.buscarProductoPorNombre(producto.getNombre());
		if (insertar == null) {
			producto.setStock(stock);
			this.productoService.insertarProducto(producto);
		} else {
			insertar.setStock(insertar.getStock() + stock);
			this.productoService.actualizarProducto(producto);
		}
	}

	@Override
	@Transactional
	public void realizarVenta(String codigoDeBarras, Integer cantidad, String cedulaCliente, String numeroVenta) {
	
		try {
			Producto venta = this.productoService.buscarProductoPorCodigoBarra(codigoDeBarras);
			if (venta == null) {
				throw new RuntimeException();
			} else {
				Venta v1 = new Venta();
				v1.setFecha(LocalDateTime.now());
				v1.setCedulaCliente(cedulaCliente);
				v1.setNumero(numeroVenta);
				v1.setTotalVenta(venta.getPrecio().multiply(new BigDecimal(cantidad)));
				
				DetalleVenta dv = new DetalleVenta();
				dv.setCantidad(cantidad);
				dv.setPrecioUnitario(venta.getPrecio());
				dv.setSubtotal(v1.getTotalVenta());
				dv.setVenta(v1);
				dv.setProducto(venta);
				
				v1.getDetalleVentas().add(dv);
				this.ventaService.insertarVenta(v1);
				this.detalleVentaService.insertarDetalleVenta(dv);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.error("No se pudo realisar la venta");
		}
		
	}

		@Override
		public void reporteVentas(LocalDateTime fechaVenta, String categoriaProducto, Integer cantidad) {
		// TODO Auto-generated method stub
			List<Venta> listaVentas = this.ventaService.buscarVentaPorFecha(fechaVenta);
			listaVentas.stream().forEach(v -> {
				log.info(v.getDetalleVentas());
			});
	}


}