package com.tw.codesnippet.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "spring.datasource")
@Data
public class DataSourceProperties {

    private String driverClassName;

    private String url;

    private String username;

    private String password;
}
