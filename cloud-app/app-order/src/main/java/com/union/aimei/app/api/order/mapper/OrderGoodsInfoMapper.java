package com.union.aimei.app.api.order.mapper;


import com.union.aimei.common.model.order.OrderGoodsInfo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;

/**
  * @author GaoWei
  * @Date 18-8-13 下午1:47
  * @description
  */
public interface OrderGoodsInfoMapper extends BaseMapper<OrderGoodsInfo> {


    /**
     * 批量添加实物订单商品信息
     * @param list
     */
    void batchInsert(List<OrderGoodsInfo> list);


    /**
     * 根据订单ID查询订单商品信息
     * @param orderGoodsId
     * @return
     */
    List<OrderGoodsInfo> queryByOrderGoodsId(Integer orderGoodsId);
}