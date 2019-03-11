package com.union.aimei.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseMenu;
/**
 * @author liufeihua
 */
public interface BaseMenuService {
    /**
     * 基本操作
     * @param menuId
     * @return
     */
    int deleteByPrimaryKey(Integer menuId);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insertSelective(BaseMenu record);

    /**
     * 基本操作
     * @param menuId
     * @return
     */
    BaseMenu selectByPrimaryKey(Integer menuId);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseMenu record);
    /**
     * 查看
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseMenu> selectListByConditions(Integer pageNo, Integer pageSize, BaseMenu record);
}