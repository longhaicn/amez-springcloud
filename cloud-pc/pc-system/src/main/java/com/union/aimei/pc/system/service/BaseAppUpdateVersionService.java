package com.union.aimei.pc.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseAppUpdateVersion;

/**
 * @author liufeihua
 */

public interface BaseAppUpdateVersionService {
    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加
     *
     * @param record
     * @return
     */
    int insertSelective(BaseAppUpdateVersion record);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    BaseAppUpdateVersion selectByPrimaryKey(Integer id);
    /**
     * 更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseAppUpdateVersion record);
    /**
     * 查询
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseAppUpdateVersion> selectListByConditions(Integer pageNo, Integer pageSize, BaseAppUpdateVersion record);
}