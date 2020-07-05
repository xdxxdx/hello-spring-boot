package com.xdx.hello.spring.boot.service.impl;

import com.xdx.hello.spring.boot.common.dto.QueryParam;
import com.xdx.hello.spring.boot.common.service.impl.BaseServiceImpl;
import com.xdx.hello.spring.boot.dao.TUserMapper;
import com.xdx.hello.spring.boot.entity.TAdmin;
import com.xdx.hello.spring.boot.entity.TBalanceLog;
import com.xdx.hello.spring.boot.entity.TUser;
import com.xdx.hello.spring.boot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
@Slf4j
public class UserServiceImpl extends BaseServiceImpl<TUserMapper, TUser> implements UserService {
    @Override
    public List<TUser> selectListByQueryParam(QueryParam queryParam) {
        Example example = new Example(TUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isDel",0);
        if(queryParam.getUserName() != null){
            criteria.andLike("userName", queryParam.getUserName() + "%");
        }
        if(queryParam.getUserNo()!=null){
            criteria.andEqualTo("userNo",queryParam.getUserNo());
        }
        example.setOrderByClause(queryParam.getSort()+" "+ queryParam.getSortOrder());
        List<TUser> list = mapper.selectByExample(example);
        return list;
    }

    @Override
    public Long selectCountByQueryParam(QueryParam queryParam) {
        Example example = new Example(TUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isDel",0);
        if(queryParam.getUserName() != null){
            criteria.andLike("userName", queryParam.getUserName() + "%");
        }
        if(queryParam.getUserNo()!=null){
            criteria.andEqualTo("userNo",queryParam.getUserNo());
        }
        return Long.valueOf(mapper.selectCountByExample(example));
    }

    @Override
    public int hiddenById(long id) {
        TUser user=new TUser();
        user.setId(id);
        user.setIsDel(1);
        return super.updateSelectiveById(user);
    }

    /**
     * 新增余额及积分信息
     * @param balanceLog
     * @return
     */
    @Override
    public int addBalance(TBalanceLog balanceLog) {
        return mapper.addBalance(balanceLog);
    }
}
