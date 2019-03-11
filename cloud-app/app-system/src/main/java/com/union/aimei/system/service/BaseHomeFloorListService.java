package com.union.aimei.system.service;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseHomeFloorList;
import com.union.aimei.common.vo.system.app.BaseHomeFloorListVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

/**
 * 楼层列表数据表
 * @author caizhaoming
 * @create 2018-05-23 10:49
 **/
public interface BaseHomeFloorListService extends SpringCloudBaseService<BaseHomeFloorList> {
    /**
     * 前端分页查询楼层列表数据表
     *
     * @param pageNo            分页索引
     * @param pageSize          每页显示数量
     * @param baseHomeFloorList 查询条件
     * @return
     */
    PageInfo<BaseHomeFloorList> findByPageForFront(Integer pageNo, Integer pageSize, BaseHomeFloorList baseHomeFloorList);

    /**
     * 获取 BaseHomeFloorListVo 分页列表数据
     *
     * @param pageNo
     * @param pageSize
     * @param baseHomeFloorListVo
     * @return
     */
    ResponseMessage<PageInfo<BaseHomeFloorListVo>> findByVoPageForFrontV110(Integer pageNo, Integer pageSize, BaseHomeFloorListVo baseHomeFloorListVo);
}