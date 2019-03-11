package com.union.aimei.pc.order.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderProduct;
import com.union.aimei.pc.order.service.OrderProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
  * @author GaoWei
  * @Date 18-8-13 下午2:56
  * @description
  */
@Api(tags="订单--商品--关联")
@RestController
@RequestMapping(value="orderProduct")
public class OrderProductController {
       @Resource
       private OrderProductService orderProductService;

       @PostMapping("/front/findByPage")
       public PageInfo<OrderProduct> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody OrderProduct orderProduct) {
              return this.orderProductService.findByPageForFront(pageNo,pageSize,orderProduct);
       }

       @PostMapping("/insert")
       public int insert(@RequestBody OrderProduct orderProduct) {
              return this.orderProductService.addObj(orderProduct);
       }

       @DeleteMapping("/deleteById/{id}")
       public int deleteById(@PathVariable (value="id") int id) {
              return this.orderProductService.deleteObjById(id);
       }

       @PutMapping("/edit")
       public int edit(@RequestBody OrderProduct orderProduct) {
              return this.orderProductService.modifyObj(orderProduct);
       }

       @GetMapping("/queryById/{id}")
       public OrderProduct queryById(@PathVariable (value="id") int id) {
              return this.orderProductService.queryObjById(id);
       }
}