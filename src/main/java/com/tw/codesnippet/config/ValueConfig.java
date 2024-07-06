package com.tw.codesnippet.config;

import com.tw.codesnippet.po.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = "classpath:/person.properties")
@Configuration
public class ValueConfig {

    @Bean
    public Person person() {
        return new Person();
    }
}
