package com.union.aimei.app.api.order.controller;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderReturnProduct;
import com.union.aimei.app.api.order.service.OrderReturnProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/7,11:52
 */
@Api(tags = "退换货的申请明细")
@RestController
@RequestMapping(value = "orderReturnProduct")
public class OrderReturnProductController {
    @Resource
    private OrderReturnProductService orderReturnProductService;

    @PostMapping("/front/findByPage")
    public PageInfo<OrderReturnProduct> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                                   Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                                   Integer pageSize, @ApiParam(value = "查询条件")@RequestBody OrderReturnProduct orderReturnProduct) {
        return this.orderReturnProductService.findByPageForFront(pageNo, pageSize, orderReturnProduct);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody OrderReturnProduct orderReturnProduct) {
        return this.orderReturnProductService.addObj(orderReturnProduct);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable int id) {
        return this.orderReturnProductService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody OrderReturnProduct orderReturnProduct) {
        return this.orderReturnProductService.modifyObj(orderReturnProduct);
    }

    @GetMapping("/queryById/{id}")
    public OrderReturnProduct queryById(@PathVariable int id) {
        return this.orderReturnProductService.queryObjById(id);
    }


}