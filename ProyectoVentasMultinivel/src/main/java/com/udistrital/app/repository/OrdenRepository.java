package com.udistrital.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udistrital.app.entity.Orden;
import com.udistrital.app.entity.OrdenId;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdenRepository extends JpaRepository<Orden, OrdenId> {
    @Query(value = "SELECT * FROM Orden where K_IDORDEN = :id AND I_ESTADO = 'EN PROCESO'", nativeQuery = true)
    List<Orden> findAllById(Integer id);
}
