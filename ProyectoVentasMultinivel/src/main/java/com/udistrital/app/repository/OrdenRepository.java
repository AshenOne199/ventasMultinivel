package com.udistrital.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.udistrital.app.entity.Orden;
import com.udistrital.app.entity.OrdenId;

public interface OrdenRepository extends JpaRepository<Orden, OrdenId> {

	/*
	@Transactional
	@Modifying
	@Query("update Orden o set o.estado = ?1 where o.id = ?2")
	void updateestadoById(String iEstado, OrdenId id);

	@Transactional
	@Modifying
	@Query("update Orden o set o.calificacion = ?1 where o.id = ?2")
	void updateCalificacion(Boolean calificacion, OrdenId id);

	List<Orden> findByid_idOrdenAndEstado(Integer idOrden, String estado);
	*/

}
