package com.union.aimei.app.api.order.mapper;


import com.union.aimei.common.model.order.OrderComment;
import com.union.aimei.common.vo.order.CommentVo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/7,11:38
 */
public interface OrderCommentMapper extends BaseMapper<OrderComment> {

    /**
     * 根据订单ID查询
     * @param orderId
     * @return
     */
    OrderComment queryByOrderId(Integer orderId);

    /**
     * 查询用户最新添加记录
     * @param memberId
     * @return
     */
    OrderComment queryNewestComment(Integer memberId);

    /**
     * 根据订单ID及回复查询订单
     * @param map
     * @return
     */
    OrderComment queryByOrderIdAndOperType(Map<String,Object> map);

    /**
     * 根据美容师ID查询
     * @param beauticianId
     * @return
     */
    List<OrderComment> queryByBeauticianId(int beauticianId);

    /**
     * 查询订单评论次数
     * @param map
     * @return
     */
    int queryCommentCount(Map<String,Object> map);

    /**
     * 查询店铺评价数量
     * @param orderComment
     * @return
     */
    CommentVo queryStoreCountByConditions(OrderComment orderComment);

    /**
     * 查询项目评价数量
     * @param orderComment
     * @return
     */
    CommentVo queryProductCountByCondition(OrderComment orderComment);

    /**
     * 查询美容师评价数量
     * @param orderCommet
     * @return
     */
    CommentVo queryBeauticianCountByConditions(OrderComment orderCommet);


    /**
     * 查询订单图片
     * @param commentId
     * @return
     */
    List<String> queryOrderCommentImgList(int commentId);



}