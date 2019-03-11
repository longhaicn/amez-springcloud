package com.union.aimei.pc.api.order;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.order.OrderGoodsBaseFeign;
import com.union.aimei.common.model.order.OrderGoodsBase;
import com.union.aimei.common.vo.order.LogisticsInfoVo;
import com.union.aimei.common.vo.order.OrderGoodsDetailVo;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author gaowei
 */
@Api(tags = "实物订单表")
@RestController
@RequestMapping(value = "orderGoodsBase")
public class OrderGoodsBaseApiController {


    @Resource
    private OrderGoodsBaseFeign orderGoodsBaseFeign;

    /**
     * 分页查询
     *
     * @param pageNo         分页索引
     * @param pageSize       每页显示数量
     * @param orderGoodsBase 查询条件
     * @return ResponseMessage<OrderGoodsBase>
     */
    @ApiOperation(httpMethod = "POST", value = "前端分页查询实物订单表")
    @PostMapping("/front/findByPage")
    public ResponseMessage<PageInfo<OrderGoodsBase>> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0")
                                                                      Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10")

                                                                      Integer pageSize, @ApiParam(value = "查询条件") @RequestBody OrderGoodsBase orderGoodsBase) {
        PageInfo<OrderGoodsBase> page= orderGoodsBaseFeign.findByPageForFront(pageNo, pageSize, orderGoodsBase);
        ResponseMessage<PageInfo<OrderGoodsBase>> res=new ResponseMessage<>();
        res.setData(page);
        return res;
    }



    /**
     * 发货
     *
     * @param orderNo         订单编号
     * @param companyCode     快递公司编码
     * @param companyName     快递公司名称
     * @param deliveryOrderNo 快递单号
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "发货")
    @GetMapping("/deliverGoods")
    public ResponseMessage deliverGoods(@ApiParam(value = "订单编号") @RequestParam(value = "orderNo") String orderNo,
                                        @ApiParam(value = "快递公司编码") @RequestParam(value = "companyCode") String companyCode,
                                        @ApiParam(value = "快递公司名称") @RequestParam(value = "companyName") String companyName,
                                        @ApiParam(value = "快递单号") @RequestParam(value = "deliveryOrderNo") String deliveryOrderNo) {
        return orderGoodsBaseFeign.deliverGoods(orderNo, companyCode, companyName, deliveryOrderNo);
    }


    /**
     * 查询订单物流信息
     *
     * @param orderNo
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "查询物流信息")
    @GetMapping(value = "/queryDeliveryInfo")
    public ResponseMessage<LogisticsInfoVo> queryDeliveryInfo(
            @ApiParam(value = "订单编号", defaultValue = "201803061540477770001") @RequestParam(value = "orderNo") String orderNo
    ) {
        return orderGoodsBaseFeign.queryDeliveryInfo(orderNo);
    }

    @ApiOperation(httpMethod = "GET", value = "查询实物订单详情")
    @GetMapping("/queryDetailsById/{id}")
    public ResponseMessage<OrderGoodsDetailVo> queryDetailsById(@PathVariable(value = "id") Integer id) {
        return orderGoodsBaseFeign.queryDetailsById(id);
    }
}