package com.union.aimei.pc.order.mapper;


import com.union.aimei.common.model.order.OrderBase;
import com.union.aimei.common.model.order.OrderReturn;
import com.union.aimei.common.vo.order.OrderListQueryVo;
import com.union.aimei.common.vo.order.OrderListVo;
import com.union.aimei.common.vo.order.OrderSendAppVo;
import com.union.common.utils.base.BaseMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GaoWei
 * @describe 
 * @time 2018/1/4,11:27
*/
public interface OrderBaseMapper extends BaseMapper<OrderBase> {

    /**
     * 查询订单管理列表
     * @param orderListQueryVo
     * @return List<OrderListVo>
     */
    List<OrderListVo> queryOrderList(OrderListQueryVo orderListQueryVo);

    /**
     * 通过订单ID查询订单详情
     * @param orderId
     * @return
     */
    Map<String,Object> queryOrderDetailById(Integer orderId);

    /**
     * 更改订单状态从服务中到服务完成
     * 批量更改订单状态
     */
    void batchUpdateOrderStatus();



    /**
     * 查询未评价的订单
     * @return
     */
    List<OrderBase> queryHasNoCommentOrderBase();

    /**
     * 查询已完成的订单
     * @return
     */
    List<OrderBase> queryHasCompleteList();

    /**
     * 查询订单开始前一小时的订单
     * @return
     */
    List<OrderSendAppVo> queryPreOneHourOrders();

    /**
     * 查询订单开始前半小时的订单
     * @return
     */
    List<OrderSendAppVo> queryPreHalfHourOrders();

    /**
     * 查询订单已完成的
     * @return
     */
    List<OrderSendAppVo> queryHasCompleteOrderList();

    /**
     * 通过订单ID查询需要推送的信息
     * @param orderId
     * @return
     */
    OrderSendAppVo queryById(int orderId);

    /**
     * 查询申请退款已经达到48小时的订单
     * @return
     */
    List<OrderBase> queryAutoRefundHasOver();

    /**
     * 通过天数统计订单数量
     * @param ma
     * @return
     */
    HashMap<String,Integer> countByDays(Map<String,Object> ma);


    /**
     * 统计店铺营业额
     * @param map
     * @return
     */
    Integer countStoreTurnoverByDays(Map<String,Object> map);

    /**
     * 统计平台营业额
     * @param ma
     * @return
     */
    Integer countPlatformTurnoverByDays(Map<String,Object> ma);

    /**
     * 统计店铺新增订单
     * @param map
     * @return
     */
    Integer countStoreNewAddOrderNums(Map<String,Object> map);
}