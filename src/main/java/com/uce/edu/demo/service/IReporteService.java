package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Reporte;

public interface IReporteService {
	
	public List<Reporte> realizarReporte(LocalDateTime fecha, String categoria, Integer cantidad);
}
