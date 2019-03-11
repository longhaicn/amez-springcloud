package com.union.aimei.pc.product.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.product.FreightTemplateCity;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * 运费模板城市
 *
 * @author liurenkai
 * @time 2018/3/12 16:34
 */
public interface FreightTemplateCityService extends SpringCloudBaseService<FreightTemplateCity> {

    /**
     * 前端分页查询运费模板城市
     *
     * @param pageNo              分页索引
     * @param pageSize            每页显示数量
     * @param freightTemplateCity 查询条件
     * @return
     */
    PageInfo<FreightTemplateCity> findByPageForFront(Integer pageNo, Integer pageSize, FreightTemplateCity freightTemplateCity);
}