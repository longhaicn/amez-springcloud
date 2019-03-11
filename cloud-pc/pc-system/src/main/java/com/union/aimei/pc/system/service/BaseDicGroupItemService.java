package com.union.aimei.pc.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseDicGroupItem;

/**
 * @author liufeihua
 */

public interface BaseDicGroupItemService {

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
    int insertSelective(BaseDicGroupItem record);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    BaseDicGroupItem selectByPrimaryKey(Integer id);
    /**
     * 更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseDicGroupItem record);
    /**
     * 查询
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseDicGroupItem> selectListByConditions(Integer pageNo, Integer pageSize, BaseDicGroupItem record);
}