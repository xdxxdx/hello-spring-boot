package com.xdx.hello.spring.boot.controller;

import com.github.pagehelper.PageHelper;
import com.xdx.hello.spring.boot.common.controller.BaseController;
import com.xdx.hello.spring.boot.common.dto.BaseResponse;
import com.xdx.hello.spring.boot.common.dto.PageResponse;
import com.xdx.hello.spring.boot.common.dto.QueryParam;
import com.xdx.hello.spring.boot.entity.TCommodity;
import com.xdx.hello.spring.boot.entity.TSpec;
import com.xdx.hello.spring.boot.service.CommodityService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("commodity")
public class CommodityController extends BaseController<CommodityService, TCommodity> {
//    @ResponseBody
//    @RequestMapping(value="/lists",method = RequestMethod.GET )
//    protected BaseResponse<Map<String,Object>> listByQueryParam(HttpServletRequest request, QueryParam queryParam,
//                                                                @RequestParam(value = "limit",required = false) Integer pageSize,
//                                                                @RequestParam(value = "page",required = false) Integer pageNum){
//        if(pageNum != null && pageSize != null){
//            PageHelper.startPage(pageNum, pageSize);
//        }
//        List<TCommodity> result = service.selectListByQueryParam(queryParam);
//        Long size=service.selectCountByQueryParam(queryParam);
//        Map<String,Object> map=new HashMap<>();
//        map.put("items",result);
//        map.put("total",size);
//        return PageResponse.<Map<String,Object>>success4element(map);
//    }
    /**
     * 新增商品
     * @param commodity
     * @return
     */
    @PostMapping("/add")
    public BaseResponse add(@RequestBody TCommodity commodity){
        if(service.addCommodity(commodity)){
            return BaseResponse.success4element(null);
        }else{
            return BaseResponse.fail(-1);
        }
    }

    /**
     * 更新操作
     * 注意body中需要包含主键
     * @param commodity
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/{id}",method = RequestMethod.POST)
    public BaseResponse<?> modify(HttpServletRequest request, @RequestBody TCommodity commodity, @PathVariable("id")String id){
        if(service.modifyCommodity(commodity)){
            return BaseResponse.success4element(null);
        }else{
            return BaseResponse.fail(-1);
        }
    }
}
