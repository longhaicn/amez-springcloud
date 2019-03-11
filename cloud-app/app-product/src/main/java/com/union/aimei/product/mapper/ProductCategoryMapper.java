package com.union.aimei.product.mapper;

import com.union.aimei.common.model.product.ProductCategory;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.common.utils.base.BaseMapper;

import java.util.List;

/**
 * 项目分类
 *
 * @author liurenkai
 * @time 2018/2/27 14:11
 */
public interface ProductCategoryMapper extends BaseMapper<ProductCategory> {

    /**
     * 批量根据ID查询项目分类
     *
     * @param idBatchVo
     * @return
     */
    List<ProductCategory> selectListByIdBatch(IdBatchVo idBatchVo);

    /**
     * 顶级项目分类列表
     *
     * @return
     */
    List<ProductCategory> listTop();

}