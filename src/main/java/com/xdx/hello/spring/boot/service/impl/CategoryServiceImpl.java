package com.xdx.hello.spring.boot.service.impl;

import com.xdx.hello.spring.boot.common.dto.QueryParam;
import com.xdx.hello.spring.boot.common.service.impl.BaseServiceImpl;
import com.xdx.hello.spring.boot.dao.TCategoryMapper;
import com.xdx.hello.spring.boot.entity.TCategory;
import com.xdx.hello.spring.boot.entity.TCommodity;
import com.xdx.hello.spring.boot.entity.TUser;
import com.xdx.hello.spring.boot.service.CategoryService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<TCategoryMapper, TCategory> implements CategoryService {
    @Override
    public List<TCategory> selectListByQueryParam(QueryParam queryParam) {
        Example example = new Example(TCategory.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isDel",0);
        if(queryParam.getCategoryName() != null){
            criteria.andEqualTo("categoryName", queryParam.getCategoryName());
        }
        example.setOrderByClause(queryParam.getSort()+" "+ queryParam.getSortOrder());
        List<TCategory> list = mapper.selectByExample(example);
        return list;
    }

    @Override
    public Long selectCountByQueryParam(QueryParam queryParam) {
        Example example = new Example(TCategory.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isDel",0);
        if(queryParam.getCategoryName() != null){
            criteria.andEqualTo("categoryName", queryParam.getCategoryName() + "%");
        }
        return Long.valueOf(mapper.selectCountByExample(example));
    }

    @Override
    public int hiddenById(long id) {
        TCategory category = new TCategory();
        category.setId(id);
        category.setIsDel(1);
        return this.updateSelectiveById(category);
    }
}
