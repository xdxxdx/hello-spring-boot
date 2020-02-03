package com.xdx.hello.spring.boot;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.github.pagehelper.PageHelper;
import com.xdx.hello.spring.boot.common.dto.PageResponse;
import com.xdx.hello.spring.boot.dao.TAdminMapper;
import com.xdx.hello.spring.boot.entity.TAdmin;
import com.xdx.hello.spring.boot.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    private DataSource dataSource;
    @Autowired
    private TAdminMapper adminMapper;
    @Autowired
    private AdminService adminService;
    @Value("${xdx}")
    private String xdx;
    @RequestMapping("/")
    public String helloSpringBoot(){
        return "hello SpringBoot";
    }
    public static void main(String[] args) {
        SpringApplication.run(HelloSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info(" xdx is "+xdx);
        for (String arg : args) {
            log.info(arg.toString());
        }
        showConnection();
    }
    private void showConnection() throws SQLException {
        log.info("数据源："+dataSource.toString());
        Connection conn=dataSource.getConnection();
        log.info("数据连接"+conn.toString());
        conn.close();
        testMybatis();
    }
    private void testMybatis(){

    }
@CrossOrigin
@RequestMapping("/vue-element-admin/user/login")
    public Map<String,Object> loginTest(){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("code",20000);
        HashMap<String, Object> innerMap = new HashMap<>();
        innerMap.put("token","admin-token");
        map.put("data",innerMap);
        log.info("调用登录接口");
        return map;
    }
}
