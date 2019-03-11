package com.union.aimei.pc.order.mapper;


import com.union.aimei.common.model.order.OrderReturn;
import com.union.aimei.common.vo.order.OrderRefundListVo;
import com.union.aimei.common.vo.order.OrderRefundQueryVo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;

/**
 * @author GaoWei
 * @describe 
 * @time 2018/1/4,11:27
*/
public interface OrderReturnMapper extends BaseMapper<OrderReturn> {

    /**
     * 查询提交退款的申请，并且没协商的记录
     * @return
     */
    List<OrderReturn> queryAutoRefundRecord();

    /**
     * 通过订单ID查询
     * @param orderId
     * @return
     */
    OrderReturn queryByOrderId(Integer orderId);


    /**
     * 根据条件查询退款订单
     * @param orderRefundQueryVo
     * @return
     */
    List<OrderRefundListVo> queryByConditions(OrderRefundQueryVo orderRefundQueryVo);

    /**
     * 批量修改状态
     */
    void batchUpdateStatus();
}