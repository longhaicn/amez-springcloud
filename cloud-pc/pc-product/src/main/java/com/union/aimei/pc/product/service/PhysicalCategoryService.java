package com.union.aimei.pc.product.service;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.PhysicalCategory;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
public interface PhysicalCategoryService extends SpringCloudBaseService<PhysicalCategory> {
    /**
     * 前端分页查询产品分类
     *
     * @param pageNo           分页索引
     * @param pageSize         每页显示数量
     * @param physicalCategory 查询条件
     * @return
     */
    PageInfo<PhysicalCategory> findByPageForFront(Integer pageNo, Integer pageSize, PhysicalCategory physicalCategory);
}