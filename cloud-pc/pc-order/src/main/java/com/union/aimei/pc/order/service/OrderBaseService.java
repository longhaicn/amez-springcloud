package com.union.aimei.pc.order.service;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderBase;
import com.union.aimei.common.model.order.QueryNewAddOrder;
import com.union.aimei.common.vo.order.*;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.HashMap;

/**
 * @author GaoWei
 * @describe 
 * @time 2018/1/4,11:28
*/
public interface OrderBaseService extends SpringCloudBaseService<OrderBase> {

       /**
        * 根据订单ID查询订单详情，包括订单基础信息，订单美容师，订单商品信息
        * @param id
        * @return
        */
       ResponseMessage<HashMap<String,Object>> getOrderDetailsInfo(Integer id);

    /**
     * 查询订单列表
     * @param pageNo
     * @param pageSize
     * @param orderListQueryVo
     * @return
     */
       ResponseMessage<PageInfo<OrderListVo>> queryOrderList(Integer pageNo, Integer pageSize, OrderListQueryVo orderListQueryVo);

       /**
        * 订单管理，查询订单详情
        * @param orderId
        * @return
        */
       ResponseMessage queryOrderDetailById(Integer orderId);


        /**
         * 查询订单信息包含订单美容师，订单服务
         * @param orderId
         * @return
         */
       ResponseMessage<OrderInfoVo> queryOrderAllInfo(Integer orderId);


        /**
         * 查询订单退款详情
         *
         * @param orderId
         * @return
         */
        ResponseMessage<OrderRefundDetailVo> queryOrderRefundDetails(Integer orderId);

        /**
         * 平台处理退款
         * @param orderId
         * @return
         */
       ResponseMessage auditOrderRefundByPlatForm(Integer orderId);

       /**
        * 更新已完成的订单状态定时任务
        */
       void updateHasCompleteOrder();


       /**
        *  退款订单处理定时任务
        */
       void refundOrderTask();


        /**
         *  七天自动好评定时
         */
        void autoGoodCommentTask();

        /**
         * 提前半小时通知客户
         */
        void notifyPreHalfHourJob();


        /**
         * 项目订单完成后更新订单状态，更新交易流水状态
         */
        void completeUpdateJob();

    /**
     * 统计店铺营业金额
     * @param statisticsOrderVo
     * @return
     */
    ResponseMessage<Integer> sumOrderAmountByStoreIdAndDays(StatisticsOrderVo statisticsOrderVo);

    /**
     * 统计新增订单数量
     * @param queryNewAddOrder
     * @return
     */
    ResponseMessage<Integer> newAddOrderNums(QueryNewAddOrder queryNewAddOrder);

    /**
     * 统计平台或者店铺一段时间内的订单数量及成交金额
     *
     * @param type    统计类型0平台，1店铺
     * @param storeId 店铺ID
     * @param days    天数
     * @return
     */
    ResponseMessage<HashMap<String, Integer>> countOrderInfoByDays(Integer type, Integer storeId, Integer days);
}