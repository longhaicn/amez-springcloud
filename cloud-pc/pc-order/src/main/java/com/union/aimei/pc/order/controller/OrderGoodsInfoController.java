package com.union.aimei.pc.order.controller;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderGoodsInfo;
import com.union.aimei.pc.order.service.OrderGoodsInfoService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
  * @author GaoWei
  * @Date 18-8-13 下午2:55
  * @description
  */
@Api(tags="实物订单产品信息表")
@RestController
@RequestMapping(value="orderGoodsInfo")
public class OrderGoodsInfoController {
       @Resource
       private OrderGoodsInfoService orderGoodsInfoService;

       @PostMapping("/front/findByPage")
       public PageInfo<OrderGoodsInfo> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody OrderGoodsInfo orderGoodsInfo) {
              return this.orderGoodsInfoService.findByPageForFront(pageNo,pageSize,orderGoodsInfo);
       }

       @PostMapping("/insert")
       public int insert(@RequestBody OrderGoodsInfo orderGoodsInfo) {
              return this.orderGoodsInfoService.addObj(orderGoodsInfo);
       }

       @DeleteMapping("/deleteById/{id}")
       public int deleteById(@PathVariable (value="id") int id) {
              return this.orderGoodsInfoService.deleteObjById(id);
       }

       @PutMapping("/edit")
       public int edit(@RequestBody OrderGoodsInfo orderGoodsInfo) {
              return this.orderGoodsInfoService.modifyObj(orderGoodsInfo);
       }

       @GetMapping("/queryById/{id}")
       public OrderGoodsInfo queryById(@PathVariable (value="id") int id) {
              return this.orderGoodsInfoService.queryObjById(id);
       }

       @GetMapping("/queryByOrderGoodsId/{orderGoodsId}")
       public ResponseMessage<List<OrderGoodsInfo>> queryByOrderGoodsId(@PathVariable(value = "orderGoodsId")Integer orderGoodsId){
              return orderGoodsInfoService.queryByOrderGoodsId(orderGoodsId);
       }
}