package com.union.aimei.pc.order.service;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderComment;
import com.union.aimei.common.vo.order.OrderCommentAllVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * @author GaoWei
 * @describe 
 * @time 2018/1/4,11:27
*/
public interface OrderCommentService extends SpringCloudBaseService<OrderComment> {
       /**
        * 前端分页查询订单评论
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param orderComment 查询条件
        * @return 
        */
       PageInfo<OrderComment> findByPageForFront(Integer pageNo, Integer pageSize, OrderComment orderComment);

       /**
        * 取消订单评论
        * @param orderId
        * @return
        */
       ResponseMessage cancelOrderComment(int orderId);
}