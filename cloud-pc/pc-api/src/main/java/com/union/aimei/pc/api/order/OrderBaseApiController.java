package com.union.aimei.pc.api.order;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.order.OrderBaseFeign;
import com.union.aimei.common.model.order.OrderBase;
import com.union.aimei.common.vo.order.OrderListQueryVo;
import com.union.aimei.common.vo.order.OrderListVo;
import com.union.aimei.common.vo.order.OrderRefundDetailVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author gaowei
 */
@Api(tags = "订单")
@RestController
@RequestMapping(value = "orderBase")
public class OrderBaseApiController {


    @Resource
    private OrderBaseFeign orderBaseFeign;



    /**
     * 订单管理-订单列表
     *
     * @return
     */
    @ApiOperation(httpMethod = "POST", value = "订单管理-列表")
    @PostMapping(value = "queryOrderList")
    public ResponseMessage<PageInfo<OrderListVo>> queryOrderList(
            @RequestParam(value = "pageNum", defaultValue = "0") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestBody OrderListQueryVo orderListQueryVo) {
        return orderBaseFeign.queryOrderList(pageNum, pageSize, orderListQueryVo);
    }

    @ApiOperation(httpMethod = "GET", value = "订单管理-查询订单详情")
    @GetMapping(value = "queryOrderInfoById/{orderId}")
    public ResponseMessage queryOrderInfoById(@PathVariable(value = "orderId") Integer orderId) {
        return orderBaseFeign.queryOrderDetailById(orderId);
    }

    @ApiOperation(httpMethod = "GET", value = "根据订单ID查询退款详情")
    @GetMapping(value = "queryOrderRefundDetails/{orderId}")
    public ResponseMessage<OrderRefundDetailVo> queryOrderRefundDetails(@PathVariable(value = "orderId") Integer orderId) {
        return orderBaseFeign.queryOrderRefundDetails(orderId);
    }


    /**
     * 修改OrderBase
     *
     * @param orderBase
     * @return
     */
    @ApiOperation(httpMethod = "PUT", value = "编辑订单")
    @PutMapping("/edit")
    public ResponseMessage edit(@RequestBody OrderBase orderBase) {
        orderBaseFeign.edit(orderBase);
        return new ResponseMessage();
    }







}