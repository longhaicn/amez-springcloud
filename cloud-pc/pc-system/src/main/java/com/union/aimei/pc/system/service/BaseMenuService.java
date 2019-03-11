package com.union.aimei.pc.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseMenu;

import java.util.List;

/**
 * @author liufeihua
 */

public interface BaseMenuService {

    /**
     * 根据id删除
     *
     * @param menuId
     * @return
     */
    int deleteByPrimaryKey(Integer menuId);

    /**
     * 添加
     *
     * @param record
     * @return
     */
    int insertSelective(BaseMenu record);

    /**
     * 查询
     *
     * @param menuId
     * @return
     */
    BaseMenu selectByPrimaryKey(Integer menuId);
    /**
     * 更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseMenu record);
    /**
     * 查询
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseMenu> selectListByConditions(Integer pageNo, Integer pageSize, BaseMenu record);

    /**
     * 根据id查询登录时候的菜单
     *
     * @param userId
     * @return
     */
    List<BaseMenu> findLoginMenus(Integer userId);

    /**
     * 查询admin的权限
     *
     * @return
     */
    List<BaseMenu> findAdminLoginMenus();
}