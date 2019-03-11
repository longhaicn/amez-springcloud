package com.union.aimei.pc.order.service;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderRefundsConsultRecord;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;

/**
  * @author GaoWei
  * @Date 18-8-13 下午2:57
  * @description
  */
public interface OrderRefundsConsultRecordService extends SpringCloudBaseService<OrderRefundsConsultRecord> {
       /**
        * 前端分页查询服务订单-退款协商记录表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param orderRefundsConsultRecord 查询条件
        * @return 
        */
       PageInfo<OrderRefundsConsultRecord> findByPageForFront(Integer pageNo, Integer pageSize, OrderRefundsConsultRecord orderRefundsConsultRecord);

       /**
        * 通过订单ID查询协商记录
        * @param orderId
        * @return
        */
       ResponseMessage<List<OrderRefundsConsultRecord>> queryByOrderId(Integer orderId);
}