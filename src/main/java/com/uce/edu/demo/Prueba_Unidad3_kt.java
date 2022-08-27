package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.Venta;
import com.uce.edu.demo.service.IGestorService;
import com.uce.edu.demo.service.IProductoService;
import com.uce.edu.demo.service.IVentaService;


@SpringBootApplication
public class Prueba_Unidad3_kt implements CommandLineRunner {

	private static Logger log = Logger.getLogger(Prueba_Unidad3_kt.class);
	
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private IVentaService ventaService;
	
	@Autowired
	private IGestorService gestorService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Prueba_Unidad3_kt.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Producto producto1= new Producto();
		producto1.setCategoria("carnes");
		producto1.setNombre("res");
		producto1.setPrecio(new BigDecimal("2.10"));
		producto1.setStock(25);
		producto1.setCodigoBarras("001");
		this.productoService.insertarProducto(producto1);

		Producto producto2= new Producto();
		producto2.setCategoria("dulces");
		producto2.setNombre("chocolate");
		producto2.setPrecio(new BigDecimal("1.50"));
		producto2.setStock(200);
		producto2.setCodigoBarras("002");
		this.productoService.insertarProducto(producto2);

		List<String> codigosLista = new ArrayList<>();
		codigosLista.add("001");
		codigosLista.add("002");
		
		
		//this.gestorService.realizarVenta("001", 2, "100", "10");

	

	}

}
