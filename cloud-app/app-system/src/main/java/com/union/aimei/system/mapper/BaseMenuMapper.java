package com.union.aimei.system.mapper;

import com.union.aimei.common.model.system.BaseMenu;
import com.union.aimei.common.model.system.BaseMenuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author liufeihua
 */
public interface BaseMenuMapper {
    /**
     * 基本操作
     * @param example
     * @return
     */
    long countByExample(BaseMenuExample example);
    /**
     * 基本操作
     * @param example
     * @return
     */
    int deleteByExample(BaseMenuExample example);
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
    int insert(BaseMenu record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int insertSelective(BaseMenu record);
    /**
     * 基本操作
     * @param example
     * @return
     */
    List<BaseMenu> selectByExample(BaseMenuExample example);
    /**
     * 基本操作
     * @param menuId
     * @return
     */
    BaseMenu selectByPrimaryKey(Integer menuId);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") BaseMenu record, @Param("example") BaseMenuExample example);
    /**
     * 更新
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") BaseMenu record, @Param("example") BaseMenuExample example);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseMenu record);
    /**
     * 基本操作
     * @param record
     * @return
     */
    int updateByPrimaryKey(BaseMenu record);
    /**
     * 查看
     * @param offset
     * @param limit
     * @return
     */
    List<BaseMenu> selectByPage(@Param("offset") Long offset, @Param("limit") Long limit);
    /**
     * 基本操作
     * @param record
     * @return
     */
    List<BaseMenu> selectListByConditions(BaseMenu record);
}