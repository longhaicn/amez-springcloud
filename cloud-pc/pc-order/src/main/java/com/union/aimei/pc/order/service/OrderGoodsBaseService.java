package com.union.aimei.pc.order.service;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderGoodsBase;
import com.union.aimei.common.vo.order.LogisticsInfoVo;
import com.union.aimei.common.vo.order.OrderGoodsDetailVo;
import com.union.aimei.common.vo.order.OrderGoodsQueryVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;

/**
  * @author GaoWei
  * @Date 18-8-13 下午2:57
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
        * 根据条件查询实物订单列表
        * @param pageNo
        * @param pageSize
        * @param orderGoodsQueryVo
        * @return
        */
       PageInfo<OrderGoodsDetailVo> queryByPage(Integer pageNo, Integer pageSize, OrderGoodsQueryVo orderGoodsQueryVo);

        /**
         * 发货
         * @param orderNo
         * @param companyCode
         * @param companyName
         * @param deliveryOrderNo
         * @return ResponseMessage
         */
       ResponseMessage deliverGoods(String orderNo,String companyCode,String companyName,String deliveryOrderNo);

        /**
         * 查询订单物流详情
         * @param orderNo
         * @return
         */
       ResponseMessage<LogisticsInfoVo> queryDeliveryInfo(String orderNo);


        /**
         * 查询详情
         * @param id
         * @return
         */
       ResponseMessage<OrderGoodsDetailVo> queryDetailsById(Integer id);


        /**
         * 取消订单
         * @param id
         * @return
         */
        ResponseMessage cancelOrderGoodsBase(Integer id);

        /**
         * 自动确认收货
         */
        void autoConfirmReceive();

        /**
         * 实物订单12小时未付款，取消订单释放库存
         */
        void cancelOrderGoodsBaseJob();




}