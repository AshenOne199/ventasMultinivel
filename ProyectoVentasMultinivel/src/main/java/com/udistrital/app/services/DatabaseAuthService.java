package com.udistrital.app.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import oracle.jdbc.driver.OracleConnection;

@Service
public class DatabaseAuthService {

	final private DataSourceService dataSourceService;

	public DatabaseAuthService(DataSourceService dataSourceService) {
		this.dataSourceService = dataSourceService;
	}

	public Map<String, String> testConnectionAndUpdate(String nombre, String apellido, String newPassword) {

		Map<String, String> message = new HashMap<>();
		String finalMessage = null;
		String username = "";
		List<String> roles = new ArrayList<>();

		try {
			String dbURL = "jdbc:oracle:thin:@localhost:1521/dbmultinivel";
			
			username = nombre.concat("_").concat(apellido);
			
			if(apellido.isBlank() || apellido.isEmpty()) {
				username = nombre;
			}else {
				username = nombre.concat("_").concat(apellido);
			}
			
			String password = newPassword;
			Connection conn = DriverManager.getConnection(dbURL, username, password);
			
			String query = "select granted_role from user_role_privs where granted_role NOT LIKE 'CONNECT' AND granted_role NOT LIKE 'DBA' AND granted_role NOT LIKE 'AQ_ADMINISTRATOR_ROLE' order by granted_role desc";
			
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			
			ResultSet resulset = preparedStatement.executeQuery();
			
			while(resulset.next()) {
				roles.add(resulset.getString("GRANTED_ROLE"));
			}
			
			
			conn.close();

		} catch (SQLException e) {
			int errorCode = e.getErrorCode();
			e.printStackTrace();
			if (errorCode == 1017) {
				finalMessage = "Failed, wrong password or user, ORA: " + String.valueOf(errorCode);
				message.put("message", finalMessage);
				message.put("codeError", String.valueOf(errorCode));
				
				
				return message;

			} else if (errorCode == 28000) {
				finalMessage = "Failed, the account is locked, ORA: " + String.valueOf(errorCode);
				message.put("message", finalMessage);
				message.put("codeError", String.valueOf(errorCode));
				
				return message;
			} else if (errorCode == 28001) {
				finalMessage = "Failed, expired password, ORA: " + String.valueOf(errorCode);
				message.put("message", finalMessage);
				message.put("codeError", String.valueOf(errorCode));
				
				return message;
			} else {
				finalMessage = "Failed, ORA: " + String.valueOf(errorCode);
				message.put("message", finalMessage);
				message.put("codeError", String.valueOf(errorCode));
				
				return message;
			}
		}

		try {

			updateDatasource(username, newPassword);

			finalMessage = "Success";
			message.put("message", finalMessage);
			
			if(roles.size()<=0) {
				message.put("role 0","no role granted");
			}
			
			for(int i=0; i<roles.size(); i++) {
				message.put("role "+String.valueOf(i),roles.get(i));
			}
			return message;
		} catch (DataAccessException e) {

			if (e.getCause() instanceof SQLException) {
				SQLException sqlEx = (SQLException) e.getCause();
				int errorCode = sqlEx.getErrorCode();
				e.printStackTrace();
				finalMessage = "Failed, ORA: " + String.valueOf(errorCode);
				message.put("message", finalMessage);
				return message;
			} else {
				e.printStackTrace();
				finalMessage = "Failed, unexpected DataAccess exception";
				message.put("message", finalMessage);
				return message;
			}

		}
	}
	
	public void logout() {
		updateDatasource("U_ADMIN", "pass");
	}

	public void updateDatasource(String newUsername, String newPassword) {
		dataSourceService.updateDataSourceCredentials(newUsername, newPassword);
	}

	public Map<String, String> updateOCIPassword(String username, String oldPassword, String newPassword) {

		Map<String, String> message = new HashMap<>();
		String finalMessage;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Properties props = new Properties();

			String dbURL = "jdbc:oracle:oci:@localhost:1521/dbmultinivel";
			props.put("user", username);
			props.put("password", oldPassword);

			props.put(OracleConnection.CONNECTION_PROPERTY_NEW_PASSWORD, newPassword);
			Connection conn = DriverManager.getConnection(dbURL, props);
			if (conn != null) {
				conn.close();
				finalMessage = "Password changed successfully!";
				message.put("message", finalMessage);
				return message;
			} else {
				finalMessage = "Unexpected error >:(";
				message.put("message", finalMessage);
				return message;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			int errorCode = e.getErrorCode();
			finalMessage = "Failed,ORA: " + String.valueOf(errorCode);
			message.put("message", finalMessage);
			message.put("codeError", String.valueOf(errorCode));
			return message;
		} catch (ClassNotFoundException e) {
			finalMessage = "OCI Driver configuration error";
			message.put("message", finalMessage);
			return message;
		}

	}
}