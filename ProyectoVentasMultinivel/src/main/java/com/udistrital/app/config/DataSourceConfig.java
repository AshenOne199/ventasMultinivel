package com.udistrital.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

	@Bean
	DynamicDataSource dynamicDataSource() {
		return new DynamicDataSource();
	}
}