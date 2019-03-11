package com.union.aimei.pc.product.service;

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
 * @time 2018/1/5 19:34
 */
public interface ProductCategoryService extends SpringCloudBaseService<ProductCategory> {
    /**
     * 前端分页查询商品分类
     *
     * @param pageNo          分页索引
     * @param pageSize        每页显示数量
     * @param productCategory 查询条件
     * @return
     */
    PageInfo<ProductCategory> findByPageForFront(Integer pageNo, Integer pageSize, ProductCategory productCategory);

    /**
     * 批量根据ID查询商品分类(v1.1.0)
     *
     * @param idBatchVo 批量ID
     * @return
     */
    ResponseMessage<List<ProductCategory>> findListByIdBatchV110(IdBatchVo idBatchVo);

}