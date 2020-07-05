package com.xdx.hello.spring.boot.service.impl;

import com.xdx.hello.spring.boot.common.dto.BaseResponse;
import com.xdx.hello.spring.boot.common.dto.QueryParam;
import com.xdx.hello.spring.boot.common.service.impl.BaseServiceImpl;
import com.xdx.hello.spring.boot.dao.TBalanceLogMapper;
import com.xdx.hello.spring.boot.dao.TUserMapper;
import com.xdx.hello.spring.boot.entity.TAdmin;
import com.xdx.hello.spring.boot.entity.TBalanceLog;
import com.xdx.hello.spring.boot.entity.TUser;
import com.xdx.hello.spring.boot.service.BalanceLogService;
import com.xdx.hello.spring.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.sql.SQLException;
import java.util.List;

@Service
public class BalanceLogServiceImpl extends BaseServiceImpl<TBalanceLogMapper, TBalanceLog> implements BalanceLogService {
    @Autowired
    private UserService userService;
    @Override
    public List<TBalanceLog> selectListByQueryParam(QueryParam queryParam) {
        Example example= new Example(TBalanceLog.class);
        Example.Criteria criteria = example.createCriteria();
        if(queryParam.getUserId() != null){
            criteria.andEqualTo("userId", queryParam.getUserId());
        }
        if(queryParam.getDirection()>0){
            criteria.andGreaterThan("balance",0);
        }else{
            criteria.andLessThan("balance",0);
        }
        example.setOrderByClause(queryParam.getSort()+" "+ queryParam.getSortOrder());
        List<TBalanceLog> list = mapper.selectByExample(example);
        return list;
    }

    @Override
    public Long selectCountByQueryParam(QueryParam queryParam) {
        Example example= new Example(TBalanceLog.class);
        Example.Criteria criteria = example.createCriteria();
        if(queryParam.getUserId() != null){
            criteria.andEqualTo("userId", queryParam.getUserId());
        }
        if(queryParam.getDirection()>0){
            criteria.andGreaterThan("balance",0);
        }else{
            criteria.andLessThan("balance",0);
        }
        return Long.valueOf(mapper.selectCountByExample(example));
    }

    @Override
    public int hiddenById(long id) {
        return 0;
    }


    @Transactional
    public boolean addBalance(TBalanceLog balanceLog){
        if(super.insertSelective(balanceLog)>0){
            userService.addBalance(balanceLog);
        }
        return true;
    }
}
