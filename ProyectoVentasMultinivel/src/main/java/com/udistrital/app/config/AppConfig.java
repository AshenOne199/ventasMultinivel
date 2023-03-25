package com.udistrital.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521/dbmultinivel");
        dataSource.setUsername("U_ADMIN");
        dataSource.setPassword("pass");
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        return dataSource;
    }

    @Bean
    JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
