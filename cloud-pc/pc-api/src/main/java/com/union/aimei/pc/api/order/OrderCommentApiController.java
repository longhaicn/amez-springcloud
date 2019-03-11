package com.union.aimei.pc.api.order;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.order.OrderCommentFeign;
import com.union.aimei.common.model.order.OrderComment;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author gaowei
 */
@Api(tags = "订单评论")
@RestController
@RequestMapping(value = "orderComment")
public class OrderCommentApiController {


    @Resource
    private OrderCommentFeign orderCommentFeign;


    /**
     * 分页查询
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param orderComment 查询条件
     * @return ResponseMessage<OrderComment>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询订单评论")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<OrderComment>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                    Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                    Integer pageSize, @ApiParam(value = "查询条件") @RequestBody OrderComment orderComment) {
        return this.orderCommentFeign.findByPageForFront(pageNo, pageSize, orderComment);
    }



    /**
     * 删除OrderComment
     *
     * @param id
     * @return
     */
    @ApiOperation(httpMethod = "DELETE", value = "删除订单评论")
    @DeleteMapping("/deleteById/{id}")
    public ResponseMessage deleteById(@PathVariable(value = "id") int id) {
        return  orderCommentFeign.deleteById(id);
    }

    /**
     * 修改OrderComment
     *
     * @param orderComment
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑订单评论")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody OrderComment orderComment) {
        this.orderCommentFeign.edit(orderComment);
        return new ResponseMessage();
    }

    /**
     * 根据ID查询OrderComment
     *
     * @param id
     * @returnorderComment
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询订单评论")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<OrderComment> queryById(@PathVariable(value = "id") int id) {
        this.orderCommentFeign.queryById(id);
        return new ResponseMessage();
    }
}