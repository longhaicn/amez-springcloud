package com.union.aimei.pc.product.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductPhysicalCategoryRef;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * 产品-分类-关联
 *
 * @author liurenkai
 * @time 2018/2/28 15:50
 */
public interface ProductPhysicalCategoryRefService extends SpringCloudBaseService<ProductPhysicalCategoryRef> {
    /**
     * 前端分页查询产品-分类-关联
     *
     * @param pageNo                     分页索引
     * @param pageSize                   每页显示数量
     * @param productPhysicalCategoryRef 查询条件
     * @return
     */
    PageInfo<ProductPhysicalCategoryRef> findByPageForFront(Integer pageNo, Integer pageSize, ProductPhysicalCategoryRef productPhysicalCategoryRef);
}