package com.union.aimei.app.api.order.service;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderReturn;
import com.union.aimei.common.vo.order.RefundObject;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/7,11:49
 */
public interface OrderReturnService extends SpringCloudBaseService<OrderReturn> {
    /**
     * 前端分页查询退换货单
     *
     * @param pageNo      分页索引
     * @param pageSize    每页显示数量
     * @param orderReturn 查询条件
     * @return
     */
    ResponseMessage<PageInfo<OrderReturn>> findByPageForFront(Integer pageNo, Integer pageSize, OrderReturn orderReturn);


    /**
     * 通过订单编号查询退款记录
     * @param orderNo
     * @return
     */
    ResponseMessage<OrderReturn> queryByOrderNo(String orderNo);

    /**
     * 通过订单编号查询申请退款对象
     * @param orderNo
     * @return
     */
    ResponseMessage<RefundObject> queryRefundObject(String orderNo);
}