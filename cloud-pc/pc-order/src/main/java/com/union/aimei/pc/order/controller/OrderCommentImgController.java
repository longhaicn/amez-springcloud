package com.union.aimei.pc.order.controller;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderCommentImg;
import com.union.aimei.pc.order.service.OrderCommentImgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
  * @author GaoWei
  * @Date 18-8-13 下午2:55
  * @description
  */
@Api(tags="订单评论图片表")
@RestController
@RequestMapping(value="orderCommentImg")
public class OrderCommentImgController {
       @Resource
       private OrderCommentImgService orderCommentImgService;

       @PostMapping("/front/findByPage")
       public PageInfo<OrderCommentImg> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody OrderCommentImg orderCommentImg) {
              return this.orderCommentImgService.findByPageForFront(pageNo,pageSize,orderCommentImg);
       }

       @PostMapping("/insert")
       public int insert(@RequestBody OrderCommentImg orderCommentImg) {
              return this.orderCommentImgService.addObj(orderCommentImg);
       }

       @DeleteMapping("/deleteById/{id}")
       public int deleteById(@PathVariable (value="id") int id) {
              return this.orderCommentImgService.deleteObjById(id);
       }

       @PutMapping("/edit")
       public int edit(@RequestBody OrderCommentImg orderCommentImg) {
              return this.orderCommentImgService.modifyObj(orderCommentImg);
       }

       @GetMapping("/queryById/{id}")
       public OrderCommentImg queryById(@PathVariable (value="id") int id) {
              return this.orderCommentImgService.queryObjById(id);
       }
}