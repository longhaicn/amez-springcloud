package com.union.aimei.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseRegion;
import com.union.aimei.common.vo.system.app.BaseRegionIdByNameResVo;
import com.union.aimei.common.vo.system.app.BaseRegionIdByNameVo;
import com.union.common.utils.ResponseMessage;

import java.util.List;
/**
 * @author liufeihua
 */
public interface BaseRegionService {
    /**
     * 基本操作
     * @param regionId
     * @return
     */
    int deleteByPrimaryKey(Integer regionId);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insertSelective(BaseRegion record);

    /**
     * 基本操作
     * @param regionId
     * @return
     */
    BaseRegion selectByPrimaryKey(Integer regionId);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseRegion record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseRegion> selectListByConditions(Integer pageNo, Integer pageSize, BaseRegion record);

    /**
     * 一次性查询全部全球地区表
     *
     * @return
     */
    List<BaseRegion> findListByConditions();

    /**
     * 根据名称查询ID（省，市，区）
     *
     * @param nameVo 条件
     * @return
     */
    ResponseMessage<BaseRegionIdByNameResVo> getNameByIdV111(BaseRegionIdByNameVo nameVo);

    /**
     * 根据城市ID查询区列表
     *
     * @param cityId 城市ID
     * @return
     */
    ResponseMessage<List<BaseRegion>> listAreaByCityIdV111(int cityId);

}