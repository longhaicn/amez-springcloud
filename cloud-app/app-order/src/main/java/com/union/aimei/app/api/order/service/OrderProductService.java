package com.union.aimei.app.api.order.service;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderProduct;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/7,11:51
 */
public interface OrderProductService extends SpringCloudBaseService<OrderProduct> {
    /**
     * 前端分页查询订单--商品--关联
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param orderProduct 查询条件
     * @return
     */
    PageInfo<OrderProduct> findByPageForFront(Integer pageNo, Integer pageSize, OrderProduct orderProduct);

    /**
     * 查询商品ID
     * @param orderNo
     * @return
     */
    ResponseMessage queryByOrderNo(String orderNo);
}