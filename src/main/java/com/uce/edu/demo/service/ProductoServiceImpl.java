package com.uce.edu.demo.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoSencillo;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepository iProductoRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		String existe = "";

		Producto productoExistente = new Producto();
		try {
			productoExistente = this.iProductoRepository.buscar(producto.getCodigoBarras());
			existe = "si";

		} catch (Exception e) {
			this.iProductoRepository.insertar(producto);

		}

		if (existe.equals("si")) {
			Integer stock = productoExistente.getStock() + producto.getStock();
			productoExistente.setStock(stock);
			this.iProductoRepository.actualizar(productoExistente);
		}

	}

//	@Override
//	public void actualizar(Producto producto) {
//		// TODO Auto-generated method stub
//		this.iProductoRepository.actualizar(producto);
//	}
//
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto buscar(String codigoBarras) {
		return this.iProductoRepository.buscar(codigoBarras);
	}



	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)

	public ProductoSencillo buscarPorCodigodeBarrasStock(String codigoBarras) {
		// TODO Auto-generated method stub
		
		Producto producto = this.iProductoRepository.buscarPorCodigodeBarrasStock(codigoBarras);
		ProductoSencillo productoSencillo = new ProductoSencillo();

		productoSencillo.setCodigoBarras(producto.getCodigoBarras());
		productoSencillo.setNombre(producto.getNombre());
		productoSencillo.setStock(producto.getStock());
		
		return productoSencillo ;
	}
	
	

}
