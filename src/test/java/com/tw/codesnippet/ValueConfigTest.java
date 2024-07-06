package com.tw.codesnippet;

import com.tw.codesnippet.config.ValueConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ValueConfigTest {

    @Test
    public void test_get_value_from_properties() {
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ValueConfig.class);
        final Object person = applicationContext.getBean("person");
        System.out.println(person);
    }
}
