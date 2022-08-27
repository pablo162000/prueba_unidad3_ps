package com.uce.edu.demo.repository;

import java.time.LocalDateTime;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoSencillo;

public interface IProductoRepository {

	public void insertar(Producto producto);
	
	
	public Producto buscar(String codigoBarras);
	
	public void actualizar(Producto producto);
	
	
	
	public Producto buscarPorCodigodeBarrasStock(String codigoBarras);
	
	
}
