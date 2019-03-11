package com.union.aimei.product.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.ProductCity;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * 项目城市
 *
 * @author liurenkai
 * @time 2018/2/27 14:17
 */
public interface ProductCityService extends SpringCloudBaseService<ProductCity> {
    /**
     * 前端分页查询项目城市
     *
     * @param pageNo      分页索引
     * @param pageSize    每页显示数量
     * @param productCity 查询条件
     * @return
     */
    PageInfo<ProductCity> findByPageForFront(Integer pageNo, Integer pageSize, ProductCity productCity);
}