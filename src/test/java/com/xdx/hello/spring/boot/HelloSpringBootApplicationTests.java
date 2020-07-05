package com.xdx.hello.spring.boot;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloSpringBootApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloSpringBootApplicationTests {
    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate testRestTemplate;
    @BeforeEach
    public void setUp() throws MalformedURLException {
        log.info("在每个测试方法运行之前执行");
        this.base=new URL("http://localhost:"+port+"/");
    }
    @Test
    void contextLoads() {
        ResponseEntity<String> resp = testRestTemplate.getForEntity(base.toString(), String.class);
        assertThat(resp.getBody(),equalTo("hello Spring Boot"));
    }


}
