package com.union.aimei.pc.order.mapper;


import com.union.aimei.common.model.order.OrderComment;
import com.union.common.utils.base.BaseMapper;

import java.util.Date;
import java.util.List;

/**
 * @author GaoWei
 * @describe 
 * @time 2018/1/4,11:27
*/
public interface OrderCommentMapper extends BaseMapper<OrderComment> {



    /**
     * 根据订单ID查询
     * @param orderId
     * @return
     */
    OrderComment queryByOrderId(Integer orderId);

    /**
     * 查询订单评论时间
     * @param orderId
     * @return
     */
    Date queryOrderCommentTime(Integer orderId);

    /**
     * 查询订单图片
     * @param commentId
     * @return
     */
    List<String> queryOrderCommentImgList(int commentId);
}