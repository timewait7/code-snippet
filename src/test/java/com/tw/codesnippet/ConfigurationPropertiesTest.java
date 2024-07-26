package com.tw.codesnippet;

import com.tw.codesnippet.config.DataSourceConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

public class ConfigurationPropertiesTest {

    @Test
    public void test_configuration_properties() {
        final ConfigurableApplicationContext context = SpringApplication.run(DataSourceConfig.class);
        // final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DataSourceConfig.class);
        final Map<String, DataSourceConfig> beansOfType = context.getBeansOfType(DataSourceConfig.class);
        for (DataSourceConfig config : beansOfType.values()) {
            System.out.println(config.getDatasourceProperties());
        }
    }
}
