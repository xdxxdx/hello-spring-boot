package com.xdx.hello.spring.boot.controller;

import com.xdx.hello.spring.boot.common.controller.BaseController;
import com.xdx.hello.spring.boot.entity.TSpec;
import com.xdx.hello.spring.boot.service.SpecService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("spec")
public class SpecController extends BaseController<SpecService, TSpec> {
}
