package com.union.aimei.pc.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseRegion;

/**
 * @author liufeihua
 */

public interface BaseRegionService {

    /**
     * 根据id删除
     *
     * @param regionId
     * @return
     */
    int deleteByPrimaryKey(Integer regionId);

    /**
     * 添加
     *
     * @param record
     * @return
     */
    int insertSelective(BaseRegion record);

    /**
     * 查询
     *
     * @param regionId
     * @return
     */
    BaseRegion selectByPrimaryKey(Integer regionId);
    /**
     * 更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseRegion record);
    /**
     * 查询
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseRegion> selectListByConditions(Integer pageNo, Integer pageSize, BaseRegion record);
}