package com.union.aimei.pc.order.service;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderGoodsInfo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;

/**
  * @author GaoWei
  * @Date 18-8-13 下午2:57
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
        * 通过产品ID查询产品信息集合
        * @param orderGoodsId
        * @return
        */
       ResponseMessage<List<OrderGoodsInfo>> queryByOrderGoodsId(Integer orderGoodsId);
}