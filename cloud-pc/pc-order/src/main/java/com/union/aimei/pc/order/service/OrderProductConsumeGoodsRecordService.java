package com.union.aimei.pc.order.service;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderProductConsumeGoodsRecord;
import com.union.common.utils.base.SpringCloudBaseService;

/**
  * @author GaoWei
  * @Date 18-8-13 下午2:57
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
}