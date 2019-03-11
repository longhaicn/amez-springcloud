package com.union.aimei.product.service;

import com.union.aimei.common.model.product.ProductActivity;
import com.union.aimei.common.vo.product.app.ProductActivityByDetailResVo;
import com.union.common.utils.ResponseMessage;

import java.util.List;

/**
 * 项目活动
 *
 * @author liurenkai
 * @time 2018/5/14 10:38
 */
public interface ProductActivityService {

    /**
     * 查询精选项目活动
     *
     * @param cityId 城市ID
     * @return
     */
    ResponseMessage<List<ProductActivity>> findListBySelectV111(int cityId);

    /**
     * 项目活动详情
     *
     * @param id ID
     * @return
     */
    ResponseMessage<ProductActivityByDetailResVo> detailV111(int id);

}