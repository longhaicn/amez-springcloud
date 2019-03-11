package com.union.aimei.product.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductCategory;
import com.union.aimei.common.vo.common.IdBatchVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;

/**
 * 商品分类
 *
 * @author liurenkai
 * @time 2018/2/27 14:23
 */
public interface ProductCategoryService extends SpringCloudBaseService<ProductCategory> {

    /**
     * 分页查询
     *
     * @param pageNo          分页索引
     * @param pageSize        每页数量
     * @param productCategory 查询条件
     * @return
     */
    ResponseMessage<PageInfo<ProductCategory>> findByPageForFront(Integer pageNo, Integer pageSize, ProductCategory productCategory);

    /**
     * 批量根据ID查询商品分类(v1.1.0)
     *
     * @param idBatchVo 批量ID
     * @return
     */
    ResponseMessage<List<ProductCategory>> findListByIdBatchV110(IdBatchVo idBatchVo);

}