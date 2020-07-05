package com.xdx.hello.spring.boot.controller;

import com.xdx.hello.spring.boot.common.controller.BaseController;
import com.xdx.hello.spring.boot.common.dto.BaseResponse;
import com.xdx.hello.spring.boot.entity.TUser;
import com.xdx.hello.spring.boot.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("user")
public class UserController extends BaseController<UserService, TUser> {
    @RequestMapping(value="/check/{userNo}",method = RequestMethod.GET)
    public BaseResponse checkUserNo(@PathVariable("userNo") String userNo){
        TUser userTmp=new TUser();
        userTmp.setUserNo(userNo);
        TUser user = service.selectOne(userTmp);
        if(user!=null){
            return BaseResponse.success4element("exist",null);
        }else{
            return BaseResponse.success4element("no-exist",null);
        }

    }
}
