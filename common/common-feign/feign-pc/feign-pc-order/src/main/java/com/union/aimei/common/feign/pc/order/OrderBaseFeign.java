package com.union.aimei.common.feign.pc.order;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.order.hystrix.OrderBaseApiHystrix;
import com.union.aimei.common.model.order.OrderBase;
import com.union.aimei.common.model.order.QueryNewAddOrder;
import com.union.aimei.common.vo.order.*;
import com.union.common.utils.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * 订单
 *
 * @author GaoWei
 * @time 2018/8/23 10:46
 */
@SuppressWarnings("ALL")
@FeignClient(serviceId = "pc-order-service", fallback = OrderBaseApiHystrix.class)
public interface OrderBaseFeign {
    /**
     * 添加订单
     *
     * @param orderBase
     * @return
     */
    @PostMapping(value = "/orderBase/insert")
    int insert(@RequestBody OrderBase orderBase);

    /**
     * 删除订单
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/orderBase/deleteById/{id}")
    int deleteById(@PathVariable(value = "id") int id);

    /**
     * 修改订单
     *
     * @param orderBase
     * @return
     */
    @PutMapping(value = "/orderBase/edit")
    int edit(@RequestBody OrderBase orderBase);

    /**
     * 根据ID查询
     *
     * @param id
     * @returnorderBase
     */
    @GetMapping(value = "/orderBase/queryById/{id}")
    OrderBase queryById(@PathVariable(value = "id") int id);

    /**
     * 前端分页查询订单
     *
     * @param pageNo    分页索引
     * @param pageSize  每页显示数量
     * @param orderBase 查询条件
     * @return
     */
    @PostMapping(value = "/orderBase/front/findByPage")
    PageInfo<OrderBase> findByPageForFront(@RequestParam(value = "pageNo", defaultValue = "0")
                                                   Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10")
                                                   Integer pageSize, @RequestBody OrderBase orderBase);

    /**
     * 根据传入订单ID查询订单详情
     *
     * @param id
     * @return
     */
    @GetMapping("/orderBase/queryOrderDetailsInfO/{id}")
    ResponseMessage<HashMap<String, Object>> queryOrderDetailsInfO(@PathVariable(value = "id") Integer id);

    /**
     * 订单管理-订单列表
     *
     * @param pageSize
     * @param pageNum
     * @param orderListQueryVo
     * @return
     */
    @PostMapping(value = "/orderBase/queryOrderList")
    ResponseMessage<PageInfo<OrderListVo>> queryOrderList(
            @RequestParam(value = "pageNum", defaultValue = "0") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestBody OrderListQueryVo orderListQueryVo);

    /**
     * 查询订单信息包含订单基础，订单服务，订单美容师
     *
     * @param orderId
     * @return
     */
    @GetMapping(value = "/orderBase/queryOrderAllInfo/{orderId}")
    ResponseMessage<OrderInfoVo> queryOrderAllInfo(@PathVariable(value = "orderId") Integer orderId);

    /**
     * 订单管理-查询订单详情
     *
     * @param orderId
     * @return ResponseMessage
     */
    @GetMapping(value = "/orderBase/queryOrderDetail/{orderId}")
    ResponseMessage queryOrderDetailById(@PathVariable(value = "orderId") Integer orderId);

    /**
     * 根据传入订单ID查询订单退款详情
     *
     * @param orderId
     * @return
     */
    @GetMapping(value = "/orderBase/queryOrderRefundDetails/{orderId}")
    ResponseMessage<OrderRefundDetailVo> queryOrderRefundDetails(@PathVariable(value = "orderId") Integer orderId);


    /**
     * 平台审核退款
     *
     * @param orderId
     * @return
     */
    @GetMapping(value = "/orderBase/auditOrderRefundByPlatForm/{orderId}")
    ResponseMessage auditOrderRefundByPlatForm(@PathVariable(value = "orderId") Integer orderId);


    /**
     * 更新已完成的订单
     */
    @GetMapping("/orderBase/updateHasCompleteOrder")
    void updateHasCompleteOrder();

    /**
     * 自动处理申请退款
     *
     * @param list
     */
    @PostMapping(value = "/orderBase/refundOrderTask")
    void refundOrderTask(@RequestBody List<Integer> list);


    /**
     * 七天自动好评
     */
    @GetMapping(value = "/orderBase/autoGoodCommentTask")
    void autoGoodCommentTask();

    /**
     * 查询订单开始一小时
     *
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/orderBase/queryJustPreOneHourOrder")
    ResponseMessage<List<OrderSendAppVo>> queryJustPreOneHourOrder(@RequestParam(value = "id") Integer id);


    /**
     * 查询订单开始前半小时的订单
     *
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/orderBase/queryHalfHourOrder")
    ResponseMessage<List<OrderSendAppVo>> queryHalfHourOrder(@RequestParam(value = "id") Integer id);

    /**
     * 平台处理退款
     *
     * @param orderBase
     * @return
     */
    @PostMapping(value = "/orderBase/auditOrderRefundByPlatForm}")
    ResponseMessage auditOrderRefundByPlatForm(@RequestBody OrderBase orderBase);


    /**
     * 查询正在服务中的订单
     *
     * @return
     */
    @GetMapping(value = "/orderBase/queryInServerList")
    ResponseMessage<List<OrderBase>> queryInServerList();

    /**
     * 查询申请退款超过48小时的订单
     *
     * @return
     */
    @GetMapping(value = "/orderBase/queryRefundOrderBaseHasOver")
    ResponseMessage<List<OrderBase>> queryAutoRefundHasOver();


    /**
     * 统计平台或者店铺一段时间内的订单数量及成交金额
     *
     * @param type    统计类型0平台，1店铺
     * @param storeId 店铺ID
     * @param days    天数
     * @return
     */
    @GetMapping(value = "/orderBase/countOrderInfoByDays")
    ResponseMessage<HashMap<String, Integer>> countOrderInfoByDays(
            @RequestParam(value = "type") Integer type,
            @RequestParam(value = "storeId", required = false) Integer storeId,
            @RequestParam(value = "days") Integer days);


    /**
     * 统计营业金额
     *
     * @param statisticsOrderVo
     * @return
     */
    @PostMapping(value = "/orderBase/sumOrderAmountByStoreIdAndDays")
    ResponseMessage<Integer> sumOrderAmountByStoreIdAndDays(@RequestBody StatisticsOrderVo statisticsOrderVo);

    /**
     * 新增服务订单
     *
     * @param queryNewAddOrder
     * @return
     */
    @PostMapping(value = "/orderBase/newAddOrderNums")
    ResponseMessage<Integer> newAddOrderNums(@RequestBody QueryNewAddOrder queryNewAddOrder);


    /**
     * 自动处理申请退款
     */
    @PostMapping(value = "/orderBase/refundOrderTask")
    void refundOrderTask();


    /**
     * 订单完成定时任务
     */
    @GetMapping(value = "/orderBase/completeUpdateJob")
    void completeUpdateJob();


    /**
     * 订单开始半小时提醒客户
     */
    @GetMapping(value = "/orderBase/notifyPreHalfHourJob")
    void notifyPreHalfHourJob();
}