package com.xdx.hello.spring.boot.service.impl;

import com.xdx.hello.spring.boot.HelloSpringBootApplication;
import com.xdx.hello.spring.boot.common.dto.BaseResponse;
import com.xdx.hello.spring.boot.common.dto.QueryParam;
import com.xdx.hello.spring.boot.common.service.impl.BaseServiceImpl;
import com.xdx.hello.spring.boot.dao.TAdminMapper;
import com.xdx.hello.spring.boot.entity.TAdmin;
import com.xdx.hello.spring.boot.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloSpringBootApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AdminServiceImplTest extends BaseServiceImpl<TAdminMapper, TAdmin> implements AdminService{

    @Test
    @Transactional
    @Rollback(true)
    public void testAddAdmin(){
        TAdmin admin=new TAdmin();
        admin.setUserName("海沧");
        admin.setPwd("1122222");
        insert(admin);
    }


    @Override
    public boolean checkAdminLogin(String userName, String pwd) {
        return true;
    }


    @Override
    public List<TAdmin> selectListByQueryParam(QueryParam queryParam) {
        return null;
    }

    @Override
    public Long selectCountByQueryParam(QueryParam queryParam) {
        return null;
    }

    @Override
    public int hiddenById(long id) {
        return 0;
    }


}
