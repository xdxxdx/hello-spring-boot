package com.xdx.hello.spring.boot.service.impl;

import com.xdx.hello.spring.boot.common.dto.QueryParam;
import com.xdx.hello.spring.boot.common.service.impl.BaseServiceImpl;
import com.xdx.hello.spring.boot.dao.TCategoryMapper;
import com.xdx.hello.spring.boot.dao.TCommodityMapper;
import com.xdx.hello.spring.boot.entity.TCategory;
import com.xdx.hello.spring.boot.entity.TCommodity;
import com.xdx.hello.spring.boot.entity.TSpec;
import com.xdx.hello.spring.boot.entity.TUser;
import com.xdx.hello.spring.boot.service.CommodityService;
import com.xdx.hello.spring.boot.service.SpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CommodityServiceImpl extends BaseServiceImpl<TCommodityMapper, TCommodity> implements CommodityService {
    @Autowired
    private SpecService specService;
    @Override
    public List<TCommodity> selectListByQueryParam(QueryParam queryParam) {
        queryParam.formatSort();
        List<TCommodity> list = mapper.selectListWithCategory(queryParam);
//        List<TCommodity>list=mapper.selectListByJoin(queryParam);
        return list;
    }

    @Override
    public Long selectCountByQueryParam(QueryParam queryParam) {
        Example example = new Example(TCommodity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isDel",0);
        if(queryParam.getCommodityName() != null){
            criteria.andEqualTo("commodityName", queryParam.getCommodityName() + "%");
        }
        return Long.valueOf(mapper.selectCountByExample(example));
    }

    @Override
    public int hiddenById(long id) {
        TCommodity commodity=new TCommodity();
        commodity.setId(id);
        commodity.setIsDel(1);
        return 0;
    }

    @Override
    @Transactional
    public boolean addCommodity(TCommodity commodity) {
        //添加基础数据
        this.insertSelective(commodity);
        //添加规格数据
        if(commodity.getSpecs().size()>0){
            for (TSpec spec : commodity.getSpecs()) {
                spec.setCommodityId(commodity.getId());
                specService.insertSelective(spec);
            }
        }
        return true;
    }
    @Override
    @Transactional
    public boolean modifyCommodity(TCommodity commodity){
        this.updateSelectiveById(commodity);
        if(commodity.getSpecs().size()>0){
            for (TSpec spec : commodity.getSpecs()) {
                if(spec.getId()!=null){
                    specService.updateSelectiveById(spec);
                }else{
                    spec.setCommodityId(commodity.getId());
                    specService.insertSelective(spec);
                }
            }
        }
        return true;
    }
}
