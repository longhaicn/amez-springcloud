package com.union.aimei.pc.product.mapper;

import com.union.aimei.common.model.product.ProductCategory;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;

/**
 * 商品分类
 *
 * @author liurenkai
 * @time 2018/1/5 12:08
 */
public interface ProductCategoryMapper extends BaseMapper<ProductCategory> {

    /**
     * 批量根据ID查询商品分类
     *
     * @param idBatchVo
     * @return
     */
    List<ProductCategory> selectListByIdBatch(IdBatchVo idBatchVo);

}