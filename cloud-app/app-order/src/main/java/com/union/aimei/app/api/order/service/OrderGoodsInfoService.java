package com.union.aimei.app.api.order.service;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderGoodsInfo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;
/**
  * @author GaoWei
  * @Date 18-8-13 下午1:48
  * @description
  */
public interface OrderGoodsInfoService extends SpringCloudBaseService<OrderGoodsInfo> {
       /**
        * 前端分页查询实物订单产品信息表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param orderGoodsInfo 查询条件
        * @return 
        */
       PageInfo<OrderGoodsInfo> findByPageForFront(Integer pageNo, Integer pageSize, OrderGoodsInfo orderGoodsInfo);

       /**
        * 通过订单ID查询
        * @param orderId
        * @return
        */
       ResponseMessage<List<OrderGoodsInfo>> queryByOrderId(Integer orderId);
}