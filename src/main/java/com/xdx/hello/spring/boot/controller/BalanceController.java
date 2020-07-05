package com.xdx.hello.spring.boot.controller;

import com.xdx.hello.spring.boot.common.controller.BaseController;
import com.xdx.hello.spring.boot.common.dto.BaseResponse;
import com.xdx.hello.spring.boot.entity.TBalanceLog;
import com.xdx.hello.spring.boot.service.BalanceLogService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("balance")
public class BalanceController extends BaseController<BalanceLogService, TBalanceLog> {
    /**
     * 新增充值
     * @param balanceLog
     * @return
     */
    @PostMapping("/add")
    public BaseResponse add(@RequestBody TBalanceLog balanceLog){
        if(service.addBalance(balanceLog)){
            return BaseResponse.success4element(null);
        }else{
            return BaseResponse.fail(-1);
        }
    }
}
