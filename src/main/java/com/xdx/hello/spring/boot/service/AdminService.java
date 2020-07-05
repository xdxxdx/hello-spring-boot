package com.xdx.hello.spring.boot.service;

import com.xdx.hello.spring.boot.common.dto.BaseResponse;
import com.xdx.hello.spring.boot.common.service.BaseService;
import com.xdx.hello.spring.boot.entity.TAdmin;

import java.util.List;

public interface AdminService extends BaseService<TAdmin> {
    boolean checkAdminLogin(String userName, String pwd);

}
