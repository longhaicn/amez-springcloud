package com.union.aimei.app.api.order.controller;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderRefundsConsultRecord;
import com.union.aimei.app.api.order.service.OrderRefundsConsultRecordService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
  * @author GaoWei
  * @Date 18-8-13 下午1:46
  * @description
  */
@Api(tags="服务订单-退款协商记录表")
@RestController
@RequestMapping(value="orderRefundsConsultRecord")
public class OrderRefundsConsultRecordController {
       @Resource
       private OrderRefundsConsultRecordService orderRefundsConsultRecordService;

       @PostMapping("/front/findByPage")
       public PageInfo<OrderRefundsConsultRecord> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody OrderRefundsConsultRecord orderRefundsConsultRecord) {
              return this.orderRefundsConsultRecordService.findByPageForFront(pageNo,pageSize,orderRefundsConsultRecord);
       }

       @PostMapping("/insert")
       public int insert(@RequestBody OrderRefundsConsultRecord orderRefundsConsultRecord) {
              return this.orderRefundsConsultRecordService.addObj(orderRefundsConsultRecord);
       }

       @DeleteMapping("/deleteById/{id}")
       public int deleteById(@PathVariable (value="id") int id) {
              return this.orderRefundsConsultRecordService.deleteObjById(id);
       }

       @PutMapping("/edit")
       public int edit(@RequestBody OrderRefundsConsultRecord orderRefundsConsultRecord) {
              return this.orderRefundsConsultRecordService.modifyObj(orderRefundsConsultRecord);
       }

       @GetMapping("/queryById/{id}")
       public OrderRefundsConsultRecord queryById(@PathVariable (value="id") int id) {
              return this.orderRefundsConsultRecordService.queryObjById(id);
       }


       @GetMapping(value = "/queryConsultRecords/{orderNo}")
       public ResponseMessage queryConsultRecords(
               @RequestParam(value = "pageNo",defaultValue = "0")Integer pageNo,
               @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize,
               @PathVariable(value = "orderNo") String orderNo){
              return orderRefundsConsultRecordService.queryConsultRecords(pageNo,pageSize,orderNo);
       }
}