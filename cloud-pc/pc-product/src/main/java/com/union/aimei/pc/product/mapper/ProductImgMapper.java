package com.union.aimei.pc.product.mapper;

import com.union.aimei.common.model.product.ProductImg;
import com.union.aimei.common.vo.product.pc.ProductImgByBatchVo;
import com.union.common.utils.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 商品图片
 *
 * @author liurenkai
 * @time 2018/1/5 12:09
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

    /**
     * 批量添加商品图片
     *
     * @param productImgByBatchVo
     * @return
     */
    int addBatch(ProductImgByBatchVo productImgByBatchVo);
}