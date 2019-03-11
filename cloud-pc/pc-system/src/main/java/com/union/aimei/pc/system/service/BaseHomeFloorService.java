package com.union.aimei.pc.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseHomeFloor;
import com.union.aimei.common.vo.system.pc.BaseHomeFloorPageVo;
import com.union.aimei.common.vo.system.pc.BaseHomeFloorVo;
import com.union.aimei.common.vo.system.pc.SelectBaseHomeTemplateVo;
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
     * 根据条件删除数据(v1.1.0)
     *
     * @param baseHomeFloor
     * @return
     */
    ResponseMessage deleteByFrontV110(BaseHomeFloor baseHomeFloor);

    /**
     * 批量添加数据(v1.1.0)
     *
     * @param list
     * @return
     */
    ResponseMessage<List<BaseHomeFloor>> addBatchV110(List<BaseHomeFloor> list);

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

    /**
     * 批量更新数据(v1.1.0)
     *
     * @param baseHomeFloorList
     * @return
     */
    ResponseMessage<List<BaseHomeFloor>> editBatchV110(List<BaseHomeFloor> baseHomeFloorList);

    /**
     * 添加模版楼层数据(v1.1.0)
     *
     * @param baseHomeFloorVo
     * @return
     */
    ResponseMessage<List<BaseHomeFloor>> floorDateInsertV110(BaseHomeFloorVo baseHomeFloorVo);
}