package com.union.aimei.app.api.order.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderProductConsumeGoodsRecord;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.HashMap;

/**
  * @author GaoWei
  * @Date 18-8-13 下午1:48
  * @description
  */
public interface OrderProductConsumeGoodsRecordService extends SpringCloudBaseService<OrderProductConsumeGoodsRecord> {
       /**
        * 前端分页查询订单-服务消耗实物产品记录表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param orderProductConsumeGoodsRecord 查询条件
        * @return 
        */
       PageInfo<OrderProductConsumeGoodsRecord> findByPageForFront(Integer pageNo, Integer pageSize, OrderProductConsumeGoodsRecord orderProductConsumeGoodsRecord);

        /**
         * 查询店铺消耗明细
         * @param pageNo
         * @param pageSize
         * @param storeId
         * @param productId
         * @return
         */
       ResponseMessage<PageInfo<HashMap<String,Object>>> queryStoreConsumeDetail(Integer pageNo,Integer pageSize,Integer storeId,Integer productId);

        /**
         * 查询美容师消耗明细
         * @param pageNo
         * @param pageSize
         * @param beauticianId
         * @param productId
         * @return
         */
       ResponseMessage<PageInfo<HashMap<String,Object>>> queryBeauticianConsumeDetail(Integer pageNo,Integer pageSize,Integer beauticianId,Integer productId);

        /**
         * 根据项目ID查询
         * @param productId
         * @return
         */
       ResponseMessage<OrderProductConsumeGoodsRecord> queryByProductId(int productId);
}