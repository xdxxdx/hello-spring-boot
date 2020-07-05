package com.xdx.hello.spring.boot.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xdx.hello.spring.boot.entity.TAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@Component
public class JedisUtil {
    @Autowired
    private JedisPool jedisPool;
    @Autowired
    private JedisPoolConfig jedisPoolConfig;



    public void setValue(String k,Object obj) throws JsonProcessingException {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.set( k, JSON.toJSONString(obj, SerializerFeature.WriteMapNullValue  ) );
        }
    }

    public  String getValue(String k)  {
        try (Jedis jedis = jedisPool.getResource()) {
            String str= jedis.get(k);
            return str;
        }
    }
}
