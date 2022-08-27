package com.uce.edu.demo.repository;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoSencillo;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(producto);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto buscar(String codigoBarras) {
		// TODO Auto-generated method stub
		TypedQuery<Producto> myquery = this.entityManager
				.createQuery("SELECT p FROM Producto p WHERE p.codigoBarras = :codigo", Producto.class);
		myquery.setParameter("codigo", codigoBarras);
		return myquery.getSingleResult();

	}

	@Override
	@Transactional(value= TxType.MANDATORY)
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);
	}



	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto buscarPorCodigodeBarrasStock(String codigoBarras) {
		// TODO Auto-generated method stub
		
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Producto>  myQuery = myBuilder.createQuery(Producto.class);
		
		Root<Producto> productoFrom = myQuery.from(Producto.class);
		
		Predicate p1 =myBuilder.equal(productoFrom.get("codigoBarras"), codigoBarras);
		
		CriteriaQuery<Producto> queryCompleto = myQuery.select(productoFrom).where(p1);
		TypedQuery<Producto> myqueryFinal = this.entityManager.createQuery(queryCompleto);
		return myqueryFinal.getSingleResult();
	}


	

}
