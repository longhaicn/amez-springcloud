package com.union.aimei.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseHomeArea;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;

/**
 * 首页区域表
 * @author caizhaoming
 * @create 2018-05-23 10:49
 **/
public interface BaseHomeAreaService extends SpringCloudBaseService<BaseHomeArea> {
    /**
     * 前端分页查询首页区域表
     *
     * @param pageNo       分页索引
     * @param pageSize     每页显示数量
     * @param baseHomeArea 查询条件
     * @return
     */
    PageInfo<BaseHomeArea> findByPageForFront(Integer pageNo, Integer pageSize, BaseHomeArea baseHomeArea);


    /**
     * 根据区域数据获取list
     *
     * @param baseHomeArea
     * @return
     */
    ResponseMessage<List<BaseHomeArea>> findForFrontV110(BaseHomeArea baseHomeArea);
}