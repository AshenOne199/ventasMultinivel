package com.udistrital.app.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import oracle.jdbc.driver.OracleConnection;

@Service
public class DatabaseAuthService {

	@Value("${database.username}")
	private String username;

	@Value("${database.password}")
	private String password;

	public Map<String, String> testConnectionAndUpdate(String newUsername, String newPassword) {

		Map<String, String> message = new HashMap<>();
		String finalMessage = null;

		try {
			String dbURL = "jdbc:oracle:thin:@localhost:1521/";
			String username = newUsername;
			String password = newPassword;
			Connection conn = DriverManager.getConnection(dbURL, username, password);
			conn.close();

		} catch (SQLException e) {
			int errorCode = e.getErrorCode();
			e.printStackTrace();
			if (errorCode == 1017) {
				finalMessage = "Failed, wrong password or user, ORA: " + String.valueOf(errorCode);
				message.put("message", finalMessage);
				return message;

			} else if (errorCode == 28000) {
				finalMessage = "Failed, the account is locked, ORA: " + String.valueOf(errorCode);
				message.put("message", finalMessage);
				return message;
			} else if (errorCode == 28001) {
				finalMessage = "Failed, expired password, ORA: " + String.valueOf(errorCode);
				message.put("message", finalMessage);
				return message;
			} else {
				finalMessage = "Failed, ORA: " + String.valueOf(errorCode);
				message.put("message", finalMessage);
				return message;
			}
		}

		try {
			updateDatasource(newUsername, newPassword);
			finalMessage = "Success";
			message.put("message", finalMessage);
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

		} catch (FileNotFoundException e) {

			e.printStackTrace();
			finalMessage = "Failed, file exception";
			message.put("message", finalMessage);
			return message;
		} catch (IOException e) {

			e.printStackTrace();
			finalMessage = "Failed, file exception";
			message.put("message", finalMessage);
			return message;
		}
	}

	public void updateDatasource(String newUsername, String newPassword) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream("src/main/resources/application.properties"));
		properties.setProperty("database.username", newUsername);
		properties.setProperty("database.password", newPassword);
		properties.store(new FileOutputStream("src/main/resources/application.properties"), null);
		org.springframework.boot.devtools.restart.Restarter.getInstance().restart();
	}

	public Map<String, String> updateOCIPassword(String username, String oldPassword, String newPassword) {

		Map<String, String> message = new HashMap<>();
		String finalMessage;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Properties props = new Properties();

			String dbURL = "jdbc:oracle:oci:@localhost:1521/";
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
			return message;
		} catch (ClassNotFoundException e) {
			finalMessage = "OCI Driver configuration error";
			message.put("message", finalMessage);
			return message;
		}

	}
}