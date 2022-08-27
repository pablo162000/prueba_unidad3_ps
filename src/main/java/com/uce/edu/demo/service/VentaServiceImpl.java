package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.IVentaRepository;
import com.uce.edu.demo.repository.modelo.DetalleVenta;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoSeleccionado;
import com.uce.edu.demo.repository.modelo.Venta;

@Service
public class VentaServiceImpl implements IVentaService {

	@Autowired
	private IProductoRepository iProductoRepository;

	@Autowired
	private IVentaRepository iVentaRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarVenta(List<ProductoSeleccionado> listaProductosSeleccionados, String cedula,
			String numeroVenta) {
		// TODO Auto-generated method stub
		Venta venta = new Venta();
		venta.setCedulaCliente(cedula);
		venta.setFecha(LocalDateTime.now());
		venta.setNumero(numeroVenta);

		List<DetalleVenta> listaDetalles = new ArrayList<>();
		BigDecimal totalVenta = BigDecimal.ZERO;
		for (ProductoSeleccionado productoSeleccionado : listaProductosSeleccionados) {
			Producto producto = this.iProductoRepository.buscar(productoSeleccionado.getCodigoBarras());

			if (producto.getStock() == 0) {
				throw new RuntimeException();
			}
			if (productoSeleccionado.getCantidad() >= producto.getStock()) {
				productoSeleccionado.setCantidad(producto.getStock());

			}

			DetalleVenta detalleVenta = new DetalleVenta();
			detalleVenta.setCantidad(productoSeleccionado.getCantidad());
			detalleVenta.setPrecioUnitario(producto.getPrecio());
			detalleVenta.setProducto(producto);
			detalleVenta.setSubtotal(producto.getPrecio().multiply(new BigDecimal(productoSeleccionado.getCantidad())));
			detalleVenta.setVenta(venta);
			listaDetalles.add(detalleVenta);
			totalVenta = totalVenta.add(detalleVenta.getSubtotal());

			producto.setStock(producto.getStock() - productoSeleccionado.getCantidad());
			this.iProductoRepository.actualizar(producto);
		}
		venta.setDetallesventa(listaDetalles);
		venta.setTotalVenta(totalVenta);

		this.iVentaRepository.insertar(venta);

	}

}
