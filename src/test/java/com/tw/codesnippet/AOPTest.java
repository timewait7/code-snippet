package com.tw.codesnippet;

import com.tw.codesnippet.config.AOPConfig;
import com.tw.codesnippet.utils.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPTest {

    @Test
    public void test_before_advice() {
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AOPConfig.class);
        final Calculator calculator = applicationContext.getBean(Calculator.class);
        calculator.div(1, 1);
    }

    @Test
    public void test_after_returning_advice() {
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AOPConfig.class);
        final Calculator calculator = applicationContext.getBean(Calculator.class);
        calculator.div(1, 1);
    }

    @Test
    public void test_after_throwing_advice() {
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AOPConfig.class);
        final Calculator calculator = applicationContext.getBean(Calculator.class);
        calculator.div(1, 0);
    }
}
