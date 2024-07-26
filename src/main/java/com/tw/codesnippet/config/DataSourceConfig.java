package com.tw.codesnippet.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.tw.codesnippet.property.DataSourceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(value = {DataSourceProperties.class})
public class DataSourceConfig {

    @Autowired
    DataSourceProperties datasourceProperties;

    public DataSourceProperties getDatasourceProperties() {
        return datasourceProperties;
    }

    @Bean
    public DataSource devDatasource() throws Exception {
        final ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(datasourceProperties.getDriverClassName());
        dataSource.setJdbcUrl("");
        dataSource.setUser(datasourceProperties.getUsername());
        dataSource.setPassword(datasourceProperties.getPassword());
        return dataSource;
    }

    @Profile("test")
    @Bean
    public DataSource testDatasource() throws Exception {
        final ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(datasourceProperties.getDriverClassName());
        dataSource.setJdbcUrl("");
        dataSource.setUser(datasourceProperties.getUsername());
        dataSource.setPassword(datasourceProperties.getPassword());
        return dataSource;
    }
}
