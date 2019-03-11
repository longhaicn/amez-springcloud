package com.union.aimei.pc.order.mapper;


import com.union.aimei.common.model.order.OrderBeautician;
import com.union.common.utils.base.BaseMapper;

/**
 * @author GaoWei
 * @describe
 * @time 2018/1/4,11:25
*/
public interface OrderBeauticianMapper extends BaseMapper<OrderBeautician> {

    /**
     * 根据订单ID查询订单美容师信息
     * @param orderId
     * @return
     */
    OrderBeautician queryByOrderId(Integer orderId);
}