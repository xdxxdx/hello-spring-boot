package com.xdx.hello.spring.boot.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.xdx.hello.spring.boot.common.controller.BaseController;
import com.xdx.hello.spring.boot.common.dto.BaseResponse;
import com.xdx.hello.spring.boot.entity.TAdmin;
import com.xdx.hello.spring.boot.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
@Slf4j
@RestController
@RequestMapping("admin")
public class AdminController extends BaseController<AdminService, TAdmin> {
    @PostMapping("/login")
    public BaseResponse adminLogin(@RequestBody TAdmin admin, HttpSession session){
        if(service.checkAdminLogin(admin.getUserName(),admin.getPwd())){
            //登录成功，返回token
            //这边的token我们就返回sessionId
            String sessionId=session.getId();
            Map<String,String> token=new HashMap<>();
            token.put("token",sessionId);
            admin=service.selectOne(admin);
            session.setAttribute("admin",admin);
            return BaseResponse.<Map<String,String>>success4element(token);
        }else{
            return BaseResponse.fail(1,"用户名或密码错误");
        }
    }
    @GetMapping("/info")
    public BaseResponse adminInfo(HttpSession session){
            if(session.getAttribute("admin")!=null){
                //判定session是否过期
                log.info(session.getId());
                TAdmin admin= (TAdmin) session.getAttribute("admin");
                Map<String,Object>map=new HashMap<>();
                String roles=admin.getRole();
                String[] roleArr=roles.split(",");
                map.put("roles",roleArr);
                map.put("userName",admin.getUserName());
                return BaseResponse.<Map<String,Object>>success4element(map);
            }
        return BaseResponse.fail(50014,"服务端登录信息已过期");
    }
}
