package com.fly.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author david
 * @date 16/08/18 20:06
 */
@Component
@Scope("prototype")
public class RedisUtil {

    @Autowired
    private StringRedisTemplate redis;

    public void set(String key, String value) {
        redis.opsForValue().set(key, value);
    }

    public String get(String key) {
        return redis.opsForValue().get(key);
    }

    public Long rpush(String key, String...value) {
        return redis.opsForList().rightPushAll(key, value);
    }

    public Long rpush(String key, String value) {
        Long count = redis.opsForList().rightPush(key, value);
        return count;
    }

    public Long lpush(String key, String...value) {
        return redis.opsForList().leftPushAll(key, value);
    }

    public Long lpush(String key, String value) {
        Long count = redis.opsForList().leftPush(key, value);
        return count;
    }

    public String lpop(String key) {
        return redis.opsForList().leftPop(key);
    }

    public String rpop(String key) {
        return redis.opsForList().rightPop(key);
    }

    public List<String> lrange(String key, Integer start, Integer end) {
        return redis.opsForList().range(key, start, end);
    }

    public Long llen(String key) {
        return redis.opsForList().size(key);
    }

    public Long size(String key) {
        return redis.opsForList().size(key);
    }

    public void hset(String key, String field, String value) {
        redis.opsForHash().put(key, field, value);
    }

    public String hget(String key, String field) {
        return (String) redis.opsForHash().get(key, field);
    }

    public Map<String, String> hgetAll(String key) {
        HashOperations<String, String, String> ops = redis.opsForHash();
        return ops.entries(key);
    }

    public Set<String> keys(String pattern) {
        return redis.keys(pattern);
    }

    public Long ttl(String key) {
        return redis.getExpire(key);
    }

    public Boolean del(String key) {
        return redis.delete(key);
    }

    public Long hdel(String key, String field) {
        HashOperations<String, String, String> op = redis.opsForHash();
        return op.delete(key, field);
    }

    public Boolean exists(String...key) {
        for (String k : key) {
            if (!redis.hasKey(k)) {
                return false;
            }
        }
        return true;
    }

    public Boolean hexists(String key, String...fields) {
        for (String field : fields) {
            if (!redis.opsForHash().hasKey(key, field)) {
                return false;
            }
        }
        return true;
    }
}
