package com.tw.codesnippet;

import com.tw.codesnippet.config.UserConfig;
import com.tw.codesnippet.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AwareTest {

    @Test
    public void test_aware_processor() {
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(UserConfig.class);
        final User user = applicationContext.getBean(User.class);
        System.out.println(user);
    }
}
