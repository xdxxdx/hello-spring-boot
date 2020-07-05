package com.xdx.hello.spring.boot.service;

import com.xdx.hello.spring.boot.common.service.BaseService;
import com.xdx.hello.spring.boot.common.service.impl.BaseServiceImpl;
import com.xdx.hello.spring.boot.entity.TBalanceLog;
import com.xdx.hello.spring.boot.entity.TUser;

public interface UserService extends BaseService<TUser> {

     int addBalance(TBalanceLog balanceLog);
}

