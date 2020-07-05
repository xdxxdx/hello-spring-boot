package com.xdx.hello.spring.boot.controller;

import com.xdx.hello.spring.boot.common.controller.BaseController;
import com.xdx.hello.spring.boot.common.dto.BaseResponse;
import com.xdx.hello.spring.boot.entity.TCategory;
import com.xdx.hello.spring.boot.service.CategoryService;
import com.xdx.hello.spring.boot.service.impl.CategoryServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
public class CategoryController extends BaseController<CategoryService, TCategory> {

}
