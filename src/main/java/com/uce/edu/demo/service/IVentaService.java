package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.ProductoSeleccionado;

public interface IVentaService {
	
	public void realizarVenta(List<ProductoSeleccionado> listaProductos, String cedula, String numeroVenta);

}
