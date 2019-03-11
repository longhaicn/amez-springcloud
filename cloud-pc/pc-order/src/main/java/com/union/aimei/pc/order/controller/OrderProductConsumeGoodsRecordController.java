package com.union.aimei.pc.order.controller;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderProductConsumeGoodsRecord;
import com.union.aimei.pc.order.service.OrderProductConsumeGoodsRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
  * @author GaoWei
  * @Date 18-8-13 下午2:55
  * @description
  */
@Api(tags="订单-服务消耗实物产品记录表")
@RestController
@RequestMapping(value="orderProductConsumeGoodsRecord")
public class OrderProductConsumeGoodsRecordController {
       @Resource
       private OrderProductConsumeGoodsRecordService orderProductConsumeGoodsRecordService;

       @PostMapping("/front/findByPage")
       public PageInfo<OrderProductConsumeGoodsRecord> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody OrderProductConsumeGoodsRecord orderProductConsumeGoodsRecord) {
              return this.orderProductConsumeGoodsRecordService.findByPageForFront(pageNo,pageSize,orderProductConsumeGoodsRecord);
       }

       @PostMapping("/insert")
       public int insert(@RequestBody OrderProductConsumeGoodsRecord orderProductConsumeGoodsRecord) {
              return this.orderProductConsumeGoodsRecordService.addObj(orderProductConsumeGoodsRecord);
       }

       @DeleteMapping("/deleteById/{id}")
       public int deleteById(@PathVariable (value="id") int id) {
              return this.orderProductConsumeGoodsRecordService.deleteObjById(id);
       }

       @PutMapping("/edit")
       public int edit(@RequestBody OrderProductConsumeGoodsRecord orderProductConsumeGoodsRecord) {
              return this.orderProductConsumeGoodsRecordService.modifyObj(orderProductConsumeGoodsRecord);
       }

       @GetMapping("/queryById/{id}")
       public OrderProductConsumeGoodsRecord queryById(@PathVariable (value="id") int id) {
              return this.orderProductConsumeGoodsRecordService.queryObjById(id);
       }
}