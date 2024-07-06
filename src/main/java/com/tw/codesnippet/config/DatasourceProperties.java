package com.tw.codesnippet.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.datasource")
@Data
public class DatasourceProperties {

    private String driverClassName;

    private String url;

    private String username;

    private String password;
}
