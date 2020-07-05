package com.xdx.hello.spring.boot.common.config;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

@Configuration
public class JedisConfig {
    @Bean
    @ConfigurationProperties("spring.redis.jedis.pool")
    public redis.clients.jedis.JedisPoolConfig jedisPoolConfig() {
        return new redis.clients.jedis.JedisPoolConfig();
    }

    @Bean(destroyMethod = "close")
    public JedisPool jedisPool(@Value("${spring.redis.host}") String host, @Value("${spring.redis.port}") int port, @Value("${spring.redis.password}") String password) {
        return new JedisPool(jedisPoolConfig(),  host,  port, 2000, password);
    }
}
