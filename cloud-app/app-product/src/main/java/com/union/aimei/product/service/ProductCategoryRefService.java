package com.union.aimei.product.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductCategoryRef;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * 项目分类
 *
 * @author liurenkai
 * @time 2018/2/27 14:15
 */
public interface ProductCategoryRefService extends SpringCloudBaseService<ProductCategoryRef> {

    /**
     * 前端分页查询
     *
     * @param pageNo             分页索引
     * @param pageSize           每页显示数量
     * @param productCategoryRef 查询条件
     * @return
     */
    PageInfo<ProductCategoryRef> findByPageForFront(Integer pageNo, Integer pageSize, ProductCategoryRef productCategoryRef);

    /**
     * 根据项目ID查询项目-分类-关联
     *
     * @param productId 项目ID
     * @return
     */
    ResponseMessage<ProductCategoryRef> getByProductId(int productId);

}