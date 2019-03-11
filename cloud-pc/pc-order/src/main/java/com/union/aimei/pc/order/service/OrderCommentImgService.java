package com.union.aimei.pc.order.service;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.order.OrderCommentImg;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * @author GaoWei
 * @describe 
 * @time 2018/1/4,11:28
*/
public interface OrderCommentImgService extends SpringCloudBaseService<OrderCommentImg> {
       /**
        * 前端分页查询订单评论图片表
        * @param pageNo  分页索引
        * @param pageSize  每页显示数量
        * @param orderCommentImg 查询条件
        * @return 
        */
       PageInfo<OrderCommentImg> findByPageForFront(Integer pageNo, Integer pageSize, OrderCommentImg orderCommentImg);
}