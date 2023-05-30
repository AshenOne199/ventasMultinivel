package com.udistrital.app.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.jdbc.datasource.AbstractDataSource;

public class DynamicDataSource extends AbstractDataSource {
	
    private String username;
    private String password;
    
    private String url="jdbc:oracle:thin:@localhost:1521/dbmultinivel";

    public void setCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}

