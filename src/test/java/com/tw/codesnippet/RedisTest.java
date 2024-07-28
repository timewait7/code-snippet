package com.tw.codesnippet;

import com.tw.codesnippet.config.RedisConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

public class RedisTest {

    @Test
    public void test_redis() {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(RedisConfig.class);
        final StringRedisTemplate redisTemplate = (StringRedisTemplate) applicationContext.getBean("redisTemplate");
        redisTemplate.opsForValue().increment("hello", 1);
    }
}
