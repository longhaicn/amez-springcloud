package com.union.aimei.common.feign.pc.order.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.order.OrderCommentFeign;
import com.union.aimei.common.model.order.OrderComment;
import com.union.common.utils.HystrixResponse;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

/**
 * 订单评论
 *
 * @author GaoWei
 * @time 2018/8/23 10:46
 */
@SuppressWarnings("ALL")
@Component(value = "pc-OrderCommentFeign")
public class OrderCommentApiHystrix implements OrderCommentFeign {

    /**
     * 前端分页查询订单评论
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param orderComment 查询条件
     * @return
     */
    @Override
    public ResponseMessage<PageInfo<OrderComment>> findByPageForFront(Integer pageNo, Integer pageSize, OrderComment orderComment) {
        return HystrixResponse.invokeFail();
    }

    /**
     * 添加订单评论
     *
     * @param orderComment
     * @return
     */
    @Override
    public int insert(OrderComment orderComment) {
        return 0;
    }

    /**
     * 删除订单评论
     *
     * @param id
     * @return
     */
    @Override
    public ResponseMessage deleteById(int id) {
        return HystrixResponse.invokeFail();
    }

    /**
     * 修改订单评论
     *
     * @param orderComment
     * @return
     */
    @Override
    public int edit(OrderComment orderComment) {
        return 0;
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
}