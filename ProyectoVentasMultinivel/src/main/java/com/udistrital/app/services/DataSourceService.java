package com.udistrital.app.services;

import org.springframework.stereotype.Service;

import com.udistrital.app.config.DynamicDataSource;

@Service
public class DataSourceService {

    final private DynamicDataSource dynamicDataSource;

    public DataSourceService(DynamicDataSource dynamicDataSource) {
        this.dynamicDataSource = dynamicDataSource;
    }

    public void updateDataSourceCredentials(String username, String password) {
        dynamicDataSource.setCredentials(username, password);
    }
}