package com.udistrital.app.config;

import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import jakarta.transaction.Transactional;

@Component
public class CustomQueryExecutor {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Transactional
	public void executeClientCreation(String username, String password) {
		String tablespaceName = "";
		String tmpTableSpaceName = "";
		String quota = "";
		String createUserDdlStatement = "CREATE USER " + username + " IDENTIFIED BY " + password + " DEFAULT TABLESPACE "
				+ tablespaceName + " TEMPORARY TABLESPACE " + tmpTableSpaceName + " QUOTA "+ quota + " ON " + tablespaceName
				+ " PASSWORD EXPIRE";
		String grantUserRoleDclStatement = "GRANT R_CLIENTE TO " + username;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.createNativeQuery(createUserDdlStatement).executeUpdate();
		entityManager.getTransaction().commit();
		entityManager.getTransaction().begin();
		entityManager.createNativeQuery(grantUserRoleDclStatement).executeUpdate();
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Transactional
	public void executeRepresentanteCreation(String username, String password) {
		String tablespaceName = "MULTINIVELDEF";
		String tmpTableSpaceName = "MULTINIVELTMP";
		String quota = "2M";
		String createUserDdlStatement = "CREATE USER " + username + " IDENTIFIED BY " + password + " DEFAULT TABLESPACE "
				+ tablespaceName + " TEMPORARY TABLESPACE " + tmpTableSpaceName + " QUOTA "+ quota + " ON " + tablespaceName
				+ " PASSWORD EXPIRE";
		String grantUserRoleDclStatement = "GRANT R_REPRESENTANTE TO " + username;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.createNativeQuery(createUserDdlStatement).executeUpdate();
		entityManager.getTransaction().commit();
		entityManager.getTransaction().begin();
		entityManager.createNativeQuery(grantUserRoleDclStatement).executeUpdate();
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Transactional
	public void executeRepresentanteMasterCreation(String username, String password) {
		String tablespaceName = "MULTINIVELDEF";
		String tmpTableSpaceName = "MULTINIVELTMP";
		String quota = "2M";
		String createUserDdlStatement = "CREATE USER " + username + " IDENTIFIED BY " + password + " DEFAULT TABLESPACE "
				+ tablespaceName + " TEMPORARY TABLESPACE " + tmpTableSpaceName + " QUOTA "+ quota +" ON " + tablespaceName
				+ " PASSWORD EXPIRE";

		String grantUserRoleDclStatement = "GRANT R_MASTER TO " + username;
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
