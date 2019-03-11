package com.union.aimei.common.feign.app.order.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.order.OrderCommentFeign;
import com.union.aimei.common.model.order.OrderComment;
import com.union.aimei.common.vo.order.CommentVo;
import com.union.aimei.common.vo.order.OrderCommentAllVo;
import com.union.aimei.common.vo.order.OrderCommentVo;
import com.union.aimei.common.vo.order.SubmitOrderComment;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author GaoWei
 * @describe 
 * @time 2018/1/19,13:21
*/
@Component(value = "app-OrderCommentFeign")
public class OrderCommentApiHystrix implements OrderCommentFeign {
    @Override
    public PageInfo<OrderComment> findByPageForFront(Integer pageNo, Integer pageSize, OrderComment orderComment) {
        return new PageInfo<>();
    }

    @Override
    public ResponseMessage<PageInfo<OrderCommentAllVo>> findByBeauticianIdForPage(Integer pageNo, Integer pageSize, int beauticianId) {
        return HystrixResponse.invokeFail();
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnorderComment
     */
    @Override
    public OrderComment queryById(int id) {
        return null;
    }

    @Override
    public ResponseMessage<List<OrderCommentVo>> getOrderCommentAndImg(Integer orderId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage insert(SubmitOrderComment submitOrderComment) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<OrderComment> queryByOrderId(Integer orderId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage cancelOrderComment(Integer memberId, Integer orderId) {
        return HystrixResponse.invokeFail();
    }

    @Override
    public ResponseMessage<CommentVo> queryCommentPage(Integer pageNo, Integer pageSize, Integer storeId, Integer productId, boolean hasImg, Integer beauticianId, Byte productEvaluationGrade, Byte storeEvaluationGrade,Byte beauticianEvaluateGrade) {
        return HystrixResponse.invokeFail();
    }
}