package com.union.aimei.app.api.order.mapper;


import com.union.aimei.common.model.order.OrderProduct;
import com.union.common.utils.base.BaseMapper;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/7,11:41
 */
public interface OrderProductMapper extends BaseMapper<OrderProduct> {
    /**
     * 通过订单ID查询
     * @param orderId
     * @return
     */
    OrderProduct queryByOrderId(Integer orderId);

    /**
     * 查询商品ID
     * @param orderNo
     * @return
     */
    OrderProduct queryByOrderNo(String orderNo);
}