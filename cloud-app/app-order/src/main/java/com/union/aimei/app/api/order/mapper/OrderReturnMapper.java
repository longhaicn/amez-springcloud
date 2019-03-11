package com.union.aimei.app.api.order.mapper;


import com.union.aimei.common.model.order.OrderReturn;
import com.union.aimei.common.vo.order.RefundObject;
import com.union.common.utils.base.BaseMapper;

import java.util.List;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/7,11:41
 */
public interface OrderReturnMapper extends BaseMapper<OrderReturn> {

    /**
     * 根据订单编号查询退款申请次数
     * @param orderNo
     * @return
     */
    int countRefundByOrderNo(String orderNo);

    /**
     *  批量修改is_enabled为0
     * @param list
     */
    void batchUpdateState(List<OrderReturn> list);

    /**
     * 根据订单编号查询
     * @param orderNo
     * @return
     */
    OrderReturn selectByOrderNo(String orderNo);

    /**
     * 查询会员最新的退款记录
     * @param memberId
     * @return
     */
    OrderReturn queryNewestRecordByMemberId(Integer memberId);

    /**
     * 查询申请退款对象
     * @param orderNo
     * @return
     */
    RefundObject queryApplyRefundObjct(String orderNo);
}