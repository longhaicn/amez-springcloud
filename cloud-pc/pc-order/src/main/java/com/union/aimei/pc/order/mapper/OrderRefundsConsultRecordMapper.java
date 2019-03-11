package com.union.aimei.pc.order.mapper;


import com.union.aimei.common.model.order.OrderRefundsConsultRecord;
import com.union.common.utils.base.BaseMapper;

import java.util.List;

/**
 * @author GaoWei
 * @describe 
 * @time 2018/3/20,13:51
*/
public interface OrderRefundsConsultRecordMapper extends BaseMapper<OrderRefundsConsultRecord> {


    /**
     * 批量插入
     * @param list
     */
    void batchInsert(List<OrderRefundsConsultRecord> list);


    /**
     * 通过订单ID查询
     * @param orderId
     * @return
     */
    List<OrderRefundsConsultRecord> queryByOrderId(Integer orderId);

    /**
     * 通过订单退款ID查询
     * @param orderId
     * @return
     */
    List<OrderRefundsConsultRecord> queryByOrderReturnId(Integer orderId);
}