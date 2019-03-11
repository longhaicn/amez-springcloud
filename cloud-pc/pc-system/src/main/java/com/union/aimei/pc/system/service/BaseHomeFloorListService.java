package com.union.aimei.pc.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseHomeFloorList;
import com.union.aimei.common.vo.system.pc.BaseHomeFloorListVo;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.base.SpringCloudBaseService;

import java.util.List;

/**
 * 楼层列表数据表
 *
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
     * @param floorId
     * @return
     */
    ResponseMessage<PageInfo<BaseHomeFloorListVo>> findByVoPageForFrontV110(Integer pageNo, Integer pageSize, Integer floorId);

    /**
     * 根据floorId更新数据(v1.1.0)
     *
     * @param baseHomeFloorList
     * @return
     */
    ResponseMessage updateByFloorIdV110(BaseHomeFloorList baseHomeFloorList);

    /**
     * 批量添加楼层商品数据(v1.1.0)
     *
     * @param list
     * @return
     */
    ResponseMessage addBatchV110(List<BaseHomeFloorList> list);

    /**
     * 根据楼层id获取已选择的产品
     * @param floorId
     * @param productType
     * @return
     */
    ResponseMessage<List<BaseHomeFloorList>> findByFloorIdV110(Integer floorId, Integer productType);
}