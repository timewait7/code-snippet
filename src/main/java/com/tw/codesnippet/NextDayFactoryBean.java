package com.tw.codesnippet;

import org.springframework.beans.factory.FactoryBean;

import java.time.LocalDateTime;

public class NextDayFactoryBean implements FactoryBean<LocalDateTime> {

    @Override
    public LocalDateTime getObject() throws Exception {
        return LocalDateTime.now().plusDays(1);
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
