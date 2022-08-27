package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "venta")
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vent_id_seq")
	@SequenceGenerator(name = "vent_id_seq", sequenceName = "vent_id_seq", allocationSize = 1)
	@Column(name = "vent_id")
	private Integer id;

	@Column(name = "vent_numero")
	private String numero;

	@Column(name = "vent_fecha")
	private LocalDateTime fecha;

	@Column(name = "vent_cedula_cliente")
	private String cedulaCliente;

	@Column(name = "vent_total_venta")
	private BigDecimal totalVenta;

	@OneToMany(mappedBy = "venta", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DetalleVenta> detallesVenta;

	@Override
	public String toString() {
		return "Venta [id=" + id + ", numero=" + numero + ", fecha=" + fecha + ", cedulaCliente=" + cedulaCliente
				+ ", totalVenta=" + totalVenta + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public BigDecimal getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(BigDecimal totalVenta) {
		this.totalVenta = totalVenta;
	}

	public List<DetalleVenta> getDetallesventa() {
		return detallesVenta;
	}

	public void setDetallesventa(List<DetalleVenta> detallesventa) {
		this.detallesVenta = detallesventa;
	}

}
