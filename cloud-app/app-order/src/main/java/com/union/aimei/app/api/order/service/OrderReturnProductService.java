package com.union.aimei.app.api.order.service;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderReturnProduct;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/7,11:51
 */
public interface OrderReturnProductService extends SpringCloudBaseService<OrderReturnProduct> {
    /**
     * 前端分页查询退换货的申请明细
     *
     * @param pageNo             分页索引
     * @param pageSize           每页显示数量
     * @param orderReturnProduct 查询条件
     * @return
     */
    PageInfo<OrderReturnProduct> findByPageForFront(Integer pageNo, Integer pageSize, OrderReturnProduct orderReturnProduct);
}