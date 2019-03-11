package com.union.aimei.app.api.order.service;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderGoodsBase;
import com.union.aimei.common.vo.order.LogisticsInfoVo;
import com.union.aimei.common.vo.order.OrderGoodsDetailVo;
import com.union.aimei.common.vo.order.OrderGoodsQueryVo;
import com.union.aimei.common.vo.order.SubmitProductGoodsVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.HashMap;

/**
  * @author GaoWei
  * @Date 18-8-13 下午1:47
  * @description
  */
public interface OrderGoodsBaseService extends SpringCloudBaseService<OrderGoodsBase> {
       /**
        * 前端分页查询实物订单表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param orderGoodsBase 查询条件
        * @return 
        */
       PageInfo<OrderGoodsBase> findByPageForFront(Integer pageNo, Integer pageSize, OrderGoodsBase orderGoodsBase);


       /**
        * 查询订单编号
        * @param orderNo
        * @return
        */
       ResponseMessage<OrderGoodsBase> queryByOrderNo(String orderNo);


       /**
        * 提交实物产品订单
        * @param submitProductGoodsVo
        * @return
        */
       ResponseMessage<HashMap<String,Object>> submitGoodsOrderBase(SubmitProductGoodsVo submitProductGoodsVo);

       /**
        * 支付成功修改实物产品订单信息
        * @param orderNo
        * @param payType
        * @param tradeNo
        * @param amountPay
        * @return
        */
       ResponseMessage updateOrderGoodsBaseInfoAfterPay(String orderNo,Integer payType,String tradeNo,Integer amountPay);


       /**
        * 根据条件查询实物订单列表
        * @param pageNo
        * @param pageSize
        * @param orderGoodsQueryVo
        * @return
        */
       PageInfo<OrderGoodsDetailVo> queryByPage(Integer pageNo, Integer pageSize, OrderGoodsQueryVo orderGoodsQueryVo);


       /**
        * 查询订单物流详情
        * @param orderNo
        * @return
        */
       ResponseMessage<LogisticsInfoVo> queryDeliveryInfo(String orderNo);

        /**
         * 取消订单
         * @param id
         * @return
         */
       ResponseMessage cancelOrderGoodsBase(Integer id);

       /**
        * 确认收货
        * @param orderGoodsId
        * @return
        */
       ResponseMessage confirmReceiveGoods(Integer orderGoodsId);
}