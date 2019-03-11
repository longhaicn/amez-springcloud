package com.union.aimei.pc.order.service;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderBeautician;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * @author GaoWei
 * @describe 
 * @time 2018/1/4,11:28
*/
public interface OrderBeauticianService extends SpringCloudBaseService<OrderBeautician> {
       /**
        * 前端分页查询订单美容师
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param orderBeautician 查询条件
        * @return 
        */
       PageInfo<OrderBeautician> findByPageForFront(Integer pageNo, Integer pageSize, OrderBeautician orderBeautician);
}