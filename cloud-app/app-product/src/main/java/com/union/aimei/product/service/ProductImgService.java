package com.union.aimei.product.service;

import com.union.aimei.common.model.product.ProductImg;
import com.union.common.utils.ResponseMessage;

/**
 * 项目图片
 *
 * @author liurenkai
 * @time 2018/2/27 14:18
 */
public interface ProductImgService {

    /**
     * 根据项目ID查询项目图片
     *
     * @param productId 项目ID
     * @return
     */
    ResponseMessage<ProductImg> findByProductId(int productId);

}