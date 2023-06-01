package com.udistrital.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udistrital.app.entity.Orden;
import com.udistrital.app.entity.OrdenId;

public interface OrdenRepository extends JpaRepository<Orden, OrdenId> {


}
