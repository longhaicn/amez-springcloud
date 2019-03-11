package com.union.aimei.common.feign.pc.order.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.order.OrderCommentImgFeign;
import com.union.aimei.common.model.order.OrderCommentImg;
import org.springframework.stereotype.Component;

/**
 * 订单评论图片
 *
 * @author GaoWei
 * @time 2018/8/23 10:46
 */
@SuppressWarnings("ALL")
@Component(value = "pc-OrderCommentImgFeign")
public class OrderCommentImgApiHystrix implements OrderCommentImgFeign {

    /**
     * 前端分页查询订单评论图片表
     *
     * @param pageNo          分页索引
     * @param pageSize        每页显示数量
     * @param orderCommentImg 查询条件
     * @return
     */
    @Override
    public PageInfo<OrderCommentImg> findByPageForFront(Integer pageNo, Integer pageSize, OrderCommentImg orderCommentImg) {
        return null;
    }

    /**
     * 添加订单评论图片表
     *
     * @param orderCommentImg
     * @return
     */
    @Override
    public int insert(OrderCommentImg orderCommentImg) {
        return 0;
    }

    /**
     * 删除订单评论图片表
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改订单评论图片表
     *
     * @param orderCommentImg
     * @return
     */
    @Override
    public int edit(OrderCommentImg orderCommentImg) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnorderCommentImg
     */
    @Override
    public OrderCommentImg queryById(int id) {
        return null;
    }
}