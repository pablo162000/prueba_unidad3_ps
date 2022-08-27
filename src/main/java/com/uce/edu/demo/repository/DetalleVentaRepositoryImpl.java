package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.DetalleVenta;

@Repository
@Transactional
public class DetalleVentaRepositoryImpl implements IDetalleVentaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<DetalleVenta> buscaPorFecha(LocalDateTime fechaVenta) {
		TypedQuery<DetalleVenta> myquery = this.entityManager.createQuery(
				"SELECT d FROM DetalleVenta d JOIN d.venta v WHERE v.fecha >= :fecha ", DetalleVenta.class);
		myquery.setParameter("fecha", fechaVenta);
		List<DetalleVenta> listDetalles = myquery.getResultList();
		for (DetalleVenta detalle : listDetalles) {
			detalle.getProducto().getNombre();
		}

		return listDetalles;
	}

}
