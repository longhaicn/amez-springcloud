package com.union.aimei.pc.product.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductCategoryRef;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * 商品-商品分类-关联
 *
 * @author liurenkai
 * @time 2018/1/5 19:34
 */
public interface ProductCategoryRefService extends SpringCloudBaseService<ProductCategoryRef> {
    /**
     * 前端分页查询商品-商品分类-关联
     *
     * @param pageNo             分页索引
     * @param pageSize           每页显示数量
     * @param productCategoryRef 查询条件
     * @return
     */
    PageInfo<ProductCategoryRef> findByPageForFront(Integer pageNo, Integer pageSize, ProductCategoryRef productCategoryRef);

    /**
     * 新增商品-商品分类-关联
     *
     * @param productCategoryRef 商品-商品分类-关联
     * @return
     */
    ResponseMessage add(ProductCategoryRef productCategoryRef);

}