package com.xdx.hello.spring.boot.dao;

import com.xdx.hello.spring.boot.common.dto.QueryParam;
import com.xdx.hello.spring.boot.entity.TCommodity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TCommodityMapper extends Mapper<TCommodity> {
    List<TCommodity>selectListWithCategory(QueryParam queryParam);
    List<TCommodity>selectListByJoin(QueryParam queryParam);
}