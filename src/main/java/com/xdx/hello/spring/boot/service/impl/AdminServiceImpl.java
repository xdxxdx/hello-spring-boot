package com.xdx.hello.spring.boot.service.impl;

import com.xdx.hello.spring.boot.common.dto.BaseResponse;
import com.xdx.hello.spring.boot.common.dto.QueryParam;
import com.xdx.hello.spring.boot.common.service.impl.BaseServiceImpl;
import com.xdx.hello.spring.boot.dao.TAdminMapper;
import com.xdx.hello.spring.boot.entity.TAdmin;
import com.xdx.hello.spring.boot.service.AdminService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class AdminServiceImpl extends BaseServiceImpl<TAdminMapper, TAdmin> implements AdminService {
    @Override
    public boolean checkAdminLogin(String userName, String pwd) {
        TAdmin admin=new TAdmin();
        admin.setUserName(userName);
        admin=selectOne(admin);
        if(admin!=null){
            if(admin.getPwd().equals(pwd)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<TAdmin> selectListByQueryParam(QueryParam queryParam) {
        Example example = new Example(TAdmin.class);
        Example.Criteria criteria = example.createCriteria();
        if(queryParam.getUserName() != null){
            criteria.andLike("userName", queryParam.getUserName() + "%");
        }
        example.setOrderByClause(queryParam.getSort()+" "+ queryParam.getSortOrder());
        List<TAdmin> list = mapper.selectByExample(example);
        return list;
    }

    @Override
    public Long selectCountByQueryParam(QueryParam queryParam) {
        Example example = new Example(TAdmin.class);
        Example.Criteria criteria = example.createCriteria();
        if(queryParam.getUserName() != null){
            criteria.andLike("userName", queryParam.getUserName() + "%");
        }
        return Long.valueOf(mapper.selectCountByExample(example));
    }

    @Override
    public int hiddenById(long id) {
        return 0;
    }

}
