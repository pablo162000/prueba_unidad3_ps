package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;

public class Reporte {
	
	private String codigoBarras;
	private String nombre;
	private Integer cantidad;
	private BigDecimal precioUnitario;
	private BigDecimal subtotal;
	
	
	public Reporte() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	public Reporte(String codigoBarras, String nombre, Integer cantidad, BigDecimal precioUnitario,
			BigDecimal subtotal) {
		super();
		this.codigoBarras = codigoBarras;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.subtotal = subtotal;
	}







	@Override
	public String toString() {
		return "Reporte [codigoBarras=" + codigoBarras + ", nombre=" + nombre + ", cantidad=" + cantidad
				+ ", precioUnitario=" + precioUnitario + ", subtotal=" + subtotal + "]";
	}
	
	
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public BigDecimal getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	
	
	
	
	
	
	
	
	
	

}
