package com.union.aimei.pc.order.mapper;


import com.union.aimei.common.model.order.OrderProduct;
import com.union.common.utils.base.BaseMapper;

/**
 * @author GaoWei
 * @describe 
 * @time 2018/1/4,11:27
*/
public interface OrderProductMapper extends BaseMapper<OrderProduct> {

    /**
     * 通过订单ID查询
     * @param orderId
     * @return
     */
    OrderProduct queryByOrderId(Integer orderId);
}