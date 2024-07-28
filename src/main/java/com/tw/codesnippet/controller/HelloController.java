package com.tw.codesnippet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/hello")
    public String sayHello() {
        final Boolean flag = redisTemplate.opsForValue().setIfAbsent("hello", "world");
        return flag ? redisTemplate.opsForValue().get("hello") : "";
    }
}
