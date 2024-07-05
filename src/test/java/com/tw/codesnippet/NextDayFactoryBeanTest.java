package com.tw.codesnippet;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class NextDayFactoryBeanTest {

    @Test
    public void test_getObject() throws Exception {
        final NextDayFactoryBean nextDayFactoryBean = new NextDayFactoryBean();
        final LocalDateTime localDateTime = nextDayFactoryBean.getObject();
        System.out.println(localDateTime);
    }
}
