package com.union.aimei.pc.order.controller;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderBeautician;
import com.union.aimei.pc.order.service.OrderBeauticianService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
  * @author GaoWei
  * @Date 18-8-13 下午2:55
  * @description
  */
@Api(tags="订单美容师")
@RestController
@RequestMapping(value="orderBeautician")
public class OrderBeauticianController {
       @Resource
       private OrderBeauticianService orderBeauticianService;

       @PostMapping("/front/findByPage")
       public PageInfo<OrderBeautician> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody OrderBeautician orderBeautician) {
              return this.orderBeauticianService.findByPageForFront(pageNo,pageSize,orderBeautician);
       }

       @PostMapping("/insert")
       public int insert(@RequestBody OrderBeautician orderBeautician) {
              return this.orderBeauticianService.addObj(orderBeautician);
       }

       @DeleteMapping("/deleteById/{id}")
       public int deleteById(@PathVariable (value="id") int id) {
              return this.orderBeauticianService.deleteObjById(id);
       }

       @PutMapping("/edit")
       public int edit(@RequestBody OrderBeautician orderBeautician) {
              return this.orderBeauticianService.modifyObj(orderBeautician);
       }

       @GetMapping("/queryById/{id}")
       public OrderBeautician queryById(@PathVariable (value="id") int id) {
              return this.orderBeauticianService.queryObjById(id);
       }
}