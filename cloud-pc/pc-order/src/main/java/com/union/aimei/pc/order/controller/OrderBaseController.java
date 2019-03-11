package com.union.aimei.pc.order.controller;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderBase;
import com.union.aimei.common.model.order.QueryNewAddOrder;
import com.union.aimei.common.vo.order.*;
import com.union.aimei.pc.order.service.OrderBaseService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author GaoWei
 * @Date 18-8-13 下午2:55
 * @description
 */
@Api(tags = "订单")
@RestController
@RequestMapping(value = "orderBase")
public class OrderBaseController {
    @Resource
    private OrderBaseService orderBaseService;


    @PostMapping("/insert")
    public int insert(@RequestBody OrderBase orderBase) {
        return this.orderBaseService.addObj(orderBase);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable(value = "id") int id) {
        return this.orderBaseService.deleteObjById(id);
    }

    @PutMapping("/edit")
    public int edit(@RequestBody OrderBase orderBase) {
        return this.orderBaseService.modifyObj(orderBase);
    }

    @GetMapping("/queryById/{id}")
    public OrderBase queryById(@PathVariable(value = "id") int id) {
        return this.orderBaseService.queryObjById(id);
    }

    /**
     * 根据传入订单ID查询订单详情
     *
     * @param id
     * @return
     */
    @GetMapping("/queryOrderDetailsInfO/{id}")
    public ResponseMessage<HashMap<String, Object>> queryOrderDetailsInfO(@PathVariable(value = "id") Integer id) {
        return orderBaseService.getOrderDetailsInfo(id);
    }

    /**
     * 根据传入订单ID查询订单退款详情
     *
     * @param orderId
     * @return
     */
    @GetMapping(value = "queryOrderRefundDetails/{orderId}")
    public ResponseMessage<OrderRefundDetailVo> queryOrderRefundDetails(@PathVariable(value = "orderId") Integer orderId) {
        return orderBaseService.queryOrderRefundDetails(orderId);
    }

    /**
     * 更新已完成的订单服务状态
     *
     * @return
     */
    @GetMapping("/updateHasCompleteOrder")
    public void updateHasCompleteOrder() {
        orderBaseService.updateHasCompleteOrder();
    }

    /**
     * 订单管理-订单列表
     *
     * @return
     */
    @PostMapping(value = "queryOrderList")
    public ResponseMessage<PageInfo<OrderListVo>> queryOrderList(
            @RequestParam(value = "pageNum", defaultValue = "0") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestBody OrderListQueryVo orderListQueryVo) {
        return orderBaseService.queryOrderList(pageNum, pageSize, orderListQueryVo);
    }

    /**
     * 平台审核退款
     *
     * @param orderId
     * @return
     */
    @GetMapping(value = "/auditOrderRefundByPlatForm/{orderId}")
    public ResponseMessage auditOrderRefundByPlatForm(@PathVariable(value = "orderId") Integer orderId) {
        return orderBaseService.auditOrderRefundByPlatForm(orderId);
    }

    /**
     * 订单管理-查询订单详情
     *
     * @return
     */
    @GetMapping(value = "/queryOrderDetail/{orderId}")
    public ResponseMessage queryOrderDetail(@PathVariable(value = "orderId") Integer orderId) {
        return orderBaseService.queryOrderDetailById(orderId);
    }


    @GetMapping(value = "/queryOrderAllInfo/{orderId}")
    public ResponseMessage<OrderInfoVo> queryOrderAllInfo(@PathVariable(value = "orderId") Integer orderId) {
        return orderBaseService.queryOrderAllInfo(orderId);
    }


    /**
     * 退款订单处理
     */
    @PostMapping(value = "/refundOrderTask")
    public void refundOrderTask() {
        orderBaseService.refundOrderTask();
    }

    /**
     * 七天自动好评
     */
    @GetMapping(value = "/autoGoodCommentTask")
    public void autoGoodCommentTask() {
        orderBaseService.autoGoodCommentTask();
    }

    /**
     * 订单完成定时任务
     */
    @GetMapping(value = "/completeUpdateJob")
    public void completeUpdateJob() {
        orderBaseService.completeUpdateJob();
    }


    /**
     * 订单开始半小时提醒客户
     */
    @GetMapping(value = "/notifyPreHalfHourJob")
    public void notifyPreHalfHourJob() {
        orderBaseService.notifyPreHalfHourJob();
    }


    /**
     * 统计营业金额
     *
     * @param statisticsOrderVo
     * @return
     */
    @PostMapping(value = "/sumOrderAmountByStoreIdAndDays")
    public ResponseMessage<Integer> sumOrderAmountByStoreIdAndDays(@RequestBody StatisticsOrderVo statisticsOrderVo) {
        return orderBaseService.sumOrderAmountByStoreIdAndDays(statisticsOrderVo);
    }

    /**
     * 新增服务订单
     *
     * @return
     */
    @PostMapping(value = "/newAddOrderNums")
    public ResponseMessage<Integer> newAddOrderNums(
            @RequestBody QueryNewAddOrder queryNewAddOrder) {
        return orderBaseService.newAddOrderNums(queryNewAddOrder);
    }

    /**
     * 统计平台或者店铺一段时间内的订单数量及成交金额
     *
     * @param type    统计类型0平台，1店铺
     * @param storeId 店铺ID
     * @param days    天数
     * @return
     */
    @GetMapping(value = "/countOrderInfoByDays")
    public ResponseMessage<HashMap<String, Integer>> countOrderInfoByDays(
            @RequestParam(value = "type") Integer type,
            @RequestParam(value = "storeId", required = false) Integer storeId,
            @RequestParam(value = "days") Integer days) {
        return this.orderBaseService.countOrderInfoByDays(type, storeId, days);
    }

}