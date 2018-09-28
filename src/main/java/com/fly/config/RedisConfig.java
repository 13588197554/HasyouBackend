package com.fly.config;

import com.fly.util.Arr;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Properties;

/**
 * @author david
 * @date 16/08/18 19:13
 */
@Configuration
public class RedisConfig {

    private static Properties prop = SystemConfig.global;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(Arr.getString(prop, "REDIS_HOST"));
        factory.setPassword(Arr.getString(prop, "REDIS_PASSWORD"));
        factory.setPort(Arr.getInteger(prop, "REDIS_PORT"));
        factory.setUsePool(true);
        return factory;
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate() {
        RedisTemplate<String, String> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory());
        return template;
    }

}
