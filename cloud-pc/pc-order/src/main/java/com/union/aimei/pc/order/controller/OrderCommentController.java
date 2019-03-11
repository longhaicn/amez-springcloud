package com.union.aimei.pc.order.controller;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderComment;
import com.union.aimei.pc.order.service.OrderCommentService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
  * @author GaoWei
  * @Date 18-8-13 下午2:55
  * @description
  */
@Api(tags="订单评论")
@RestController
@RequestMapping(value="orderComment")
public class OrderCommentController {

       @Resource
       private OrderCommentService orderCommentService;

       @PostMapping("/front/findByPage")
       public ResponseMessage<PageInfo<OrderComment>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                                     Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")

                                                                   Integer pageSize, @ApiParam(value = "查询条件")@RequestBody OrderComment orderComment) {
              ResponseMessage<PageInfo<OrderComment>> res=new ResponseMessage<>();
              res.setData(this.orderCommentService.findByPageForFront(pageNo, pageSize, orderComment));
              return res;

       }

       @PostMapping("/insert")
       public int insert(@RequestBody OrderComment orderComment) {
              return this.orderCommentService.addObj(orderComment);
       }

        /**
         * 取消订单评论
         * @param id
         * @return
         */
       @DeleteMapping("/deleteById/{id}")
       public ResponseMessage deleteById(@PathVariable (value="id") int id) {

              return orderCommentService.cancelOrderComment(id);

       }

       @PutMapping("/edit")
       public int edit(@RequestBody OrderComment orderComment) {
              return this.orderCommentService.modifyObj(orderComment);
       }

       @GetMapping("/queryById/{id}")
       public OrderComment queryById(@PathVariable (value="id") int id) {
              return this.orderCommentService.queryObjById(id);
       }
}