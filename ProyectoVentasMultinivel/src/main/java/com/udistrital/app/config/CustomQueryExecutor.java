package com.udistrital.app.config;

import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;

@Component
public class CustomQueryExecutor {

  @PersistenceUnit
  private EntityManagerFactory entityManagerFactory;

  public void executeClientCreation(String username, String password) {
	String createUserDdlStatement = "CREATE USER "+username+" IDENTIFIED BY "+password;
	String grantUserRoleDclStatement = "GRANT R_CLIENTE TO "+username;
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    entityManager.createNativeQuery(createUserDdlStatement).executeUpdate();
    entityManager.getTransaction().commit();
    entityManager.getTransaction().begin();
    entityManager.createNativeQuery(grantUserRoleDclStatement).executeUpdate();
    entityManager.getTransaction().commit();    
    entityManager.close();
  }
  
  public void executeRepresentanteCreation(String username, String password) {
		String createUserDdlStatement = "CREATE USER "+username+" IDENTIFIED BY "+password;
		String grantUserRoleDclStatement = "GRANT R_REPRESENTANTE TO "+username;
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    entityManager.getTransaction().begin();
	    entityManager.createNativeQuery(createUserDdlStatement).executeUpdate();
	    entityManager.getTransaction().commit();
	    entityManager.getTransaction().begin();
	    entityManager.createNativeQuery(grantUserRoleDclStatement).executeUpdate();
	    entityManager.getTransaction().commit();    
	    entityManager.close();
	}
  
  
}