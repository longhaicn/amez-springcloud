package com.union.aimei.pc.order.controller;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderGoodsBase;
import com.union.aimei.common.vo.order.LogisticsInfoVo;
import com.union.aimei.common.vo.order.OrderGoodsDetailVo;
import com.union.aimei.common.vo.order.OrderGoodsQueryVo;
import com.union.aimei.pc.order.service.OrderGoodsBaseService;
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
@Api(tags = "实物订单表")
@RestController
@RequestMapping(value = "orderGoodsBase")
public class OrderGoodsBaseController {
    @Resource
    private OrderGoodsBaseService orderGoodsBaseService;

    @PostMapping("/front/findByPage")
    public PageInfo<OrderGoodsBase> findByPageForFront(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0")
                                                               Integer pageNo, @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10")
                                                               Integer pageSize, @ApiParam(value = "查询条件") @RequestBody OrderGoodsBase orderGoodsBase) {
        return this.orderGoodsBaseService.findByPageForFront(pageNo, pageSize, orderGoodsBase);
    }


    @PostMapping(value = "/queryByPage")
    public PageInfo<OrderGoodsDetailVo> queryByPage(
            @ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
            @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @ApiParam(value = "查询条件") @RequestBody OrderGoodsQueryVo orderGoodsQueryVo) {
        return orderGoodsBaseService.queryByPage(pageNo, pageSize, orderGoodsQueryVo);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody OrderGoodsBase orderGoodsBase) {
        return this.orderGoodsBaseService.addObj(orderGoodsBase);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.orderGoodsBaseService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody OrderGoodsBase orderGoodsBase) {
        return this.orderGoodsBaseService.modifyObj(orderGoodsBase);
    }

    @GetMapping("/queryById/{id}")
    public OrderGoodsBase queryById(@PathVariable(value = "id") int id) {
        return this.orderGoodsBaseService.queryObjById(id);
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
    @GetMapping("/deliverGoods")
    public ResponseMessage deliverGoods(@RequestParam(value = "orderNo") String orderNo,
                                        @RequestParam(value = "companyCode") String companyCode,
                                        @RequestParam(value = "companyName") String companyName,
                                        @RequestParam(value = "deliveryOrderNo") String deliveryOrderNo) {
        return orderGoodsBaseService.deliverGoods(orderNo, companyCode, companyName, deliveryOrderNo);
    }


    /**
     * 查询订单物流信息
     *
     * @param orderNo
     * @return
     */
    @GetMapping(value = "/queryDeliveryInfo")
    public ResponseMessage<LogisticsInfoVo> queryDeliveryInfo(
            @RequestParam(value = "orderNo") String orderNo) {
        return orderGoodsBaseService.queryDeliveryInfo(orderNo);
    }


    /**
     * 查询详情
     *
     * @param id
     * @return
     */
    @GetMapping("/queryDetailsById/{id}")
    public ResponseMessage<OrderGoodsDetailVo> queryDetailsById(@PathVariable(value = "id") Integer id) {
        return orderGoodsBaseService.queryDetailsById(id);
    }

//    /**
//     * 查询超过12天未付款的产品订单
//     * @return
//     */
//    @GetMapping(value = "/queryNoPayList")
//    public ResponseMessage<List<OrderGoodsBase>> queryNoPayList() {
//        return orderGoodsBaseService.queryNoPayList();
//    }


    /**
     * 取消订单
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/cancelOrderGoodsBase/{id}")
    public ResponseMessage cancelOrderGoodsBase(@PathVariable(value = "id") Integer id) {
        return orderGoodsBaseService.cancelOrderGoodsBase(id);
    }

    /**
     * 自动确认收货
     */
    @GetMapping(value = "/autoConfirmReceive")
    public void autoConfirmReceive(){
        orderGoodsBaseService.autoConfirmReceive();
    }

    /**
     * 实物订单12小时未付款，取消订单释放库存
     */
    @GetMapping(value = "/cancelOrderGoodsBaseJob")
    public void cancelOrderGoodsBaseJob(){
        orderGoodsBaseService.cancelOrderGoodsBaseJob();
    }

}