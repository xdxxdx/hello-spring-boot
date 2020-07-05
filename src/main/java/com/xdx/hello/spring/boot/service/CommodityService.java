package com.xdx.hello.spring.boot.service;

import com.xdx.hello.spring.boot.common.service.BaseService;
import com.xdx.hello.spring.boot.entity.TCommodity;

public interface CommodityService extends BaseService<TCommodity> {
    boolean addCommodity(TCommodity commodity);
    boolean modifyCommodity(TCommodity commodity);
}
