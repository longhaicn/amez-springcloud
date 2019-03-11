package com.union.aimei.product.mapper;

import com.union.aimei.common.model.product.ProductImg;
import com.union.common.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 商品图片
 *
 * @author liurenkai
 * @time 2018/1/12 14:08
 */
public interface ProductImgMapper extends BaseMapper<ProductImg> {

    /**
     * 根据商品ID删除商品图片
     *
     * @param productId 商品ID
     * @return
     */
    int deleteByProductId(@Param(value = "productId") int productId);

    /**
     * 根据商品ID查询商品图片
     *
     * @param productId 商品ID
     * @return
     */
    ProductImg selectByProductId(@Param(value = "productId") int productId);

}