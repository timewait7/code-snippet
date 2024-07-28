package com.tw.codesnippet.fxnews;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactoryTest {

    @Test
    public void test_register_bean() {
        final ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        final FXNewsProvider djNewsProvider = (FXNewsProvider) applicationContext.getBean("djNewsProvider");
        djNewsProvider.getAndPersistNews();
    }
}
