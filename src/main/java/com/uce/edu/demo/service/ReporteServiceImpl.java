package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IDetalleVentaRepository;
import com.uce.edu.demo.repository.modelo.DetalleVenta;
import com.uce.edu.demo.repository.modelo.Reporte;

@Service
public class ReporteServiceImpl implements IReporteService {

	@Autowired
	private IDetalleVentaRepository iDetalleVentaRepository;


	@Override
	@Transactional(value = TxType.REQUIRED)
	public List<Reporte> realizarReporte(LocalDateTime fecha, String categoria, Integer cantidad) {
		// TODO Auto-generated method stub

		List<DetalleVenta> listaDetalles = new ArrayList<>();

		listaDetalles = this.iDetalleVentaRepository.buscaPorFecha(fecha);

		List<Reporte> reporte = new ArrayList<>();
		listaDetalles.stream()
				.filter(d -> d.getCantidad() >= cantidad & d.getProducto().getCategoria().equals(categoria))
				.forEach(d -> reporte.add(new Reporte(d.getProducto().getCodigoBarras(), d.getProducto().getNombre(),
						d.getCantidad(),d.getPrecioUnitario(), d.getSubtotal())));

		return reporte;

	}

}
