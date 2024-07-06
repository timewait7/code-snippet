package com.tw.codesnippet;

import com.tw.codesnippet.config.UserConfig;
import com.tw.codesnippet.service.UserSerivce;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class AutowiredTest {

    @Test
    public void test_autowired() {
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(UserConfig.class);
        final Map<String, UserSerivce> beansOfType = applicationContext.getBeansOfType(UserSerivce.class);
        System.out.println(beansOfType);
    }
}
