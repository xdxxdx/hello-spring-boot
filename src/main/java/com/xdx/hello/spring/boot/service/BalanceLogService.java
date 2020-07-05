package com.xdx.hello.spring.boot.service;

import com.xdx.hello.spring.boot.common.service.BaseService;
import com.xdx.hello.spring.boot.entity.TBalanceLog;
import org.springframework.stereotype.Service;


public interface BalanceLogService extends BaseService<TBalanceLog> {
    boolean addBalance(TBalanceLog balanceLog);
}
