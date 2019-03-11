package com.union.aimei.app.api.order.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderComment;
import com.union.aimei.common.vo.order.CommentVo;
import com.union.aimei.common.vo.order.OrderCommentAllVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/7,11:45
 */
public interface OrderCommentService extends SpringCloudBaseService<OrderComment> {
    /**
     * 前端分页查询订单评论
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param orderComment 查询条件
     * @return
     */
    PageInfo<OrderComment> findByPageForFront(Integer pageNo, Integer pageSize, OrderComment orderComment);

    /**
     * 查询美容师订单评论(包含未回复的)
     * @param pageNo
     * @param pageSize
     * @param beauticianId
     * @return
     */
    ResponseMessage<PageInfo<OrderCommentAllVo>> findByBeauticianIdForPage(Integer pageNo, Integer pageSize,int beauticianId);

    /**
     * 提交订单评论
     * @param orderComment 评论内容
     * @param commonImgList 评论图片(最多6张)
     * @return
     */
    ResponseMessage submitOrderComment(OrderComment orderComment, List<String> commonImgList);


    /**
     * 取消订单评论
     * @param memberId
     * @param orderId
     * @return
     */
    ResponseMessage cancelOrderComment(Integer memberId,Integer orderId);


    /**
     * 分页查询店铺或服务评价
     * @param pageNo
     * @param pageSize
     * @param storeId
     * @param productId
     * @param hasImg
     * @param beauticianId
     * @param productEvaluationGrade
     * @param storeEvaluationGrade
     * @param beauticianEvaluationGrade
     * @return
     */
    ResponseMessage<CommentVo> queryCommentPage(Integer pageNo, Integer pageSize, Integer storeId, Integer productId, boolean hasImg,Integer beauticianId, Byte productEvaluationGrade, Byte storeEvaluationGrade,Byte beauticianEvaluationGrade);

    /**
     * 根据订单ID查询评论
     * @param orderId
     * @return
     */
    ResponseMessage<OrderComment> queryByOrderId(Integer orderId);
}