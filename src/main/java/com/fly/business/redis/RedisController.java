package com.fly.business.redis;

import com.fly.pojo.vo.Result;
import com.fly.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author david
 * @date 03/08/18 19:48
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private RedisUtil redis;

    @GetMapping("/lrange")
    public Result lrange(Result result, @RequestParam("q") String key) {
        List<String> proxys = redis.lrange(key, 0, -1);
        result.ok(proxys);
        return result;
    }

    @GetMapping("/hgetall/{key}")
    public Result hgetAll(Result result, @PathVariable String key, @RequestParam("f") String field) {
        if (StringUtils.isNotBlank(field)) {
            String s = redis.hget(key, field);
            result.ok(s);
        } else {
            Map<String, String> map = redis.hgetAll(key);
            result.ok(map);
        }
        return result;
    }

    @GetMapping("/get/{key}")
    public Result get(Result result, @PathVariable String key) {
        String s = redis.get(key);
        result.ok(s);
        return result;
    }


    @GetMapping("/del/{key}")
    public Result del(Result result, @PathVariable String key) {
        Boolean del = redis.del(key);
        result.ok(del);
        return result;
    }

    @GetMapping("/keys")
    public Result keys(Result result) {
        Set<String> keys = redis.keys("*");
        Result ok = result.ok(keys);
        return result;
    }

    @PostMapping("/rpush/{key}")
    public Result rpush(Result result,
                        @PathVariable("key") String key,
                        @RequestParam("values") String[] value) {
        Long rpush = redis.rpush(key, value);
        return result.ok(rpush);
    }

}
