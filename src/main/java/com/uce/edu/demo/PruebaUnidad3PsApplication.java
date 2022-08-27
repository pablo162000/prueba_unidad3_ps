package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoSeleccionado;
import com.uce.edu.demo.repository.modelo.ProductoSencillo;
import com.uce.edu.demo.repository.modelo.Reporte;
import com.uce.edu.demo.service.IProductoService;
import com.uce.edu.demo.service.IReporteService;
import com.uce.edu.demo.service.IVentaService;

import net.bytebuddy.asm.Advice.This;

@SpringBootApplication
public class PruebaUnidad3PsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad3PsApplication.class, args);
	}

	@Autowired
	private IReporteService iReporteService;
	@Autowired
	private IProductoService iProductoService;

	@Autowired
	private IVentaService iVentaService;
	private static Logger LOG = Logger.getLogger(PruebaUnidad3PsApplication.class);

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Producto producto = new Producto();

		producto.setCategoria("Alimento");
		producto.setCodigoBarras("8488");
		producto.setPrecio(new BigDecimal(5));
		producto.setNombre("queso");
		producto.setStock(400);

		// 1 insertar producto
		iProductoService.insertar(producto);

		// buscar por codigo de barras
		LOG.info(iProductoService.buscar(producto.getCodigoBarras()));

		// 2 venta
		ProductoSeleccionado productoSeleccionado = new ProductoSeleccionado();

		productoSeleccionado.setCantidad(100);
		productoSeleccionado.setCodigoBarras("8488");

		List<ProductoSeleccionado> listProductoSeleccionados = new ArrayList<>();
		listProductoSeleccionados.add(productoSeleccionado);

		this.iVentaService.realizarVenta(listProductoSeleccionados, "1818256", "1");

		// 3. Consultar Stock

		 LOG.info(this.iProductoService.buscarPorCodigodeBarrasStock("8488"));

		 
		 //Reporte

		List<Reporte> listaDeReporte =  this.iReporteService.realizarReporte(LocalDateTime.of(2022, 8, 26, 1, 0), "Alimento", 6);
		
		
		for(Reporte reporte : listaDeReporte) {
			LOG.info("Reporte : "+reporte);
		}
		
		
		
		
	}

}
