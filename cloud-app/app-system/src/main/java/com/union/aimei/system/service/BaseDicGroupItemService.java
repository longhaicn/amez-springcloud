package com.union.aimei.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseDicGroupItem;

import java.util.List;
/**
 * @author liufeihua
 */
public interface BaseDicGroupItemService {
    /**
     * 基本操作
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insertSelective(BaseDicGroupItem record);
    /**
     * 基本操作
     * @param id
     * @return
     */
    BaseDicGroupItem selectByPrimaryKey(Integer id);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseDicGroupItem record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseDicGroupItem> selectListByConditions(Integer pageNo, Integer pageSize, BaseDicGroupItem record);

    /**
     * 根据字典code来查询子项
     *
     * @param bandCode
     * @return
     */
    List<BaseDicGroupItem> findListByCode(String bandCode);
}