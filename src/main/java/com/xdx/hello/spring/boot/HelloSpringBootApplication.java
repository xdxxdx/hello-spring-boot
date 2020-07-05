package com.xdx.hello.spring.boot;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.github.pagehelper.PageHelper;
import com.xdx.hello.spring.boot.common.dto.PageResponse;
import com.xdx.hello.spring.boot.dao.TAdminMapper;
import com.xdx.hello.spring.boot.entity.TAdmin;
import com.xdx.hello.spring.boot.redis.JedisUtil;
import com.xdx.hello.spring.boot.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@SpringBootApplication
@Slf4j
@MapperScan({"com.xdx.hello.spring.boot.dao"})
public class HelloSpringBootApplication implements CommandLineRunner{
    @Autowired
    private JedisUtil jedisUtil;

    @RequestMapping("/")
    public String helloSpringBoot(){
        return "hello SpringBoot";
    }
    public static void main(String[] args) {
        SpringApplication.run(HelloSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        TAdmin admin=new TAdmin();
            admin.setUserName( "谢东祥" );
            admin.setPwd( "dddddd" );
        jedisUtil.setValue( "xdx",admin );
       String jsonStr= jedisUtil.getValue( "xdx" );
       TAdmin admin1= (TAdmin)JSON.parseObject(jsonStr, TAdmin.class);
        log.info( String.valueOf( admin1 ) );

//        try (Jedis jedis = jedisPool.getResource()) {
//            TAdmin admin=new TAdmin();
//            admin.setUserName( "谢东祥" );
//            admin.setPwd( "dddddd" );
//            String jsonObject=new ObjectMapper(  ).writeValueAsString(admin);
//          jedis.set("xxx",jsonObject);
//          log.info(jedis.get("xxx"));
//        }
    }

}
