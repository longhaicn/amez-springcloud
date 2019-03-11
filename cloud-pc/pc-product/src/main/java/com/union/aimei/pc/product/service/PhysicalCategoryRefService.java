package com.union.aimei.pc.product.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.PhysicalCategoryRef;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * @author caizhaoming
 * @version 1.1
 * @create 2018-06-21 11:43
 **/
public interface PhysicalCategoryRefService extends SpringCloudBaseService<PhysicalCategoryRef> {
    /**
     * 前端分页查询产品-产品分类-关联
     *
     * @param pageNo              分页索引
     * @param pageSize            每页显示数量
     * @param physicalCategoryRef 查询条件
     * @return
     */
    PageInfo<PhysicalCategoryRef> findByPageForFront(Integer pageNo, Integer pageSize, PhysicalCategoryRef physicalCategoryRef);
}