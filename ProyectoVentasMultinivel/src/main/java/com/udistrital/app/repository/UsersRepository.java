package com.udistrital.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udistrital.app.entity.view.VistaUsers;

public interface UsersRepository extends JpaRepository<VistaUsers, String> {

	Optional<VistaUsers> findByUsernameAndPassword(String username, String password);

}
