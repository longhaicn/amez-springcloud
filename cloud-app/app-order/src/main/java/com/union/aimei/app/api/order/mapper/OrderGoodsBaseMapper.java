package com.union.aimei.app.api.order.mapper;


import com.union.aimei.common.model.order.OrderGoodsBase;
import com.union.aimei.common.vo.order.OrderGoodsQueryVo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;
import java.util.Map;

/**
  * @author GaoWei
  * @Date 18-8-13 下午1:47
  * @description
  */
public interface OrderGoodsBaseMapper extends BaseMapper<OrderGoodsBase> {


    /**
     * 根据订单编号查询
     * @param orderNo
     * @return
     */
    OrderGoodsBase queryByOrderNo(String orderNo);

    /**
     * 支付成功后修改实物产品订单信息
     * @param map
     * @return
     */
    int updateAfterPay(Map<String,Object> map);

    /**
     * 获取美容师最新添加购买实物订单信息
     * @param beauticianId
     * @return
     */
    OrderGoodsBase queryBeauticianNewestRecord(Integer beauticianId);


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


}