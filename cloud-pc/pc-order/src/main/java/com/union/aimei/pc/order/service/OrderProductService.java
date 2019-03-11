package com.union.aimei.pc.order.service;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderProduct;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * @author GaoWei
 * @describe 
 * @time 2018/1/4,11:28
*/
public interface OrderProductService extends SpringCloudBaseService<OrderProduct> {
       /**
        * 前端分页查询订单--商品--关联
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param orderProduct 查询条件
        * @return 
        */
       PageInfo<OrderProduct> findByPageForFront(Integer pageNo, Integer pageSize, OrderProduct orderProduct);
}