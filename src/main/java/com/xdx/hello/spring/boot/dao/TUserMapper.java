package com.xdx.hello.spring.boot.dao;

import com.xdx.hello.spring.boot.entity.TBalanceLog;
import com.xdx.hello.spring.boot.entity.TUser;
import tk.mybatis.mapper.common.Mapper;

public interface TUserMapper extends Mapper<TUser> {
    int addBalance(TBalanceLog balanceLog);
}