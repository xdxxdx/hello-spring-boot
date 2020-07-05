package com.xdx.hello.spring.boot.service.impl;

import com.xdx.hello.spring.boot.common.dto.QueryParam;
import com.xdx.hello.spring.boot.common.service.impl.BaseServiceImpl;
import com.xdx.hello.spring.boot.dao.TSpecMapper;
import com.xdx.hello.spring.boot.entity.TSpec;
import com.xdx.hello.spring.boot.service.SpecService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecServiceImpl extends BaseServiceImpl<TSpecMapper, TSpec> implements SpecService {
    @Override
    public List<TSpec> selectListByQueryParam(QueryParam queryParam) {
        return null;
    }

    @Override
    public Long selectCountByQueryParam(QueryParam queryParam) {
        return null;
    }

    @Override
    public int hiddenById(long id) {
        return 0;
    }
}
