package com.union.aimei.app.api.order.mapper;


import com.union.aimei.common.model.order.OrderRefundsConsultRecord;
import com.union.common.utils.base.BaseMapper;

import java.util.List;

/**
  * @author GaoWei
  * @Date 18-8-13 下午1:47
  * @description
  */
public interface OrderRefundsConsultRecordMapper extends BaseMapper<OrderRefundsConsultRecord> {


    /**
     * 批量修改为失效
     * @param list
     */
    void batchUpdateIsEnabled(List<OrderRefundsConsultRecord> list);

    /**
     * 通过订单编号查询协商记录
     * @param orderNo
     * @return
     */
    List<OrderRefundsConsultRecord> queryByOrderNo(String orderNo);

    /**
     * 通过订单编号寻找最新的协商记录
     * @param orderNo
     * @return
     */
    OrderRefundsConsultRecord queryNewestRecord(String orderNo);
}