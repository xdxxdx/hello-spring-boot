package com.xdx.hello.spring.boot.service.impl;

import com.xdx.hello.spring.boot.common.service.impl.BaseServiceImpl;
import com.xdx.hello.spring.boot.dao.TAdminMapper;
import com.xdx.hello.spring.boot.entity.TAdmin;
import com.xdx.hello.spring.boot.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends BaseServiceImpl<TAdminMapper, TAdmin> implements AdminService {
}
