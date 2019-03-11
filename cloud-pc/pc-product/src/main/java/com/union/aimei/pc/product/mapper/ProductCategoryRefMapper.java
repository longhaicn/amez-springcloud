package com.union.aimei.pc.product.mapper;

import com.union.aimei.common.model.product.ProductCategoryRef;
import com.union.common.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 商品与商品分类关联
 *
 * @author liurenkai
 * @time 2018/1/5 12:09
 */
public interface ProductCategoryRefMapper extends BaseMapper<ProductCategoryRef> {

    /**
     * 根据商品ID删除商品与商品分类关联
     *
     * @param productId 商品ID
     * @return
     */
    int deleteByProductId(@Param(value = "productId") int productId);

    /**
     * 根据商品ID查询商品与商品分类关联
     *
     * @param productId 商品ID
     * @return
     */
    ProductCategoryRef selectByProductId(@Param(value = "productId") int productId);

}