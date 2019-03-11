package com.union.aimei.pc.api.order;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.order.OrderGoodsInfoFeign;
import com.union.aimei.common.model.order.OrderGoodsInfo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author gaowei
 */
@Api(tags = "实物订单产品信息表")
@RestController
@RequestMapping(value = "orderGoodsInfo")
public class OrderGoodsInfoApiController {

    @Resource
    private OrderGoodsInfoFeign orderGoodsInfoFeign;

    /**
     * 分页查询
     *
     * @param pageNo         分页索引
     * @param pageSize       每页显示数量
     * @param orderGoodsInfo 查询条件
     * @return ResponseMessage<OrderGoodsInfo>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询实物订单产品信息表")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<OrderGoodsInfo>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                      Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")
                                                                      Integer pageSize, @ApiParam(value = "查询条件") @RequestBody OrderGoodsInfo orderGoodsInfo) {
        PageInfo<OrderGoodsInfo> page=orderGoodsInfoFeign.findByPageForFront(pageNo, pageSize, orderGoodsInfo);
        ResponseMessage<PageInfo<OrderGoodsInfo>> res=new ResponseMessage<>();
        res.setData(page);
        return res;
    }





    /**
     * 根据ID查询OrderGoodsInfo
     *
     * @param id
     * @returnorderGoodsInfo
     */
    @ApiOperation(httpMethod = "GET", value = "通过ID查询实物订单产品信息表")
    @GetMapping("/queryById/{id}")
    public ResponseMessage<OrderGoodsInfo> queryById(@PathVariable(value = "id") int id) {
         this.orderGoodsInfoFeign.queryById(id);
         return new ResponseMessage<>();
    }
}