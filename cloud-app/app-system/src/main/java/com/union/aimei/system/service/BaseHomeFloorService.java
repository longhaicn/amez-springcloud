package com.union.aimei.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseHomeFloor;
import com.union.aimei.common.vo.system.app.BaseHomeFloorPageVo;
import com.union.aimei.common.vo.system.app.SelectBaseHomeTemplateVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;

/**
 * 查询楼层管理表
 *
 * @author caizhaoming
 * @create 2018-05-23 10:49
 **/
public interface BaseHomeFloorService extends SpringCloudBaseService<BaseHomeFloor> {
    /**
     * 前端分页查询楼层管理表
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param baseHomeFloor 查询条件
     * @return
     */
    PageInfo<BaseHomeFloor> findByPageForFront(Integer pageNo, Integer pageSize, BaseHomeFloor baseHomeFloor);

    /**
     * 根据条件获取列表数据(v1.1.0)
     *
     * @param baseHomeFloor
     * @return
     */
    ResponseMessage<List<BaseHomeFloor>> findForFrontV110(BaseHomeFloor baseHomeFloor);


    /**
     * 获取模版页面的楼层数据(v1.1.0)
     *
     * @param pageNo
     * @param pageSize
     * @param selectBaseHomeTemplateVo
     * @return
     */
    ResponseMessage<PageInfo<BaseHomeFloorPageVo>> findPageFloorDateV110(Integer pageNo, Integer pageSize, SelectBaseHomeTemplateVo selectBaseHomeTemplateVo);

}