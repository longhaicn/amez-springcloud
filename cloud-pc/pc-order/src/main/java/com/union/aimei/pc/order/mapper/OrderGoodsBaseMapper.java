package com.union.aimei.pc.order.mapper;

import com.union.aimei.common.model.order.OrderGoodsBase;
import com.union.aimei.common.vo.order.OrderGoodsQueryVo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;

/**
  * @author GaoWei
  * @Date 18-8-13 下午2:56
  * @description
  */
public interface OrderGoodsBaseMapper extends BaseMapper<OrderGoodsBase> {

    /**
     * 根据传入条件查询
     * @param orderGoodsQueryVo
     * @return
     */
    List<OrderGoodsBase> queryByConditions(OrderGoodsQueryVo orderGoodsQueryVo);

    /**
     * 通过订单编码查询
     * @param orderNo
     * @return
     */
    OrderGoodsBase queryForOrderNo(String orderNo);

    /**
     * 查询超过12天未付款的订单
     * @return
     */
    List<OrderGoodsBase> queryListPassTwDays();
}