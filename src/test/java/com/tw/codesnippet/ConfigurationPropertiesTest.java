package com.tw.codesnippet;

import com.tw.codesnippet.config.UserConfig;
import com.tw.codesnippet.po.Person;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationPropertiesTest {

    @Test
    public void test_configuration_properties() {
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(UserConfig.class);
        final Person person = applicationContext.getBean(Person.class);
        System.out.println(person);
    }
}
