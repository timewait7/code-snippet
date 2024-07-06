package com.tw.codesnippet;

import com.tw.codesnippet.config.DatabaseConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class ProfileTest {

    @Test
    public void test_annotation_configuration_properties() {
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DatabaseConfig.class);
        final String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String name : beanNamesForType) {
            System.out.println(name);
        }
    }
}
