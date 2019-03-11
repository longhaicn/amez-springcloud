package com.union.aimei.app.api.order.mapper;


import com.union.aimei.common.model.order.OrderCommentImg;
import com.union.common.utils.base.BaseMapper;

import java.util.List;

/**
 * @author GaoWei
 * @describe 
 * @time 2017/12/11,15:06
*/
public interface OrderCommentImgMapper extends BaseMapper<OrderCommentImg> {

    /**
     * 批量添加订单评论图片
     * @param list
     */
    void insertCommentImgBatch(List<OrderCommentImg> list);

    /**
     * 通过订单评论ID查询评论图片
     * @param orderCommentId
     * @return
     */
     List<String> queryOrderCommentImgList(Integer orderCommentId);
}