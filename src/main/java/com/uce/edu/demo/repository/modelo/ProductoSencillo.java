package com.uce.edu.demo.repository.modelo;

public class ProductoSencillo {

	private String nombre;

	private Integer stock;

	private String codigoBarras;
	
	
	public ProductoSencillo() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductoSencillo(String nombre, Integer stock, String codigoBarras) {
		super();
		this.nombre = nombre;
		this.stock = stock;
		this.codigoBarras = codigoBarras;
	}

	
	
	



	@Override
	public String toString() {
		return "ProductoSencillo [nombre=" + nombre + ", stock=" + stock + ", codigoBarras=" + codigoBarras + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}









}
