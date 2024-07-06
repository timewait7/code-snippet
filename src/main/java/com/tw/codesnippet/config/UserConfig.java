package com.tw.codesnippet.config;

import com.tw.codesnippet.dao.UserDao;
import com.tw.codesnippet.po.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("com.tw.codesnippet")
public class UserConfig {

    @Primary
    @Bean
    public UserDao userDao2() {
        return new UserDao(2);
    }

    @Bean
    public User user() {
        return new User();
    }
}
