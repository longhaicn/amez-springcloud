package com.union.aimei.pc.order.service;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderReturn;
import com.union.aimei.common.vo.order.OrderRefundListVo;
import com.union.aimei.common.vo.order.OrderRefundQueryVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * @author GaoWei
 * @describe 
 * @time 2018/1/4,11:29
*/
public interface OrderReturnService extends SpringCloudBaseService<OrderReturn> {
       /**
        * 前端分页查询退换货单
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param orderReturn 查询条件
        * @return 
        */
       PageInfo<OrderReturn> findByPageForFront(Integer pageNo, Integer pageSize, OrderReturn orderReturn);

       /**
        * 通过订单ID查询
        * @param orderId
        * @return
        */
       ResponseMessage<OrderReturn> queryByOrderId(Integer orderId);


       /**
        * 分页查询 退款订单信息
        * @param pageNo
        * @param pageSize
        * @param orderRefundQueryVo
        * @return
        */
       ResponseMessage<PageInfo<OrderRefundListVo>> queryForPage(Integer pageNo, Integer pageSize, OrderRefundQueryVo orderRefundQueryVo);
}