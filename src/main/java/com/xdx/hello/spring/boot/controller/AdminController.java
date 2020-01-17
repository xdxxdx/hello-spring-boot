package com.xdx.hello.spring.boot.controller;

import com.xdx.hello.spring.boot.common.controller.BaseController;
import com.xdx.hello.spring.boot.entity.TAdmin;
import com.xdx.hello.spring.boot.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController extends BaseController<AdminService, TAdmin> {
}
