package com.tw.codesnippet.config;

import com.tw.codesnippet.aspect.LogAspect;
import com.tw.codesnippet.utils.Calculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AOPConfig {

    @Bean
    public Calculator calculator() {
        return new Calculator();
    }

    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }
}
